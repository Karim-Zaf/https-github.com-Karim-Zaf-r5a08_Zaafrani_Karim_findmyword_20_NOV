package r5a08.findmyword;

public class WordSelection {
    WordRepository repository;
    RandomNumbers random;

    WordSelection (WordRepository repository, RandomNumbers random) {
        this.repository = repository;
        this.random = random;
    }

    String chooseRandomWord() {
        return "";
    }
}
