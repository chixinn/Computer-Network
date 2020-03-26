package exp3;

public class PlusCount implements Runnable{
    private CountObject item;
    public PlusCount(CountObject item){
        this.item=item;
    }
    public void run(){

        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        item.plusOne();
        item.printNum();
    }

}
