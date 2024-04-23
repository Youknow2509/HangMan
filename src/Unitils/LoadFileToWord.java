package Unitils;

import java.io.BufferedReader;
import java.io.FileReader;

public class LoadFileToWord {
    // Var
    private String path = null;
    private BufferedReader bufferedReader = null;
    private FileReader fileReader = null;
    private String [] words = null;
    // Constructor
    public LoadFileToWord(String path) {
        this.path = path;
    }
    // Read file
    public void readFile() {
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                words = line.split(", ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // Trim words
    private void fomatWords() {
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
        }
    }
    // Getter and setter

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}
