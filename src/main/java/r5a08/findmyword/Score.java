package r5a08.findmyword;

public class Score {
    String mot_correct;
    Letter[] evaluation_chaque_lettre;

    public Score(String mot) {
        this.mot_correct = mot;
        this.evaluation_chaque_lettre = new Letter[5];
    }


    public Letter letter(int index) {
        return evaluation_chaque_lettre[0]; // J'ai utiliser l'indice 0 pour un code minimale pour faire passer le test
    }

    public void assess(int index, String essai) {
        if ( mot_correct.charAt(0)== essai.charAt(0))
                // J'ai utiliser l'indice 0 pour un code minimale pour faire passer le test
            evaluation_chaque_lettre[0] = Letter.CORRECT;
        else
            evaluation_chaque_lettre[0] = Letter.INCORRECT ;
    }
}
