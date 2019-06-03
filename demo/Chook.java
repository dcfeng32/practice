package rabbit;

public class chook {
    //公鸡5元 ，母鸡3元 ，小鸡3只1元，求解100元买100只小鸡的方案
    //i        j         3*k  k
    public static void main(String[] args) {
        int count = 1;
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 33; j++) {
                //也可以k+=3，或者加判定条件k%3==0,在输出k
                for (int k = 0; k <= 100; k++) {
                    //三元一次方程的解不唯一
                    if (i + j + 3 * k == 100 && 5 * i + 3 * j + k == 100) {
                        System.out.print("方案："+count+"  ");
                        System.out.print("公鸡是：" + i + "，");
                        System.out.print("母鸡是：" + j + "，");
                        System.out.println("小鸡是：" + 3 * k);
                        count++;
                    }
                }
            }
        }
    }
}




