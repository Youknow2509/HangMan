package Unitils;

import Model.Game;

import java.util.List;
import java.util.Random;

public class RandomGame {
    public static Game random(List<Game> lGame) {
        Random random = new Random();
        int index = random.nextInt(lGame.size());
        return lGame.get(index);
    }
}
