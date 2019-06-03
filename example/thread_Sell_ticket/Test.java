package thread;

public class test {
    public static void main(String[] args) {
        Windows windows1 = new Windows("北京北站");
        Windows windows2 = new Windows("北京西站");
        Windows windows3 = new Windows("北京南站");
        windows1.start();
        windows2.start();
        windows3.start();
    }

}

