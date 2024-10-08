package r5a08.findmyword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTest {

    @Test
    public void should_check_one_incorrect_letter() {
        // Arrange
        Word word = new Word("E"); // Le mot à déviner fait une lettre

        // Act
        Score sc = word.guess("B"); // tentative du joueur
        Letter actual = sc.letter(0) ;
        Letter expected = Letter.INCORRECT;


        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void should_check_one_correct_letter() {

        // Arrange
        Word word = new Word("E"); // Le mot à déviner fait une lettre

        // Act
        Score sc = word.guess("E"); // tentative du joueur
        Letter actual = sc.letter(0);
        Letter expected = Letter.CORRECT;


        // Assert
        Assertions.assertEquals(expected, actual);
    }
}
