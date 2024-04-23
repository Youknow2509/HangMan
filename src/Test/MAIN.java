package Test;

import Controller.GameController;
import Unitils.FileToListGame;
import Unitils.RandomGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.Game;

public class MAIN extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Game.fxml"));
        Parent root = loader.load();

        FileToListGame fileToListGame = new FileToListGame("/Users/v/code/java/projects/Hanman/src/DataBase/data.txt");
        fileToListGame.readFile();
        Game game =  RandomGame.random(fileToListGame.getListGame());

        GameController gameController = loader.getController();
        gameController.init(game);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
