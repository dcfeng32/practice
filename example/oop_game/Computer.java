package oop_game;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Game> games = new ArrayList<>();
    //电脑安装游戏也就是把游戏放在集合中
    public void install(Game game) {
        if (game != null) {
            games.add(game);
            System.out.println();
        }
    }
    //开始游戏，在集合中寻找名字对应的游戏
    public void startGame(String gameGame) {
        for (int i = 0; i < games.size(); i++) {
            if (gameGame != null && gameGame.equals(games.get(i).gameName)) {
                games.get(i).run();
            }
        }
    }

}