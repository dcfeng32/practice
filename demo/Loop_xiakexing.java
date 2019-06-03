package xiakexing;

import javax.xml.ws.spi.http.HttpHandler;
import java.util.Scanner;

public class wu {
    public static void main(String[] args) {
        String name = "小虾米";
        int Lv = 1;
        int age = 12;
        int hp = 100;
        int mp = 100;
        int attack = 100;
        int defense = 100;
        int energy = 100;
        System.out.print("名字是：" + name);
        System.out.println("       年龄：" + age);
        System.out.print("生命值：" + hp);
        System.out.println("         法术值：" + mp);
        System.out.print("攻击力：" + attack);
        System.out.println("          防御力：" + defense);
        System.out.print("当前等级：" + Lv);
        System.out.println("          精力值：" + energy);
        System.out.println("请选择修炼方式：1-练剑     2-打野怪     3-跑步");
        Scanner num = new Scanner(System.in);
        while (true) {
            if (energy > 0) {
                String q = num.nextLine();
                if ("1".equals(q)) {
                    hp = hp + 5;
                    attack = attack + 10;
                    energy = energy - 20;
                    System.out.print("生命值：" + hp);
                    System.out.println("         法术值：" + mp);
                    System.out.print("攻击力：" + attack);
                    System.out.println("       防御力：" + defense);
                    System.out.print("当前等级：" + Lv);
                    System.out.println("        精力值：" + energy);
                    System.out.println("请选择修炼方式：1-练剑     2-俯卧撑     3-跑步");
                }
                if ("2".equals(q)) {
                    hp = hp + 5;
                    attack = attack + 2;
                    defense = defense + 3;
                    mp++;
                    energy = energy - 10;
                    System.out.print("生命值：" + hp);
                    System.out.println("         法术值：" + mp);
                    System.out.print("攻击力：" + attack);
                    System.out.println("       防御力：" + defense);
                    System.out.print("当前等级：" + Lv);
                    System.out.println("        精力值：" + energy);
                    System.out.println("请选择修炼方式：1-练剑     2-俯卧撑     3-跑步");
                }
                if ("3".equals(q)) {
                    attack++;
                    hp++;
                    mp++;
                    defense++;
                    energy--;
                    System.out.print("生命值：" + hp);
                    System.out.println("         法术值：" + mp);
                    System.out.print("攻击力：" + attack);
                    System.out.println("       防御力：" + defense);
                    System.out.print("当前等级：" + Lv);
                    System.out.println("        精力值：" + energy);
                    System.out.println("请选择修炼方式：1-练剑     2-俯卧撑     3-跑步");
                }

            } else {
                System.out.println("体力不足...请马上休息！");
                System.out.println("睡觉中...");
                System.out.println("睡了一觉，精神满满");
                energy = 100;
                Lv++;

            }
        }
    }
}