package r5a08.findmyword;

import java.util.ArrayList;

public class Score {
    String correct;
    ArrayList<Letter> results;

    public Score(String mot) {
        this.correct = mot;
        this.results = new ArrayList<>(); // initaliser la variable result à Incorrect

        // Remplir `results` avec des lettres incorrectes par défaut
        for (int i = 0; i < mot.length() ; i++)
            results.add(Letter.INCORRECT);
    }

    // Retourne le résultat de l'essai
    public Letter letter(int index) {
        return results.get(index); // J'ai utiliser l'indice 0 pour un code minimale pour faire passer le test
    }

    // la fonction assess nous indique le résultat de notre essai pour un indice donné
    public void assess(String attempt, int index) {
        // J'ai utiliser l'indice 0 pour un code minimale pour faire passer le test
        results.set(index, scoreFor (attempt.charAt(index) , index));
    }

    // la méthode "compare" 2 chaines de caractères pour un caractère donné
    public Letter scoreFor ( char current , int index ){
        if (   correct.charAt(index) ==  current) return Letter.CORRECT;
        else if (correct.contains(String.valueOf(current))) return Letter.PART_CORRECT;
        return Letter.INCORRECT;
    }

    public ArrayList<Letter> letters() {
        return results ;
    }
}
