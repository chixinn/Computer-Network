package Exp5;

import java.io.IOException;
import java.net.Socket;
/*收发并行*/
/*将收发独立成readhandler和writehandler*/
/*将输入和输出分开，使他们并行而非互相阻塞*/
class ClientHandler extends Thread{
    private Socket socket;
    private final ClientReadHandler readHandler;
    private final ClientWriteHandler writeHandler;

    ClientHandler(Socket socket) throws IOException{
        this.socket=socket;
        this.readHandler=new ClientReadHandler(socket.getInputStream());
        this.writeHandler=new ClientWriteHandler(socket.getOutputStream());

    }
    public void run() {
        super.run();//一旦有readhandler就要启动起来。
        readHandler.start();
    }
    public void send(String str){
        writeHandler.send(str);
    }
}
