package exp3;

public class TestCount {
  public static void  main(String[] args){
      CountObject item = new CountObject();
      item.num=1000;
      int n=1000;
      MinusCount operation1=new MinusCount(item);
      PlusCount operation2=new PlusCount(item);
      Thread[] addThreads = new Thread[n];
      Thread[] reduceThreads = new Thread[n];
      for(int i=0;i<n;i++){
        Thread t1=new Thread(operation1);
        Thread t2=new Thread(operation2);
        t1.start();
        t2.start();
        reduceThreads[i]=t1;
        addThreads[i]=t2;
      }

      for(Thread t:reduceThreads){
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
