package thread;

public class Ticket {
    /*模拟火车站售票的例子
    1.车票 2.系统12306   3.窗口多线程
*/
    //User类、Ticket类  没有任何逻辑，只包含一些基本属性，每一个对象（相当于小容器）
    //一个对象包含很多属性，增强可读性，类名 属性名 属性类型不一致
    //车票的属性
    private String start;
    private String end;
    private Float price;

    public Ticket(String start, String end, Float price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }
    //为了让打印输出变得方便 ，打印一个对象就可以，重写toString方法
    public String toString(){
        StringBuilder builder = new StringBuilder("[");
        builder.append(this.start);
        builder.append("-->");
        builder.append(this.end);
        builder.append(":");
        builder.append("    票价是："+this.price);
        builder.append("]");
        return builder.toString();
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
