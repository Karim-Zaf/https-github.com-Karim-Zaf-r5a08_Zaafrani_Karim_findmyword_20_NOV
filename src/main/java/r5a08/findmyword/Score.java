package r5a08.findmyword;

public class Score {
    String mot_correct;
    Letter result;

    public Score(String mot) {
        this.mot_correct = mot;
        this.result = Letter.INCORRECT; // initaliser la variable result à Incorrect
    }

    // Retourne le résultat de l'essai
    public Letter letter(int index) {
        return this.result; // J'ai utiliser l'indice 0 pour un code minimale pour faire passer le test
    }

    // la fonction assess nous indique le résultat de notre essai pour un indice donné
    public void assess(int index, String essai) {
        if ( compare (mot_correct,essai,0))
                // J'ai utiliser l'indice 0 pour un code minimale pour faire passer le test
            result = Letter.CORRECT;
    }

    // la méthode "compare" 2 chaines de caractères à un indice donée
    public boolean compare (String correct , String essai , int index ){
        return  correct.charAt(0)== essai.charAt(0);
    }

}
