package r5a08.findmyword;

public class Word {
    String mot_a_deviner ;

    public Word (String mot){
        this.mot_a_deviner = mot ;
    }

    public Score guess(String essai) {
        Score score = new Score(mot_a_deviner);

        score.assess(0, essai);

        return score;
    }
}
