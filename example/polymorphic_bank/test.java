package bank;

public class test {
    public static void main(String[] args) {
          Bank bank = new Bank();
//        OldMan om = new OldMan("长者");
//        //银行欢迎长者进来办理业务
//        bank.profession(om);

        Person p = new Toff("tuaho");
        bank.profession(p);


        //按照刚才的设计  可能有问题
        //银行办理业务的方法写了三个
        //解决办法，可以在三个人之上创建一个父类

    }
}
