package modele;

import javafx.util.Pair;

import java.util.HashSet;

public class Map {

    public Map(int numeroScenario) throws Exception {

        // On lit la map
        LectureScenario scenario = new LectureScenario(numeroScenario);
        HashSet<Temple> listeTemple = scenario.listeTemple();
        HashSet<Cristal> listeCristal = scenario.listeCristal();
    }
}
