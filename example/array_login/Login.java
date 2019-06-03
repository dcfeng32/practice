package array.secret;

import java.util.Scanner;

public class Login {
    //需求：实现用户的登录认证
    public static void main(String[] args) {
        //0.创建对象
        Functions functions = new Functions();
        //2.用户输入自己的账户密码
        Scanner input = new Scanner(System.in);
        //3.提示用户输入自己的账号和密码
        System.out.println("请输入账号：");
        String user = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        //5.调用方法，方法执行判断
        String result = functions.login(user, password);
        System.out.println(result);
    }
}
