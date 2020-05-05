package Exp5;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class TCPClient {
    private static final int PORT = 9090;
    public static void main(String []args) throws IOException{
        Socket socket = new Socket();
        //连接本地9090端口，timeout为3000ms
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),PORT),3000);
        System.out.println("客户端为："+socket.getLocalAddress()+":"+socket.getLocalPort());
        System.out.println("服务器为："+socket.getInetAddress()+":"+socket.getLocalPort());
        ClientHandler serverHandler=new ClientHandler (socket);
        serverHandler.start();
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String s =sc.nextLine();
            serverHandler.send(s);
        }
        /*InputStream inputStream=socket.getInputStream();
        OutputStream outputStream=socket.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(outputStream);
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(inputStream));*/
       /* Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String input =sc.nextLine();
            socketPrintStream.println(input);
            //接收服务器返回的消息
            String s=socketInput.readLine();
            System.out.println("收到服务端消息"+s);
        }//这个scanner会对消息进行阻塞
        outputStream.close();
        inputStream.close();*/
        socket.close();
        System.out.println("客户端已退出～");
    }
}
