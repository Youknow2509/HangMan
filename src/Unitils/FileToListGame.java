package Unitils;

import Model.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileToListGame {
    // Var
    private List<Game> listGame = null;
    private String path = null;
    // Constructor
    public FileToListGame(String path) {
        this.path = path;
        listGame = new ArrayList<>();
    }
    // Read File
    public void readFile() throws Exception{
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String line = null;
        String [] temp1 = null;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                temp1 = line.split(":");
                String level, word, hidden, max_n;
                level = temp1[0].split("#")[0];
                word = temp1[0].split("#")[1];
                if (temp1.length == 2) {
                    hidden = temp1[1].split("#")[0];
                    max_n = temp1[1].split("#")[1];
                    listGame.add(new Game(Integer.parseInt(level), word, hidden, Integer.parseInt(max_n)));
                } else if (temp1.length == 1) {
                    listGame.add(new Game(Integer.parseInt(level), word));
                } else {
                    try {
                        bufferedReader.close();
                        fileReader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    throw new Exception("Error format file data.txt");
                }
            }
        } finally{
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // getter and setter

    public List<Game> getListGame() {
        return listGame;
    }

    public void setListGame(List<Game> listGame) {
        this.listGame = listGame;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
