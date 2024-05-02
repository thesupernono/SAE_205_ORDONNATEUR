package modele;

import javafx.util.Pair;

import java.util.HashSet;

public class Map {
    Pair<Pair<Integer, Integer>, Object> posObjet;

    public Map(int numeroScenario) throws Exception {
        // On place le j
        LectureScenario scenario = new LectureScenario(numeroScenario);
        HashSet<Temple> listeTemple = scenario.listeTemple();
        // posObjet = new Pair<>();
    }
}
