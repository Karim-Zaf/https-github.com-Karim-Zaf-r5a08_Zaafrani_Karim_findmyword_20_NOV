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
        assertThat(score.letter(0)).isEqualTo(Letter.INCORRECT);
    }

    @Test
    public void should_check_one_correct_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("E");

        // Assert
        assertThat(score.letter(0)).isEqualTo(Letter.CORRECT);
    }
}


