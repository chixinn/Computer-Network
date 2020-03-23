import java.util.Scanner;
public class IO {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double line = sc.nextInt();
            System.out.println("收到的字符串为:"+line);//注意这个地方的这个加号的特殊用法
        }

    }
}
