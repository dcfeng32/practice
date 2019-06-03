import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.sql.Struct;

//java 类的继承
class person{
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void action(){
        System.out.println(this.age+this.name+"在打王者荣耀。");
        System.out.println("---------------------------------");
    }
}

public class Practice {
    public static void main(String[] args) {
        JavaT Q = new JavaT();
        Q.setName("岁的哈哈哈哈");
        Q.setAge(112);
        Q.javaT();
        Q.action();
    }
}

class JavaT extends person{
    public void javaT() {
        System.out.println(this.getAge()+this.getName()+"在玩游戏。");
    }
}

