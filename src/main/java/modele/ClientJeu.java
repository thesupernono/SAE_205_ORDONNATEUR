package modele;

import javafx.util.Pair;
import javafx.scene.paint.Color;

public class ClientJeu {
    public static void main(String [] args) throws Exception {
        // premier essai d'ajout d'un temple
        Pair<Integer, Integer> positionTemple = new Pair<>(0, 0);
        Color couleurTemple = Color.AQUA;

        Temple premierTemplate = new Temple(positionTemple, couleurTemple);


        LectureScenario lecture = new LectureScenario(1);

    }
}
