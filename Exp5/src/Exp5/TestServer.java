package Exp5;
import java.io.IOException;
import java.util.Scanner;

public class TestServer {
    private static final int PORT=9090;
    public static void main(String[] args) throws IOException{
        //
        Server server =new Server(PORT);
        server.start();

        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            server.broadcast(s);
        }
    }


}
