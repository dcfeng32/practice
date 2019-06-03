package thread;

import java.awt.*;

public class Windows extends Thread {
    private String windowName;

    public Windows(String windowName) {
        this.windowName = windowName;
    }

    public void run() {
        this.sellTicket();
    }

    public void sellTicket() {
        while (true) {
            System12306 sys = System12306.getInstance();
            Ticket ticket = sys.getTicket();
            if (ticket == null) {
                System.out.println("对不起，" + windowName + "窗口车票售完");
                break;
            }
            System.out.println("从" + windowName + "售出：" + ticket);
        }
    }


}
