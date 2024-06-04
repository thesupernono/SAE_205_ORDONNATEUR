package controleur;

import exception.ExceptionImpossible;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import modele.*;
import vue.VBoxTemple;

import java.io.File;
import java.util.HashSet;

/**
 * Class Controleur pour géré les communications entre les vues
 */
public class Controleur implements EventHandler {

    @Override
    public void handle(Event event) {

        // Changement de sénario :
        if (event.getSource() instanceof MenuItem) {
            System.out.println("Fichier reçu");
            File fichierScenario = (File) ((MenuItem) event.getSource()).getUserData();

            // on tente de généré la nouvelle map
            Map nouvelleMap = null;
            try {
                nouvelleMap = new Map(fichierScenario.getName());
            } catch (Exception erreur) {
                try {
                    throw new ExceptionImpossible(1);
                } catch (ExceptionImpossible e) { // Si l'erreur ne marche pas (impossible)
                }
            }
            // Si la map a bien été générée :
            if(nouvelleMap != null) {

                // On set la nouvelle map comme étant la map actuelle
                VBoxTemple.setMap(nouvelleMap);

                // On récupère des temples et des cristaux du nouveau scenario
                HashSet<Temple> temples = LectureScenario.getTemples();
                HashSet<Cristal> cristaux = LectureScenario.getCristaux();

                System.out.println("La map a changé");
            }

        }

        /*
        if (event.getSource() instanceof Menu) {
            File fichierScenario = (File) event.getSource();
            try {
                scenario = new LectureScenario(nomScenario);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        */

        // Si on prend ou pose un cristal
        if (event.getSource() instanceof Button){

            // On récupère le boutton
            Button boutton = (Button) event.getSource();

            // ----------------TRI-----------------
            if(boutton.getUserData() == "Tri basique"){
                Tri tri = new Tri();
                System.out.println("Tri basique");
                tri.TriBasique();
                System.out.println(tri.toString());
            }

            else if (boutton.getUserData() == "Tri heuristique"){
                Tri tri = new Tri();
                System.out.println("Tri heuristique:");
                tri.TriHeuristique();
                System.out.println(tri.toString());
            }
            // Si ce n'est pas possible, la fonction renvoie pour le moment un string

            else if(boutton.getUserData() instanceof String){
                System.out.println("Action impossible ");
                try {
                    throw new ExceptionImpossible(0);
                } catch (ExceptionImpossible erreur) {
                    // TODO : Il faudra l'adapter en graphique
                    System.out.println(erreur.getMessageErreur());
                }
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
