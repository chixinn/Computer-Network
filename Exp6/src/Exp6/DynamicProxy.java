package Exp6;

import javax.print.attribute.standard.JobKOctets;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private Object obj;//被代理类的引用
    public DynamicProxy(Object obj){
        this.obj=obj;
    }
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
        before();
        Object result=method.invoke(obj,args);//反射:参数1为实现类/参数2为方法参数
        after();
        return result;
    }
    private void before(){
        System.out.println("小B加上报告头");
    }
    private void after(){
        System.out.println("小B加上报告尾");
    }
}
