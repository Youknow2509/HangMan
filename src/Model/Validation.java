package Model;

public class Validation {
    // Var
    String word;
    int len;
    // Constructor
    public Validation(String word) {
        this.word = word;
        this.len = word.length();
    }
    // Check game
    public boolean checkWin(String hidden) {
       return word.equals(hidden);
    }
    public boolean checkLose(int n) {
        return n <= 0;
    }

    // Check value
    public boolean check(char ch) {
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }
}
