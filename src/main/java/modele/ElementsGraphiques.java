package modele;

import interfaces.CONSTANTES_MAP;
import javafx.scene.canvas.GraphicsContext;
import vue.VBoxInfos;
import vue.VBoxTemple;

/**
 * Classe indépendante pour gérer les éléments graphique
 */
public class ElementsGraphiques implements CONSTANTES_MAP {

    private static GraphicsContext graphiqueContext2D = VBoxTemple.getGraphiqueContext2D();

    /**
     * méthode static afin de redessiner une case vide
     * @param position : la position du carré que l'on souhaite redessiner
     */
    public static void dessinerVide(Position position){
        graphiqueContext2D.setFill(COULEUR_FOND);

        graphiqueContext2D.fillRect(
                position.getPosX() * TAILLE_CARRE,
                position.getPosY() * TAILLE_CARRE,
                TAILLE_CARRE, TAILLE_CARRE);

        // On reset les bordures de la case
        graphiqueContext2D.setFill(COULEUR_GRILLE);
        graphiqueContext2D.strokeRect(position.getPosX() * TAILLE_CARRE,
                position.getPosY() * TAILLE_CARRE,
                TAILLE_CARRE, TAILLE_CARRE);
    }

    /**
     * Méthode static pour dessiner graphiquement un joueur
     * @param joueur : joueur à dessiner
     */
    public static void dessinerElement(Joueur joueur) {

        graphiqueContext2D.setFill(COULEURS[0]);

        graphiqueContext2D.fillRect(
                joueur.getPosition().getPosX() * TAILLE_CARRE,
                joueur.getPosition().getPosY() * TAILLE_CARRE,
                TAILLE_CARRE, TAILLE_CARRE);

    }

    /**
     * Méthode static pour dessiner graphiquement un temple
     * @param parTemple : le temple à dessiner
     */
    public static void dessinerElement(Temple parTemple) {

        int numCouleur = parTemple.getCouleur();
        graphiqueContext2D.setFill(COULEURS[numCouleur]);

        graphiqueContext2D.fillRect(parTemple.getPosition().getPosX()* TAILLE_CARRE,
                                    parTemple.getPosition().getPosY() * TAILLE_CARRE,
                                    TAILLE_CARRE,
                                    TAILLE_CARRE);

    }


    /**
     * Méthode static pour dessiner graphiquement un cristal
     * @param parCristal : cristal à dessiner
     */
    public static void dessinerElement(Cristal parCristal) {

        int numCouleur = parCristal.getCouleur();

        graphiqueContext2D.setFill(COULEURS[numCouleur]);

        // Entre le cristal et le quadrillage, il faut un écart pour pouvoir le centrer
        // On va donc calculer cet écart :
        int ecart = (TAILLE_CARRE - TAILLE_CRISTAL) / 2;

        // On déssine le cristal
        graphiqueContext2D.fillOval(parCristal.getPosition().getPosX() * TAILLE_CARRE + ecart,
                                    parCristal.getPosition().getPosY() * TAILLE_CARRE + ecart,
                                    TAILLE_CRISTAL, TAILLE_CRISTAL);
    }

    /**
     * Méthode static pour reset une case en fonction de sa position
     * @param positionReset : position de la case à reset
     */
    public static void resetGraphique(Position positionReset){

        // On reset le carré
        ElementsGraphiques.dessinerVide(positionReset);

        // On récupère le temple si il y en a un et on le dessine
        for(Position posTemple : Map.getCoordonneesTemples().keySet()){

            if(posTemple.equals(positionReset)){

                Temple temple = Map.getCoordonneesTemples().get(posTemple);
                dessinerElement(temple);
            }
        }

        // On redessine un cristal si il y en a un et on le dessine
        for (Position posCistal : Map.getCoordonneesCristaux().keySet())
            if(posCistal.equals(positionReset)){

                // On récupère le temple et on le dessine
                Cristal cristal = Map.getCoordonneesCristaux().get(posCistal);
                dessinerElement(cristal);
            }



        // On redessine le joueur si il est là
        if (Map.getJoueur().getPosition().equals(positionReset)) {
            dessinerElement(Map.getJoueur());
        }

        // On met aussi à jour l'affichage
        VBoxInfos.verifPossession(positionReset);
    }

    /**
     * Méthode static pour reset toutes les cases du graphique
     */
    public static void resetAll(){
        // On fait débuter numLigne et numColonne à 1 car on veut garder les numéros de ligne / colonne
        for(int numLigne = 1; numLigne < NOMBRE_CARRE; numLigne += 1){
            for(int numColonne = 1; numColonne < NOMBRE_CARRE; numColonne += 1){
                Position posAReset = new Position(numColonne, numLigne);
                dessinerVide(posAReset);
            }
        }
    }
}
