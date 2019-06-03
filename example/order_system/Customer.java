package System;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int pcount;
    private int cId;
    private List<Dish> dishes = new ArrayList();

    public Customer(int pcount, int cId) {
        this.pcount = pcount;
        this.cId = cId;
    }

    public int getPcount() {
        return pcount;
    }

    public void setPcount(int pcount) {
        this.pcount = pcount;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
