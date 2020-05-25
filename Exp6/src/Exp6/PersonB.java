package Exp6;

public class PersonB implements IProxy {
    //被代理者的引用
    private IProxy mPerson;
    public PersonB(IProxy person){
        mPerson=person;
    }
    public void submit(){
        before();
        mPerson.submit();
        after();
    }
    public void before(){
        System.out.println("小B加上报告头");
    }
    public void after(){
        System.out.println("小B加上报告尾");
    }
}
