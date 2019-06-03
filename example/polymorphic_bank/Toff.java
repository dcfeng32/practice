package bank;

public class Toff extends Person{
    public Toff() {
    }
    public Toff(String name) {
       this.name = name;
    }
    public void callNumber() {
        System.out.println("进门专门的业务人员接待");
    }
    //2.去窗口办理
    public void transact() {
        System.out.println("小房间办理业务");
    }
    //3. 办理完毕 离开
    public void leave() {
        System.out.println("送出银行");
    }



}
