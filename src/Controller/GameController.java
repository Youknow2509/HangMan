package Controller;

import Model.Game;
import Unitils.FileToListGame;
import Unitils.RandomGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameController {
    // Var fxml
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MenuItem loadGame;
    @FXML
    private MenuItem exitGame;
    @FXML
    private HBox containerNumber;
    @FXML
    private Text numberHealth;
    @FXML
    private TextField textInput;
    @FXML
    private Text stageGame;
    // Var
    private Game game;
    private Button buttonClicked;
    // Init
    public void init(Game game) {
        this.game = game;
        createButton();

        numberHealth.setText(String.valueOf(game.getMax_n()));
        stageGame.setText("");
    }

    // Creat button with game
    private void createButton() {
        String css = "-fx-font-size: 20px; " +
                "-fx-font-weight: bold; " +
                "-fx-pref-width: 75px; " +
                "-fx-pref-height: 75px; " +
                "-fx-text-alignment: center;" +
                "-fx-fill: #000000;" +
                "-fx-background-color: #ffffff;";
        String hover = css + "-fx-opacity: 0.5;";
        String donthover = css + "-fx-opacity: 1;";
        for (int i = 0; i < game.getLenWord(); i++) {
            Button bt;
            if (game.getHidden().charAt(i) == ' '){
                bt = new Button(String.valueOf("_"));
            } else {
                bt = new Button(String.valueOf(game.getHidden().charAt(i)));
            }

            bt.setStyle(
                    css
            );
            bt.addEventHandler(MouseEvent.MOUSE_CLICKED,
                    event -> {
                        Button button = (Button) event.getSource();
                        buttonClicked = button;
                    }
            );
            bt.setOnMouseEntered(e -> bt.setStyle(hover));
            bt.setOnMouseExited(e -> bt.setStyle(donthover));
            bt.setId(String.valueOf(i));
            containerNumber.getChildren().add(bt);
        }
    }

    // Input text
    public void inputText(ActionEvent event) {
        String str = textInput.getText();
        if (str != null && !str.equals("") && str.length() == 1
            && buttonClicked != null && buttonClicked.getText().equals("*")) {

            int indexChar = buttonClicked.getId().charAt(0) - '0';
            if (game.getWord().charAt(indexChar) == str.charAt(0)) {
                String hidden = game.getHidden();
                buttonClicked.setText(str);
                hidden = hidden.substring(0, indexChar) + str + hidden.substring(indexChar + 1);
                game.setHidden(hidden);
            } else {
                game.setMax_n(game.getMax_n() - 1);
                numberHealth.setText(String.valueOf(game.getMax_n()));
            }
        }
        gameCheck();
        textInput.setText("");
    }

    // Game check
    private void gameCheck() {
        if (game.getWord().equals(game.getHidden())) {
            stageGame.setText("Win");
        }
        if (game.getMax_n() <= 0) {
            stageGame.setText("Lose");
        }
    }

    // help load game
    private void helpLoadGame() {
        try {
            FileToListGame fileToListGame = new FileToListGame("/Users/v/code/java/projects/Hanman/src/DataBase/data.txt");
            fileToListGame.readFile();
            game =  RandomGame.random(fileToListGame.getListGame());
        } catch (Exception e) {
            e.printStackTrace();
        }
        containerNumber.getChildren().clear();
        init(game);
    }

    // Menubar load - Load new game
    public void loadGame(ActionEvent event) {
        helpLoadGame();
    }

    // Exit
    public void exitGame(ActionEvent event) {
        System.exit(0);
    }

    // SetTimeOutInit
    private void setTimeOutInit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
