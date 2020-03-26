package Learn;

public class TestSyncThread {
    public static void main(String[] args){
        SyncThread syncThread = new SyncThread();
        Thread thread1=  new Thread(syncThread,"SyncThread1");//
        //Thread1执行同步代码块时，锁定了对象（这里的对象是线程类的一个对象)
        Thread thread2=  new Thread(syncThread,"SyncThread2");//
        thread1.start();
        thread2.start();
        /*
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();

        */
    }
}
