package tset;

public class TestInteract {
    public static void main(String[] args){
        CountObject item1 = new CountObject();
        item1.num=100;

            Thread t1 = new Thread(){
                public void run(){
                    while(true){
                        item1.minusOne();
                        try{
                            Thread.sleep(10);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            };
            Thread t2 = new Thread(){
                public void run(){
                    while(true){
                        item1.plusOne();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            t1.start();
            t2.start();









    }
}
