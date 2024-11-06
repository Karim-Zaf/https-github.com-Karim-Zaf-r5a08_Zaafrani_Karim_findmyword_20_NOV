package r5a08.findmyword;

import java.util.ArrayList;

public class Score {

    private final String correct;
    private Letter result = Letter.INCORRECT;

    public Score(String correct) {
        this.correct=correct;
    }

    public Letter letter(int i) {
        return result;
    }

    public boolean isLetterCorrect(int position , String attempt){
        return this.correct.charAt(position)==attempt.charAt(position);
    }
    public void assess(int position, String attempt) {
        if (isLetterCorrect(position,attempt)){
            result = Letter.CORRECT;
        }
    }
}
