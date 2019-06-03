import com.sun.org.apache.xpath.internal.FoundIndex;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Practice5 {
    //打印金字塔，菱形，空心菱形，火影镖
    public static void main(String[] args) {
        Scanner W = new Scanner(System.in);
        System.out.println("请选择需要打印的图形：");
        System.out.println("金字塔-1，菱形-2，空心菱形-3，火影镖-4");
        int type = W.nextInt();
        System.out.println("请选择需要打印的行数：");
        int num = W.nextInt();
        switch (type) {
            case 1:
                print1(num);
                break;
            case 2:
                print2(num);
                break;
            case 3:
                print3(num);
                break;
            case 4:
                print4(num);
                break;
            default:
                System.out.println("你个笨蛋，请重新选择图形！");
        }
    }

    public static void print1(int s) {
        for (int i = 1; i <= s; i++) {
            for (int j = 0; j <= s - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void print2(int s) {
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j < s - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = s - 1; i > 0; i--) {
            for (int j = 0; j < s - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print3(int s) {
        for (int i = 1; i <= s; i++) {
            for (int j = 0; j < s - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j > 1 && j < 2 * i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = s - 1; i > 0; i--) {
            for (int j = 1; j <= s - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j > 1 && j < 2 * i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");

                }
            }
            System.out.println();
        }
    }

    public static void print4(int s) {
        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= s - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j > i && j < 2 * i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = s - 1; i > 0; i--) {
            for (int j = 1; j <= s - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j > 1 && j < i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }

}
