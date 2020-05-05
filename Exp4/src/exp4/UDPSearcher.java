package exp4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//Sender
public class UDPSearcher {
    public static void main(String[]args)throws IOException{
        System.out.println("Getter Started");
        //搜索方不需要制定监听端口

        DatagramSocket ds=new DatagramSocket();

        //发送数据
        String sendData =MessageUtil.buildWithPort(30000);//使用MessageUtil构建数据
        byte[] sendBytes=sendData.getBytes();

        DatagramPacket sendPack=new DatagramPacket(sendBytes,sendBytes.length,InetAddress.getByName("255.255.255.255"),9091);
        ds.send(sendPack);
        //接收回送数据
        byte[]buf=new byte[1024];
        DatagramPacket receivePack=new DatagramPacket(buf,buf.length);
        ds.receive(receivePack);
        //解析ip地址
        String ip=receivePack.getAddress().getHostAddress();
        //解析port
        int port=receivePack.getPort();
        int len=receivePack.getLength();
        String tag=new String(receivePack.getData(),0,len);
        String data=MessageUtil.parseTag(tag);
        System.out.println("receive from ip:"+ip+"\tport:"+port+"\tdata:"+tag);
        System.out.println("Searcher finished");
        ds.close();

    }
}
