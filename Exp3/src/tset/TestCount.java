package tset;

public class TestCount {
    public static void  main(String[] argv){
        CountObject item = new CountObject();

        item.num=1000;
        int n=1000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
        for(int i=0;i<n;i++){
            Thread t1=new Thread(){
                public void run() {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        item.plusOne();
                        item.printNum();

                }
            };
            Thread t2=new Thread(){
                    public void run () {

                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            item.minusOne();
                            item.printNum();
                        }
            };

                t1.start();
                addThreads[i]=t1;


                t2.start();
                reduceThreads[i]=t2;


        }
        for(Thread t: reduceThreads){
            try{
                t.join();//Thread类的join的使用方法有待考证
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        for(Thread t:addThreads){
            try{
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.print("finally num = ");
        item.printNum();

    }
}
