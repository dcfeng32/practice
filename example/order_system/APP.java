package System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APP {
    static List<Dish> dishes = new ArrayList<>();

    public static void main(String[] args) {
        //客人进来了
        System.out.println("欢迎光临");
        Customer customer = new Customer(3,9);
        //初始化系统
        initDish();
        //展示主菜单
        showMainMenu();
        Scanner s = new Scanner(System.in);

        while(true){
            //创建内存的扫描器
            Scanner scanner = new Scanner(System.in);
            String s1= s.nextLine();
            if("#".equals(s1)){
                showMainMenu();
            }

            if("1".equals(s1)){
                //展示菜单
                showMenu();
                while(true) {
                    //获得输入
                    String dishId = scanner.nextLine();
                    if("*".equals(dishId)){
                        break;
                    }
                    //获得菜单中的一个菜的对象
                    Dish dish = getDish(dishId);
                    //把这个菜加到客人的集合中
                    customer.getDishes().add(dish);

                    System.out.println("已点" + dish.getName());

                }
                System.out.println("点菜完成，输入#返回主菜单");
            }

            if("2".equals(s1)){
                //展示客人已点的菜单
                showCustomerMenu(customer);
                //删除已点菜单
                while (true){
                    String sign = scanner.nextLine();

                    if("*".equals(sign)){
                        break;
                    }
                    String dishId = sign.substring(1);
                    delDish(dishId,customer);
                    System.out.println("已删除");

                }
                System.out.println("删除成功，输入#返回主菜单！");
            }

            if("3".equals(s1)){
                System.out.println("结账");
            }

        }

    }


//    public static double priceTotal(Customer customer){
//    }


    public static void initDish(){
        Dish d1 = new Dish("1","合计",25.0);
        Dish d2 = new Dish("2","土豆丝",25.0);
        Dish d3 = new Dish("3","大白菜",25.0);
        Dish d4 = new Dish("4","冬瓜",25.0);
        Dish d5 = new Dish("5","青菜",25.0);
        dishes.add(d1);
        dishes.add(d2);
        dishes.add(d3);
        dishes.add(d4);
        dishes.add(d5);
    }

    public static void showMainMenu(){
        System.out.println("+-----------主菜单----------+");
        System.out.println("|   点菜                 1  |");
        System.out.println("|   查看已点              2  |");
        System.out.println("|   结账                 3  |");
        System.out.println("|   退出                 4  |");
        System.out.println("|   帮助                 5  |");
        System.out.println("+--------------------------+");

    }

    public static void showMenu(){
        System.out.println("+-----------主菜单----------+");
        for(Dish d :dishes){
            System.out.println("|    "+d.getDishId()+"    " +d.getName()
                    +"      "+d.getPrice()+ "|");
        }
        System.out.println("+-----------主菜单----------+");

    }

    public static Dish getDish(String dishId){
        Dish dish = null;
        for(Dish d : dishes){
            if(d.getDishId().equals(dishId)){
                dish = d;
            }
        }

        try {
            //复制了一个菜单中的对象
            dish = (Dish)dish.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return dish;
    }

    public static void showCustomerMenu(Customer customer){
        System.out.println("*---------已点菜单-----------*");
        for(Dish d : customer.getDishes()){
            System.out.println(d.getDishId()+d.getName()+d.getPrice());
        }
        System.out.println("*---------------------------*");
    }

    public static void delDish(String dishId,Customer customer){
        List<Dish> ds = customer.getDishes();
        for(int i = 0;i<ds.size();i++){
            Dish d = ds.get(i);
            if(d.getDishId().equals(dishId)){
                ds.remove(i);
                break;
            }
        }
    }


}
