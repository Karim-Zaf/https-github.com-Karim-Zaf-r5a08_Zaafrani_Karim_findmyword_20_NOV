package r5a08.findmyword;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private final String correct;
    private List<Letter> results = new ArrayList<>() ;
    private int position = 0;
    public Score(String correct) {
        this.correct=correct;
    }

    public Letter letter(int i) {
        return results.get(i);
    }


    public void assess( String attempt) {

        for (char currentLetter: attempt.toCharArray()){
            results.add ( scoreForLetter(currentLetter));
            this.position ++ ;
        }
    }

    public Letter scoreForLetter( char current){

        if ( isCorrectLetter( current)){
            return Letter.CORRECT;
        }
        if (isLetterOccursInWord(current)){
            return Letter.PART_CORRECT;
        }
        return Letter.INCORRECT;
    }


    private  boolean isLetterOccursInWord(char currentLetter){
        return correct.contains (String.valueOf((currentLetter)));
    }

    private boolean isCorrectLetter(char currentLetter){
        return correct.charAt(position) == currentLetter;
    }

}
