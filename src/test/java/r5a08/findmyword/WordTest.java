package r5a08.findmyword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WordTest {

    @Test
    public void should_check_one_incorrect_letter() {
        // Arrange
        Word word = new Word("E"); // Le mot à déviner fait une lettre

        // Act
        Score sc = word.guess("B"); // tentative du joueur à une seule lettre
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
        Score sc = word.guess("E"); // tentative du joueur à une seule lettre
        Letter actual = sc.letter(0);
        Letter expected = Letter.CORRECT;

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void should_check_two_incorrect_characters() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("CD");
        Letter actualFirst = score.letter(0);
        Letter actualSecond = score.letter(1);

        Letter expectedFirst = Letter.INCORRECT;
        Letter expectedSecond = Letter.INCORRECT;

        // Assert
        Assertions.assertEquals(expectedFirst, actualFirst);
        Assertions.assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void should_check_two_correct_characters() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("AB");
        Letter actualFirst = score.letter(0);
       // Letter actualSecond = score.letter(1);

        Letter expectedFirst = Letter.CORRECT;
       // Letter expectedSecond = Letter.CORRECT;

        // Assert
        Assertions.assertEquals(expectedFirst, actualFirst);
       // Assertions.assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void should_check_two_part_correct_characters() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("BA");

        Letter actualFirst = score.letter(0);
        Letter actualSecond = score.letter(1);

        Letter expectedFirst = Letter.PART_CORRECT;
        Letter expectedSecond = Letter.PART_CORRECT;

        // Assert
        Assertions.assertEquals(expectedFirst, actualFirst);
        Assertions.assertEquals(expectedSecond, actualSecond);
    }

    @Test
    void should_check_one_part_correct_one_incorrect() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("DA");

        Letter actualFirst = score.letter(0);
        Letter actualSecond = score.letter(1);

        Letter expectedFirst = Letter.INCORRECT;
        Letter expectedSecond = Letter.PART_CORRECT;

        // Assert
        Assertions.assertEquals(expectedFirst, actualFirst);
        Assertions.assertEquals(expectedSecond, actualSecond);
    }


    @Test
    void should_check_all_letters_part_correct() {
        // Arrange
        Word word = new Word("KARIM");

        // Act
        Score score = word.guess("MIARK"); // J'ai choisis le REVERSE de la chaine word

        ArrayList<Letter> actual= score.letters();


        ArrayList<Letter> expected = new ArrayList<>(Arrays.asList(
                Letter.PART_CORRECT,
                Letter.PART_CORRECT,
                Letter.PART_CORRECT,
                Letter.PART_CORRECT,
                Letter.PART_CORRECT
        ));


        // Assert
        Assertions.assertEquals(actual , expected);
    }
}


