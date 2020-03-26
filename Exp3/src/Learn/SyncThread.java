package Learn;
//相当于创建了一个线程类
public class SyncThread implements Runnable {
    private static int count;
    public SyncThread(){
        count=0;
    }
    public void run(){
        synchronized (this){
            for(int i=0;i<5;i++){
                try{
                    System.out.println(Thread.currentThread().getName()+":"+(count++) );
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }//synchronized代码块，作用范围是调用这个代码快的对象
    }
    public int getCount(){
        return count;
    }
}
