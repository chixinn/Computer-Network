public class Array {
    public static void main(String[] args){
        int [] a = new int[] {100,102,444,836,3236}; //类比于C++的开辟空间
        int [] b = {100,102,444,836,3236};
        //int [] c = new int[3]{100,102,444};//即使是有三个也不行
        //利用control flow中所学到的流成控制中的加强的for
        for(int i: a){
            System.out.print(i+ " ");
        }
        System.out.println();
        //什么是只能取值而不能用来改变数组的值，是因为我们没有索引了。
        for (int i: a){
            System.out.println(i+1);
        }
        System.out.println(a[0]);//由打印结果显示a[0]的值并没有被改变

    }
}
