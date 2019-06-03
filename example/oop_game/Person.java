package oop_game;

public class Person {
    String name;
    double money;
    Computer computer = new Computer();

    public void bugGame(Game game) {
            if (money >= game.price) {
                money = money - game.price;
                //安装游戏
                computer.install(game);
                System.out.println("小明花费了" + game.price +"元，购买了" + game.gameName);
            }
    }

    public void playGame(String gameName){
        computer.startGame(gameName);
    }

}
