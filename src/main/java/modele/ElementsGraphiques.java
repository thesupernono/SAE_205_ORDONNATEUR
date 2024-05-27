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
                joueur.getPosition().getPosX() * TAILLE_CARRE,
                joueur.getPosition().getPosY() * TAILLE_CARRE,
                LARGEUR_CIBLE, HAUTEUR_CIBLE);

    }

    // Si on dessine un cristal
    public static void dessinerElement(Cristal parCristal) {

        int numCouleur = parCristal.getCouleur();
        graphiqueContext2D.setFill(COULEURS[numCouleur]);

        graphiqueContext2D.fillRect(parCristal.getPosition().getPosX()* TAILLE_CARRE + TAILLE_CARRE / 8,
                                    parCristal.getPosition().getPosY() * TAILLE_CARRE + TAILLE_CARRE / 4,
                                    TAILLE_CARRE,
                                    TAILLE_CARRE);

    }


    // Si on dessine un temple
    public static void dessinerElement(Temple parTemple) {

        int numCouleur = parTemple.getCouleur();

        graphiqueContext2D.setFill(COULEURS[numCouleur]);

        graphiqueContext2D.fillOval(parTemple.getPosition().getPosX() * TAILLE_CARRE,
                                        parTemple.getPosition().getPosY() * TAILLE_CARRE,
                                    TAILLE_CRISTAL, TAILLE_CRISTAL);
    }

    public static void resetGraphique(Position position){
        // Si on redessine une case qui est déjà vide, ça ne sert à rien et ça gènere des cubes
        // Pour rien, donc on vérifie si il y a quelque chose. Si il n'y a rien, on return pour
        // Annuler la méthode
        if( !Map.getCoordonneesTemples().containsKey(position) &&
            !Map.getCoordonneesCristaux().containsKey(position) &&
            Map.getJoueur().getPosition() != position)
            return;

        // On reset la case
        graphiqueContext2D.strokeRect(position.getPosX() * TAILLE_CARRE,
                position.getPosY() * TAILLE_CARRE,
                TAILLE_CARRE, TAILLE_CARRE);

        // On redessine un temple si il y en a

        if(Map.getCoordonneesTemples().containsKey(position)){

            // On récupère le temple et on le dessine
            Temple temple = Map.getCoordonneesTemples().get(position);
            dessinerElement(temple);
        }


        // On redessine un cristal si il y en a
        if(Map.getCoordonneesCristaux().containsKey(position)){

            // On récupère le temple et on le dessine
            Cristal cristal = Map.getCoordonneesCristaux().get(position);
            dessinerElement(cristal);
        }


        // On redessine le joueur si il est là
        if (Map.getJoueur().getPosition() == position) {
            graphiqueContext2D.strokeRect(position.getPosX() * TAILLE_CARRE,
                    position.getPosY() * TAILLE_CARRE,
                    TAILLE_CARRE, TAILLE_CARRE);
        }
    }

    public static void deplacerElement(Position posDepartElement, Joueur joueur) {

        // Le joueur contient déjà sa nouvelle position, donc on met juste à jour le graphique

        // On get les treeMap des cristaux et des temples pour pouvoir les ressiner plus tard si besoin


        // On redessine le carré
        resetGraphique(posDepartElement);


        // On redisssine la case d'arrivée
        resetGraphique(joueur.getPosition());
    }

    public static void poserCristal(Position position) {

        // Le cristal contient déjà sa nouvelle position, donc on met juste à jour le graphique

        // On get les treeMap des cristaux et des temples pour pouvoir les ressiner plus tard si besoin
        HashMap<Position, Cristal> coordonneesCristaux = Map.getCoordonneesCristaux();
        HashMap<Position, Temple> coordonneesTemples = Map.getCoordonneesTemples();
        Joueur joueur = Map.getJoueur();

        // On ajoute à la map et récupère le cristal de la main du joueur
        Cristal cristal = joueur.poserCristal();

        // On modifie la position dans l'objet cristal
        cristal.setPosition(position);

        // On reset le graphique de la position
        resetGraphique(position);

    }

    public static void prendreCristal(Position position){

        HashMap<Position, Cristal> coordonneesCristaux = Map.getCoordonneesCristaux();
        HashMap<Position, Temple> coordonneesTemples = Map.getCoordonneesTemples();
        Joueur joueur = Map.getJoueur();

        // On récupère le cristal et on l'enlève du HashMap
        joueur.prendreCristal(position);
        coordonneesCristaux.remove(position);

        // On remet à jour la case avec le nouveau cristal
        resetGraphique(position);

    }
}
