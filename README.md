# 远程控制树莓派LED灯

## 实现功能

通过浏览器访问WEB页面，实现对 远程端树莓派上的 LED灯进行控制

## 所需材料和技术栈

云服务器 、树莓派 、LED灯、Springboot（Spring 、Spring MVC）

## 整体流程

1. 服务器端运行Springboot jar包，开启等待树莓派连接，此时WEB端无法访问
2. 树莓派端 运行 Client.java，建立与服务器的SocketChannel连接,jar包运行完成，可通过WEB端访问
3. 如果浏览器通过网址 访问 服务器，可得到两个 超链接 ，分别对应 LED的开和关，点击 超链接，访问对应 的 servlet，向树莓派端发送指令
4. 树莓派 Client.java 接J收到 指令 后，将指令作为参数，调用 led.py，控制 LED的开关 

