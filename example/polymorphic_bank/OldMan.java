package bank;
/*
设计一个方法 等待用户来办理业务
Profession 1.叫一个号码->排队
           2.去窗口办理
           3. 办理完毕 离开
 */
public class OldMan extends Person{

    //私有属性，构造方法复制或set方法
// 第yi种
    public OldMan() { }
    public OldMan(String name) {
        this.name = name;
    }
    //1.叫一个号码->排队
    public void callNumber() {
        System.out.println("年事已高，不知道叫号，请求帮忙");
    }

    // 2.去窗口办理
    public void transact() {
        System.out.println("到窗口，取钱");
    }
    // 3. 办理完毕 离开
    public void leave() {
        System.out.println("办理完毕，离开");
    }

}
