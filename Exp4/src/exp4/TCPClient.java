package exp4;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
//java 在net包
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static final int PORT = 9090;//定义端口
    public static void main(String[]args) throws IOException{
        Socket socket=new Socket();
        //连接到本地9090端口
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),PORT),3000);
        System.out.println("客户端为："+socket.getLocalAddress()+":"+socket.getLocalPort());//客户端gerlocal address
        System.out.println("服务器为："+socket.getInetAddress()+":"+socket.getPort());//服务器

        InputStream inputStream=socket.getInputStream();
        OutputStream outputStream=socket.getOutputStream();
        System.out.println("Please putin the message");
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            outputStream.write(s.getBytes());
            byte[] bytes=new byte[1024];
            //接收服务器返回的消息
            int len =inputStream.read(bytes);
            StringBuilder sb= new StringBuilder();
            sb.append(new String(bytes,0,len));
            System.out.println("收到服务端消息："+sb.toString());
        }



            outputStream.close();
            inputStream.close();
            socket.close();
            System.out.println("客户端已退出~");

        /*String s="test client send";
        outputStream.write(s.getBytes());*/

        //释放资源


    }

}
