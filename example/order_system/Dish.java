package System;

import com.sun.jmx.snmp.SnmpString;

public class Dish implements Cloneable{
    private String dishId;
    private String name;
    private double price;

    public Dish(String dishId, String name, double price) {
        this.dishId = dishId;
        this.name = name;
        this.price = price;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
