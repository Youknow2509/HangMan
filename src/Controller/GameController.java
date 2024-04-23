package Controller;

import Model.Game;
import Model.Validation;
import Unitils.InputException;
import View.View;
import Config.Config;

public class GameController {
    // Var
    private Game game = null;
    private Validation validation = null;
    private boolean loop = true;
    String charInput = "";
    // Constructor
    public GameController(Game game) {
        super();
        this.game = game;
        validation = new Validation(game.getWord());
    }
    // Application
    public void application() {
        while (loop) {
            View.showWord(game.getHidden(), game.getMax_n());
            inputChar();
            if (validation.check(charInput.charAt(0))) {
                changeChar(charInput.charAt(0));
            } else {
                View.thongbaonnhapsai();
                game.setMax_n(game.getMax_n() - 1);
            }
            // Da tim het ki tu
            if (validation.checkWin(game.getHidden())) {
                View.win();
                loop = false;
                View.result(game.getWord());
            }
            // Het luot tim
            if (validation.checkLose(game.getMax_n())) {
                View.lose();
                loop = false;
                View.result(game.getWord());
            }
        }
    }

    // Nhap mot ky tu
    private void inputChar() {
        View.nhap();
        try {
            charInput = Config.getScanner().nextLine();
            if (charInput.length() != 1 ) {
                throw new InputException("Chi duoc nhap 1 ky tu");
            } // TODO thieu check so
        } catch (InputException e) {
            e.printStackTrace();
            inputChar();
        }
    }
    // Thay doi ki tu
    private void changeChar(Character c) {
        for (int i = 0; i < game.getWord().length(); i++) {
            if (game.getWord().charAt(i) == c) {
                game.setHidden(game.getHidden().substring(0, i) + c + game.getHidden().substring(i + 1));
            }
        }
    }
    // Getter and setter

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public String getCharInput() {
        return charInput;
    }

    public void setCharInput(String charInput) {
        this.charInput = charInput;
    }
}