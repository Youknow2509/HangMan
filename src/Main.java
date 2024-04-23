import Controller.GameController;
import Model.Game;
import Unitils.FileToListGame;
import Unitils.LoadFileToWord;

import java.util.List;
import java.util.Random;

public class Main {
    // Lay mot tu trong mang
    private static String RandomWord(String [] listWords) {
        Random random = new Random();
        int index = random.nextInt(listWords.length);
        return listWords[index];
    }
    private static Game RandomGame(List<Game> listGame) {
        Random random = new Random();
        int index = random.nextInt(listGame.size());
        return listGame.get(index);
    }
    public static void main(String [] arg) {
        //String path = "/Users/v/code/java/projects/Hanman/src/DataBase/Levels/Level_1.txt";
        String path = "/Users/v/code/java/projects/Hanman/src/DataBase/data.txt";
        FileToListGame fileToListGame = new FileToListGame(path);
        try {
            fileToListGame.readFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        GameController gameController = new GameController(RandomGame(fileToListGame.getListGame()));
        gameController.application();
        return;
    }
}
