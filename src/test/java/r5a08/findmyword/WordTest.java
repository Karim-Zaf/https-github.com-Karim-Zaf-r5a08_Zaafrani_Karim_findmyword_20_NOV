package r5a08.findmyword;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("B");

        // Assert
        assertScoreForLetter(score ,0, Letter.INCORRECT);
    }

    @Test
    public void should_check_one_correct_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("E");

        // Assert
        assertScoreForLetter(score ,0,  Letter.CORRECT);
    }
    @Test
    public void should_check_second_letter_wrong_position(){
        // Arrange
        Word word = new Word("EM");

        // Act
        Score score = word.guess("GE");

        // Assert
        assertScoreForLetter(score ,1,  Letter.PART_CORRECT);
    }
    @Test
    public void should_check_all_score_combinaisons_correct(){
        // Arrange
        Word word = new Word("EMT");

        // Act
        Score score = word.guess("GET");

        // Assert
        assertScoreForLetter(score ,0,  Letter.INCORRECT);
        assertScoreForLetter(score ,1,  Letter.PART_CORRECT);
        assertScoreForLetter(score ,2,  Letter.CORRECT);
    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }
}


