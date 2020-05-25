package Exp6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RPCServer {
    public static void main(String[] args) {
        Proxy2Impl service = new Proxy2Impl();
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(9091));
            for (; ; ) {
                Socket accept = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(accept,service);
                clientHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//绑定端口号
    }
    public static class ClientHandler extends Thread {
        private Socket accept;
        Proxy2Impl service;
        ClientHandler(Socket accept,Proxy2Impl service){
            this.accept=accept;
            this.service=service;
        }
        public  void run() {
            super.run();
            try{
                ObjectInputStream is = new ObjectInputStream(accept.getInputStream());
                String methodName = is.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) is.readObject();
                Object[] arguments = (Object[]) is.readObject();
                Object result = Proxy2Impl.class.getMethod(methodName, parameterTypes).invoke(service, arguments);
                new ObjectOutputStream(accept.getOutputStream()).writeObject(result);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}











