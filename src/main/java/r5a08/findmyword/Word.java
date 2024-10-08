package r5a08.findmyword;

public class Word {
    String mot_a_deviner ;

    public Word (String mot){
        this.mot_a_deviner = mot ;
    }

    // la méthode guess nous renvoie le score de notre essai
    // grâce à la méthode assess de la Classe Score
    public Score guess(String essai) {
        Score score = new Score(mot_a_deviner);

        score.assess(0, essai);

        return score;
    }
}
