package exp3;

public class MinusCount implements Runnable{
    private CountObject item;
    MinusCount(CountObject item){
        this.item=item;
    }
    public void run(){

        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        item.minusOne();
        item.printNum();
    }
}
