package thread;

import java.util.Vector;

public class System12306 {

    //设计一个单例模式,系统唯一一个
    private System12306() {}

    private static System12306 sys = new System12306();

    public static System12306 getInstance() {
        return sys;
    }

    //数组装票（固定长度），集合容量可变（ArrayList  而Vector集合本身就是线程安全  ）
    private Vector<Ticket> tickets = new Vector<>();

    {
        //系统创建后给ticket集合赋值
        for (int i = 10; i < 100; i++) {
            Ticket tickets1 = new Ticket("北京" + i, "深圳" + i, (i % 5 + 5) * 25F);
            tickets.add(tickets1);
        }
    }

    //设计方法。从集合内获取一张票
    public Ticket getTicket() {
        try {
            return tickets.remove(0);
        } catch (Exception e) {
            return null;
        }

    }

}
