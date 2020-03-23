import java.util.Arrays;
public class Arraytool {
    // main fangfa
    public static void main(String[] args){
        int a[] = new int[] {18,62,68,82,65,9};
        System.out.println("Before");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("After");
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a,62) );
    }
    //关于使用array.sort()时，integer和int的传输有什么区别
    //- array.sort()源码使用的底层机制
    //- interger和int的区别
}
