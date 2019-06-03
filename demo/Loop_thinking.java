package recursion;

public class Loop {
    public void Floor(int num){
        if(num > 0){
            this.Floor(num - 1);
            System.out.println("盖楼到第"+num+"层了");
        }
    }

    public static void main(String[] args) {
        Loop o = new Loop();
        o.Floor(10);
    }
}
