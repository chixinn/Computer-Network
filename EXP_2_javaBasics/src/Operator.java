public class Operator {
    public static void main(String[] args) {//注意主方法的含义的理解
        int a = 1;
        int b = 3;
        System.out.println(b%a);
        int result = temp(a,b);
        System.out.println(temp(a,b));
        System.out.println(result);

    }

   static int temp(int a, int b) {//这个地方添加了static以后就不会再报错了
        return a == 0 ? b : temp(b % a, a);
    }//在主方法里创建别的方法？

}