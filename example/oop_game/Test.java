package oop_game;

public class test {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "小明";
        p.money = 1000;

        Game g = new Game();
        g.gameName = "斗罗大陆";
        g.price = 200;

        p.bugGame(g);
    }

}
