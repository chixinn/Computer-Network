package exp4;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.UUID;

//UDP receiver/Server

public class UDPProvider {
    public static void main(String[]args) throws IOException{
        System.out.println("Provider Started");


        //选择一个端口
        DatagramSocket ds=new DatagramSocket(9091);

        SearcherHandler searcherHandler=new SearcherHandler(ds);
        searcherHandler.start();

    }
    private static class SearcherHandler extends Thread{
        private  DatagramSocket ds;
        SearcherHandler(DatagramSocket ds){
            this.ds=ds;
        }
        public void run(){
            try{
                //创建接收类型的数据报，数据将存储在buf中
                byte[]buf =new byte[1024];
                DatagramPacket receivePack = new DatagramPacket(buf,buf.length);
                //通过套接字接收数据
                ds.receive(receivePack);

                String ip=receivePack.getAddress().getHostAddress();

                //将pack进行解析

                int len=receivePack.getLength();
                String data=new String(receivePack.getData(),0,len);
                int port =MessageUtil.parsePort(data);//解析收到的消息并得到要回写的端口。
                String tag = UUID.randomUUID().toString();//tag
                System.out.println("receive from ip"+ip+"\tport:"+port+"\tdata:"+data);

                //回送数据
                String responseData=MessageUtil.buildWithTag(tag);
                DatagramPacket responsePacket = new DatagramPacket(
                        responseData.getBytes(),
                        responseData.length() ,
                        receivePack.getAddress(),
                        receivePack.getPort()
                );//解析收到的包
                ds.send(responsePacket);
                System.out.println("Provider finished");


            }catch(Exception e){
                System.out.println("Connection exception aborted!");
            }finally{
                try{
                    ds.close();
                }catch(Exception e){
                    System.out.println("Close exception aborted!");
                }
            }

        }

    }

}
