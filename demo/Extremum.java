package array.Test1;

public class TestFunctions {
    //设计一个方法寻找数组中的极值，需要返回一个值（最大或者最小）
    //flag==true最大值，else最小值
    public int findMaxOrMinNum(int[] array, boolean flag) {
        //定义一个临时变量
        int temp = array[0];
        //遍历数组的方式挨个与max比较
        for (int i = 1; i < array.length; i++) {
            if (flag && array[i] > temp) {
                    temp = array[i];
                } else if (!flag && array[i] < temp) {
                        temp = array[i];
                }
            }
        return temp;
    }
    
    public static void main(String[] args) {
        //创建一个对象
        TestFunctions functions = new TestFunctions();
        //定义一个数组
        int[] array = new int[]{100 , 4, 256,45, 6, 52};
       //调用对象中的方法
        int result = functions.findMaxOrMinNum(array,false);
        System.out.println(result);
    }
}
