package Exp5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class ClientReadHandler extends Thread {
    private final InputStream inputStream;
    ClientReadHandler(InputStream inputStream){
        this.inputStream=inputStream;
    }
    public void run(){
        super.run();
        try{
            //得到输入流，用于接收数据
            BufferedReader socketInput= new BufferedReader(new InputStreamReader(inputStream));
            for(;;){
                //客户端拿到一条数据
                String str=socketInput.readLine();
                if(str ==null){
                    System.out.println("客户端已无法读取数据！");
                    break;
                }
                System.out.println(str);

            }
        }catch (Exception e){
            System.out.println("客户端收到消息"+e);
        }
    }
}
