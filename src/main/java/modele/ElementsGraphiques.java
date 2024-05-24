package modele;

import javafx.scene.canvas.GraphicsContext;
import vue.VBoxTemple;

import java.util.HashMap;

public class ElementsGraphiques implements CONSTANTES_MAP {

    private static GraphicsContext graphiqueContext2D = VBoxTemple.getGraphiqueContext2D();

    // Si on dessine un joueur
    public static void dessinerElement(Joueur joueur) {

        graphiqueContext2D.setFill(COULEURS[1]);

        graphiqueContext2D.fillRect(
                joueur.getPosition().getPosX() * CARRE + CARRE / 8,
                joueur.getPosition().getPosY() * CARRE + CARRE / 4,
                LARGEUR_CIBLE, HAUTEUR_CIBLE);

    }

    // Si on dessine un cristal
    public static void dessinerElement(Cristal parCristal) {

    }

    // Si on dessine un temple
    public static void dessinerElement(Temple parTemple) {

    }

    public static void deplacerElement(Position posDepartElement, Joueur joueur) {

        // Le joueur contient déjà sa nouvelle position, donc on met juste à jour le graphique

        // On get les treeMap des cristaux et des temples pour pouvoir les ressiner plus tard si besoin
        HashMap<Position, Cristal> coordonneesCristaux = VBoxTemple.getMap().getCoordonneesCristaux();
        HashMap<Position, Cristal> coordonneesTemples = VBoxTemple.getMap().getCoordonneesCristaux();


        // On redessine le carré pour clear la case
        graphiqueContext2D.strokeRect(posDepartElement.getPosX() * CARRE,
                posDepartElement.getPosY() * CARRE,
                CARRE, CARRE);

        graphiqueContext2D.setFill(COULEUR_GRILLE);
        graphiqueContext2D.fillRect(
                posDepartElement.getPosX() * CARRE + CARRE / 8,
                posDepartElement.getPosY() * CARRE + CARRE / 4,
                LARGEUR_CIBLE, HAUTEUR_CIBLE);

        // On vérifie si il y avait un élément qu'il faut redessiner

        if (coordonneesTemples.containsKey(posDepartElement)) {
            // Il faut redessiner le temple

        }

        if (coordonneesCristaux.containsKey(posDepartElement)) {
            // Il faut redessiner le cristal

        }

        // On place le joueur


        // On dessine le nouveau élément (joueur ou cristal)
    }
    public static void deplacerElement(Position posDepartElement, Cristal cristal) {

        // Le cristal contient déjà sa nouvelle position, donc on met juste à jour le graphique

        // On get les treeMap des cristaux et des temples pour pouvoir les ressiner plus tard si besoin
        HashMap<Position, Cristal> coordonneesCristaux = VBoxTemple.getMap().getCoordonneesCristaux();
        HashMap<Position, Cristal> coordonneesTemples = VBoxTemple.getMap().getCoordonneesCristaux();

    }
