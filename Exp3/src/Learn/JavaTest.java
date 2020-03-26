package Learn;
public class JavaTest {

    public void test() {
        final Object lockA = new Object();
        final Object lockB = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB) {
                    }
                    System.out.println("finish A");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA) {
                    }
                    System.out.println("finish B");
                }
            }
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        JavaTest ob1 =new JavaTest();
        ob1.test();
    }
}