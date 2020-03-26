package tset;

public class TestDeadLock {
    public static void main(String[] args){
        CountObject item1=new CountObject();
        CountObject item2=new CountObject();
        CountObject item3=new CountObject();


        Thread t1 = new Thread(){
            public void run(){
                synchronized (item1){
                    System.out.println("t1 占用item1");
                    try{
                        Thread.sleep(1000);
                        //这里的停顿是为了模仿CPU的计算时间
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t1试图占用item2");
                    System.out.println("t1等待中");
                    synchronized (item2){
                        System.out.println("t1 获取item2成功");
                        System.out.println("t1试图占用item3");
                        System.out.println("t1等待中");
                        //T1用完2，需要3才能继续运行
                        synchronized (item3){
                            System.out.println("t1 获取item3成功");
                        }
                    }
                }
                //T1率先占用1,继续运行需要2

            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                synchronized (item2){
                    System.out.println("t2 占用item2");
                    try{
                        Thread.sleep(1000);
                        //这里的停顿是为了模仿CPU的计算时间
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t2试图占用item3");
                    System.out.println("t2等待中");
                    synchronized (item3){
                        System.out.println("t2 lock item3");
                        System.out.println("t2试图占用item1");
                        System.out.println("t2等待中");
                        synchronized (item1){
                            System.out.println("t2 lock item1");
                        }
                    }

                }


            }
        };
        t2.start();
        Thread t3 = new Thread(){
            public void run(){
                synchronized (item3){
                    System.out.println("t3 占用item3");
                    try{
                        Thread.sleep(1000);
                        //这里的停顿是为了模仿CPU的计算时间
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t3试图占用item1");
                    System.out.println("t3等待中");
                    synchronized (item1){
                        System.out.println("t3 获取item1");
                        System.out.println("t3试图占用item2");
                        System.out.println("t3等待中");
                        synchronized (item2){
                            System.out.println("t3 获取item2");
                        }
                    }

                }

            }
        };
        t3.start();



    }
}
