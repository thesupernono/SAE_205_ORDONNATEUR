package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import modele.*;
import javafx.scene.canvas.GraphicsContext;
import java.io.File;
import java.util.HashSet;

public class Controleur implements EventHandler {
    LectureScenario scenario;
    GraphicsContext graphiqueContext2D;

    @Override
    public void handle(Event event) {
        // System.out.println(event.getSource());

        // Changement de sénario :
        if (event.getSource() instanceof File) {
            File fichierScenario = (File) event.getSource();
            try {
                scenario = new LectureScenario(fichierScenario.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // assignation des temples et des cristaux
            HashSet<Temple> temples = scenario.getTemple();
            HashSet <Cristal> cristaux = scenario.getCristal();

        }

        // Si on prend ou pose un cristal
        if (event.getSource() instanceof Button){

            // On récupère le boutton
            Button boutton = (Button) event.getSource();

            // Si ce n'est pas possible, la fonction renvoie pour le moment un string

            if(boutton.getUserData() instanceof String){
                System.out.println("Action impossible ");
                //TODO : faire un raise exception
            }

            // Si on pose le cristal sur un temple, et que c'est possible
            if (boutton.getUserData() instanceof Temple){
                System.out.println("Temple récupérée ");


                // On récupère le temple sur lequel on est
                Temple temple = (Temple)boutton.getUserData();

                Map.getJoueur().poserCristal(temple);

            }

            // Si on prend le cristal et que c'est possible
            if (boutton.getUserData() instanceof Cristal){
                // On défini le cristal
                Cristal cristal = (Cristal)boutton.getUserData();


                // On essaye de le met dans la main
                Map.getJoueur().prendreCristal(cristal.getPosition());
            }
        }
    }


}
