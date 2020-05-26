package com.zepnglin.pi_led.nio;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

@Component
public class LedConnect {
    private SocketChannel socketChannel;
    private ServerSocketChannel serverSocketChannel;

    /**
     * 监听端口，程序阻塞，直到有连接进来
     */
    public LedConnect() {
        try {

            serverSocketChannel = ServerSocketChannel.open();
            //监听端口
            serverSocketChannel.bind(new InetSocketAddress(8888));
            //阻塞等待连接
            socketChannel = serverSocketChannel.accept();
        } catch (IOException e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
    }
    public void turnOn(){
        sendMsg("1");
        System.out.println("发送命令 ：on");
    }
    public void turnOff(){
        sendMsg("0");
        System.out.println("发送命令 ：off");
    }
    //发送消息
    private void sendMsg(String s){
        try {
            socketChannel.write(ByteBuffer.wrap(s.getBytes()));
        } catch (IOException e) {
            System.out.println("发送命令失败");
            e.printStackTrace();
        }
    }
}
