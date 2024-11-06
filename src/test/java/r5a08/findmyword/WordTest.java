package r5a08.findmyword;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("B");

        // Assert
        assertScoreForGuess(score, Letter.INCORRECT);
    }

    @Test
    public void should_check_one_correct_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("E");

        // Assert
        assertScoreForGuess(score, Letter.CORRECT);
    }
    @Test
    public void should_check_second_letter_wrong_position(){
        // Arrange
        Word word = new Word("EM");

        // Act
        Score score = word.guess("GE");

        // Assert
        assertScoreForGuess(score ,
                Letter.INCORRECT,
                Letter.PART_CORRECT
        );
    }
    @Test
    public void should_check_all_score_combinaisons_correct(){
        // Arrange
        Word word = new Word("EMT");

        // Act
        Score score = word.guess("GET");

        // Assert
        assertScoreForGuess(score ,
                Letter.INCORRECT,
                Letter.PART_CORRECT,
                Letter.CORRECT
        );
    }
    private void assertScoreForGuess(Score score, Letter... expectedScores) {
        for (int position = 0 ; position < expectedScores.length; position++){
            Letter expected = expectedScores [position];
            assertThat(score.letter(position))
                    .isEqualTo(expected) ;
        }
    }
}