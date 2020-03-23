public class Str {
    public  static  void main (String[] args){
       String str1 = "the light";
       String str2 = str1;//使用等号进行赋值
       String str3 = new String(str1);//通过一个字符串，创建另一个字符串对象
       String str4 = "the light";
       String str5 = "the "+"light";//the后面的空格
       System.out.println(str1 == str2);//比较等号赋值
       System.out.println(str1 == str3);//比较new
       System.out.println(str1 == str4);//直接比较
       System.out.println(str1 == str5);//比较+的连接
       System.out.println(str1.equals(str4));
       //supplementary
        System.out.println(str1.equals(str3));


    }

}
