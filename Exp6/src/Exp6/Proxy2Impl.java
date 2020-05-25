package Exp6;

public class Proxy2Impl implements IProxy2 {
    public String sayHello(String s){
        return "Hello"+s;
    }
    public String upperString(String s){
        return s.toUpperCase();
    }
}
