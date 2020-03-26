package tset;

public class CountObject {
     volatile int num;
     synchronized void plusOne(){

         if(this.num>1)
             this.notifyAll();
         this.num=this.num+1;
         System.out.println("num的值被加一后为:"+this.num);

    }
    synchronized void minusOne(){
        try{
            if(this.num ==1){
                this.wait();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

            this.num=this.num-1;
        System.out.println("num的值被减一后为:"+this.num);

    }
    void printNum(){
            System.out.println(this.num);
    }
}

