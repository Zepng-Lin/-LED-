import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
	//指令 python led.py 1 ; 1为参数
    private static String[] arguments = new String[] {"python", "led.py","1"};
    public static void main(String[] args) throws IOException {
		//填入服务器的地址和端口号
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));

		//读取服务器传来的数据，并调用LedHandle执行对应的操作
        while (true){
            ByteBuffer buffer = ByteBuffer.allocate(1);
            socketChannel.read(buffer);
            String s = new String(buffer.array());
            LedHandle(s);
        }
    }
	//s == "1" 时开灯，"0" 时关灯
    private static void LedHandle(String s){
		//修改参数
        arguments[2] = s;
        try {
			//执行指令
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),
                    "GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
            //返回值为1表示调用python脚本失败
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

