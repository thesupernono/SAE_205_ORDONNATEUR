package modele;

import javafx.scene.canvas.GraphicsContext;
import vue.VBoxTemple;

import java.util.HashMap;

public class ElementsGraphiques implements CONSTANTES_MAP {

    private static GraphicsContext graphiqueContext2D = VBoxTemple.getGraphiqueContext2D();


    // Si on dessine un joueur
    public static void dessinerElement(Joueur joueur) {

        graphiqueContext2D.setFill(COULEURS[0]);

        graphiqueContext2D.fillRect(
                joueur.getPosition().getPosX() * TAILLE_CARRE + TAILLE_CARRE / 8,
                joueur.getPosition().getPosY() * TAILLE_CARRE + TAILLE_CARRE / 4,
                LARGEUR_CIBLE, HAUTEUR_CIBLE);

    }

    // Si on dessine un cristal
    public static void dessinerElement(Cristal parCristal) {

        int numCouleur = parCristal.getCouleur();
        graphiqueContext2D.setFill(COULEURS[numCouleur]);

        graphiqueContext2D.fillRect(parCristal.getPosition().getPosX(), parCristal.getPosition().getPosY(),
                                parCristal.getPosition().getPosX() + TAILLE_CARRE, parCristal.getPosition().getPosY() + TAILLE_CARRE);

    }


    // Si on dessine un temple
    public static void dessinerElement(Temple parTemple) {

        int numCouleur = parTemple.getCouleur();

        graphiqueContext2D.setFill(COULEURS[numCouleur]);

        graphiqueContext2D.fillOval(parTemple.getPosition().getPosX(), parTemple.getPosition().getPosY(),
                                    parTemple.getPosition().getPosX() + TAILLE_CRISTAL, parTemple.getPosition().getPosY() + TAILLE_CRISTAL);
    }

    public static void deplacerElement(Position posDepartElement, Joueur joueur) {

        // Le joueur contient déjà sa nouvelle position, donc on met juste à jour le graphique

        // On get les treeMap des cristaux et des temples pour pouvoir les ressiner plus tard si besoin
        HashMap<Position, Cristal> coordonneesCristaux = Map.getCoordonneesCristaux();
        HashMap<Position, Temple> coordonneesTemples = Map.getCoordonneesTemples();


        // On redessine le carré pour clear la case
        graphiqueContext2D.strokeRect(posDepartElement.getPosX() * TAILLE_CARRE,
                posDepartElement.getPosY() * TAILLE_CARRE,
                TAILLE_CARRE, TAILLE_CARRE);

        graphiqueContext2D.setFill(COULEUR_GRILLE);
        graphiqueContext2D.fillRect(
                posDepartElement.getPosX() * TAILLE_CARRE + TAILLE_CARRE / 8,
                posDepartElement.getPosY() * TAILLE_CARRE + TAILLE_CARRE / 4,
                LARGEUR_CIBLE, HAUTEUR_CIBLE);


        // On vérifie si il y avait un élément qu'il faut redessiner

        if (coordonneesTemples.containsKey(posDepartElement)) {
            // Il faut redessiner le temple
            dessinerElement(coordonneesTemples.get(posDepartElement));
        }

        if (coordonneesCristaux.containsKey(posDepartElement)) {
            // Il faut redessiner le cristal
            dessinerElement(coordonneesCristaux.get(posDepartElement));

        }


        // On redisssine la case d'arrivée
        // On redessine le carré pour clear la case
        graphiqueContext2D.strokeRect(joueur.getPosition().getPosX() * TAILLE_CARRE,
                joueur.getPosition().getPosY() * TAILLE_CARRE,
                TAILLE_CARRE, TAILLE_CARRE);


        // On vérifie si il y avait un élément qu'il faut redessiner

        if (coordonneesTemples.containsKey(posDepartElement)) {
            // Il faut redessiner le temple
            dessinerElement(coordonneesTemples.get(posDepartElement));
        }

        if (coordonneesCristaux.containsKey(posDepartElement)) {
            // Il faut redessiner le cristal
            dessinerElement(coordonneesCristaux.get(posDepartElement));

        }

        // On place le joueur
        dessinerElement(joueur);
    }

    public static void poserCristal(Position position) {

        // Le cristal contient déjà sa nouvelle position, donc on met juste à jour le graphique

        // On get les treeMap des cristaux et des temples pour pouvoir les ressiner plus tard si besoin
        HashMap<Position, Cristal> coordonneesCristaux = Map.getCoordonneesCristaux();
        HashMap<Position, Cristal> coordonneesTemples = Map.getCoordonneesCristaux();
        Joueur joueur = VBoxTemple.getJoueur();

        // On enlève et récupère le cristal de la main du joueur
        Cristal cristal = joueur.poserCristal();

        // On modifie la position dans l'objet cristal
        cristal.setPosition(position);

        // Il y a forcément un temple en dessous, donc on le redessine et on dessine le cristal
        dessinerElement(coordonneesTemples.get(position));
        dessinerElement(coordonneesCristaux.get(position));

    }

    public static void prendreCristal(Cristal cristal){

        HashMap<Position, Cristal> coordonneesCristaux = Map.getCoordonneesCristaux();
        HashMap<Position, Cristal> coordonneesTemples = Map.getCoordonneesCristaux();

        // On
    }
}
