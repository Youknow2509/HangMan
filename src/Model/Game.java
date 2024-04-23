package Model;

public class Game {
    // Var
    private String word;
    private int level;
    private int max_n = 5;
    private String hidden;
    private int lenWord = 0;

    // Constructor
    public Game(int level, String word) {
        this.word = word;
        this.level = level;
        this.hidden = "";
        this.lenWord = word.length();
        createHidden();
    }
    public Game(int level, String word, String hidden, int max_n) {
        this.word = word;
        this.level = level;
        this.hidden = hidden;
        this.lenWord = word.length();
        this.max_n = max_n;
    }
    // Tao hidden
    private void createHidden() {
        for (int i = 0; i < lenWord; i++) {
            if (word.charAt(i) == ' ') {
                hidden += word.charAt(i);
            } else
                hidden += "*";
        }
    }


    // To string

    @Override
    public String toString() {
        return "Game{" +
                "word='" + word + '\'' +
                ", level=" + level +
                ", max_n=" + max_n +
                ", hidden='" + hidden + '\'' +
                ", lenWord=" + lenWord +
                '}';
    }

    // Getter and setter
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMax_n() {
        return max_n;
    }

    public void setMax_n(int max_n) {
        this.max_n = max_n;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public int getLenWord() {
        return lenWord;
    }

    public void setLenWord(int lenWord) {
        this.lenWord = lenWord;
    }
}
