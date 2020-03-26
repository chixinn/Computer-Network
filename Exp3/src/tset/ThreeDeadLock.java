package tset;

public class ThreeDeadLock {
    public static void main(String[] args){
        dead_lock();
    }
    private static void dead_lock(){
        final Object res1="res1";
        final Object res2="res2";
        Thread t1= new Thread(){
            public void run(){
                synchronized (res1) {
                    System.out.println("t1 lock res1");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (res2) {
                        System.out.println("t1 lock res2");
                    }
                }
            }
        };
        Thread t2= new Thread(){
            public void run(){
                synchronized (res2) {
                    System.out.println("t2 lock res2");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (res1) {
                        System.out.println("t2 lock res1");
                    }
                }
            }
        };
        t1.start();
        t2.start();



    }
}
