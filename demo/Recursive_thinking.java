package recursion;

public class Demo {
    public void testOne() {
        this.testTwo();
        System.out.println("我是testOne");
    }

    public void testTwo() {
        this.testThree();
        System.out.println("我是testTwo");
    }

    public void testThree() {
        System.out.println("我是testThree");
    }

    public static void main(String[] args) {
        Demo test = new Demo();
        test.testOne();
    }
}

