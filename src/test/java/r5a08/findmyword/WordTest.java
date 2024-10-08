package r5a08.findmyword;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WordTest {

    private void assertAllCombinaisons(Score score, Letter... expecteds) {
        int i=0;
        for (Letter letter : expecteds){
            assertThat(score.letter(i)).isEqualTo(letter);
            i++;
        }

    }

    @Test
    public void should_check_one_incorrect_letter() {
        // Arrange
        Word word = new Word("E"); // Le mot à déviner fait une lettre

        // Act
        Score score = word.guess("B"); // tentative du joueur à une seule lettre
        Letter actual = score.letter(0) ;
        Letter expected = Letter.INCORRECT;

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void should_check_one_correct_letter() {

        // Arrange
        Word word = new Word("E"); // Le mot à déviner fait une lettre

        // Act
        Score score = word.guess("E"); // tentative du joueur à une seule lettre


        // ASSERT
        assertAllCombinaisons(score,
                Letter.CORRECT);
    }

    @Test
    void should_check_two_incorrect_characters() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("CD");

        // ASSERT
        assertAllCombinaisons(score,
                Letter.INCORRECT,
                Letter.INCORRECT);
    }

    @Test
    void should_check_two_correct_characters() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("AB");

        // assert
        assertAllCombinaisons(score,
                Letter.CORRECT,
                Letter.CORRECT);
    }

    @Test
    void should_check_two_part_correct_characters() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("BA");

        // Assert

        assertAllCombinaisons(score,
                Letter.PART_CORRECT,
                Letter.PART_CORRECT);


        /**
         * Ancienne méthode
         * Letter actualFirst = score.letter(0);
        Letter actualSecond = score.letter(1);

        Letter expectedFirst = Letter.PART_CORRECT;
        Letter expectedSecond = Letter.PART_CORRECT;

        // Assert
        Assertions.assertEquals(expectedFirst, actualFirst);
        Assertions.assertEquals(expectedSecond, actualSecond);*/
        
    }


    @Test
    void should_check_one_part_correct_one_incorrect() {
        // Arrange
        Word word = new Word("AB");

        // Act
        Score score = word.guess("DA");

        assertAllCombinaisons(score,
                Letter.INCORRECT,
                Letter.PART_CORRECT);
    }


    @Test
    void should_check_all_letters_part_correct() {
        // J'ai tenté une autre méthode pour ce test


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
    

    @Test
    void should_check_all_5_letters_incorect() {
        // J'ai tenté une autre méthode pour ce test


        // Arrange
        Word word = new Word("KARIM");

        // Act
        Score score = word.guess("EZWXY"); // J'ai choisis le REVERSE de la chaine word

        assertAllCombinaisons(score,
                Letter.INCORRECT,
                Letter.INCORRECT,
                Letter.INCORRECT,
                Letter.INCORRECT,
                Letter.INCORRECT
        );

    }

    @Test
    void should_check_4_letters_part_correct_one_correct_letter() {
        // J'ai tenté une autre méthode pour ce test


        // Arrange
        Word word = new Word("KARIM");

        // Act
        Score score = word.guess("MIRAK"); // J'ai choisis le REVERSE de la chaine word

        assertAllCombinaisons(score,
                Letter.PART_CORRECT,
                Letter.PART_CORRECT,
                Letter.CORRECT,
                Letter.PART_CORRECT,
                Letter.PART_CORRECT
        );

    }
}


