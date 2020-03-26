package Interact;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private List list = new ArrayList<>();
    public void add(){
        list.add("chichi");
    }
    public int size(){
        return list.size();
    }
    public static void main(String[]args){
        final Test test = new Test();
        final Object lock = new Object();
        Thread t1= new Thread (){

                public void run(){
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (lock){
                        for(int i=0;i<10;i++){
                            test.add();
                            System.out.println("当前线程"+Thread.currentThread().getName()+"添加了一个元素");

                            if(test.size()==5){
                                System.out.println("已notify");
                                lock.notify();//synchronized不放锁
                        }
                        }
                    }
            }
        };
        Thread t2= new Thread (){
            public void run() {
                synchronized (lock) {
                    if(test.size()!=5){
                        try{
                            System.out.println("进入t2");
                            lock.wait();
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println("当前线程收到通知"+Thread.currentThread().getName()+"listzie=5停止");
                    }

                }

            }
        };
        t1.start();
        t2.start();



    }
}
