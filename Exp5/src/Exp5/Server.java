package Exp5;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final int port;
    private ClientListener clientListener;//将阻塞监听的从main函数中t出来
    private List<ClientHandler> clientHandlerList =new ArrayList<>();//便利数组，给客户端发送

    public Server(int port){
        this.port=port;
    }
    public void start()throws IOException{
        clientListener=new ClientListener(port);
        clientListener.start();
    }//用一个线程接管监听
    public void broadcast(String str){
        for(ClientHandler clientHandler:clientHandlerList){
            clientHandler.send(str);
        }
    }
    private class ClientListener extends Thread{
        private ServerSocket server;
        ClientListener(int port) throws IOException{
            server =new ServerSocket(port);
        }
        public void run(){
            super.run();
            System.out.println("阻塞等待客户端连接中...");
            for(;;){
                Socket client;
                try{
                    client=server.accept();//监听
                    ClientHandler clientHandler=new ClientHandler(client);//一旦有客户端连接了，用其他线程和他交互处理
                    //读取数据并打印
                    clientHandler.start();
                    clientHandlerList.add(clientHandler);//客户端的clienthandler加入到服务端的数组中
                }catch(IOException e){
                    e.printStackTrace();
                    System.out.println("客户端连接异常:"+e.getMessage());
                }
            }
        }
    }
}
