package Exp6;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String [] args){
        //构造一个小A
        IProxy personA = new PersonA();
        //构造一个代理小B将小A作为构造参数进行传递
  //      IProxy personB= new PersonB(personA );
        //小B提交报告
 //       personB.submit();
        DynamicProxy proxy = new DynamicProxy(personA);
        //获取被代理类小A的ClassLoader
        ClassLoader loader = personA.getClass().getClassLoader();
        //动态构造一个代理者小B
        IProxy personB=(IProxy) Proxy.newProxyInstance(loader,new Class[]{IProxy.class},proxy);
        personB.submit();
    }
}
