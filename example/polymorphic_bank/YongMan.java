package bank;

public class YongMan extends Person {
    public YongMan() {
    }
    public YongMan(String name) {
        this.name = name;
    }
    //1.叫一个号码->排队
    public void callNumber() {
        System.out.println("自己在门口按按钮，拿到小票");
    }

    //2.去窗口办理
    public void transact() {
        System.out.println("去窗口，汇款");
    }
    //3. 办理完毕 离开
    public void leave() {
        System.out.println("办理完，离开了银行");
    }

}
