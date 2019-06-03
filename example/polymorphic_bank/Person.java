package bank;

public abstract class Person {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void callNumber();
    //2.去窗口办理
    public abstract void transact();
    //3. 办理完毕 离开
    public abstract void leave();


}
