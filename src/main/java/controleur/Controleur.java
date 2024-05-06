package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import modele.Cristal;
import modele.LectureScenario;
import modele.Temple;

import java.io.File;
import java.util.HashSet;

public class Controleur implements EventHandler {
    LectureScenario scenario;

    @Override
    public void handle(Event event) {
        Object userData = ((MenuItem)event.getSource()).getUserData();

        if (userData instanceof File) {
            File fichierScenario = (File) userData;

            System.out.println(fichierScenario.getName());


            // Lecture du fichier
            try {
                scenario = new LectureScenario(fichierScenario.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            // assignation des temples et des cristaux
            HashSet<Temple> temples = scenario.getTemple();
            HashSet <Cristal> cristaux = scenario.getCristal();

        }
    }
}
