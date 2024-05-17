package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import modele.*;
import java.util.HashSet;

public class VBoxTemple extends VBox implements CONSTANTES_MAP {

    private static Joueur joueur;
    private HashSet <Temple> temples;
    private HashSet <Cristal> cristaux;
    private Label labelNombreDePas;
    private Canvas canvasCarte;
    private GraphicsContext graphiqueContext2D;
    public static MenuBar menuBar;

    // private Controller controleur;

    public VBoxTemple() {
        joueur = new Joueur(CENTRE_X, CENTRE_Y);
        // controleur = new Controleur();

        // Barre de menu
        menuBar = new MenuJeu();
        this.getChildren().add(menuBar);


        //Informations sur le joueur

            labelNombreDePas = new Label("Nombre de pas : 0");


            //-------------------------Map-------------------------
            canvasCarte = new Canvas();
            canvasCarte.setWidth(TAILLE_MAP[0]);
            canvasCarte.setHeight(TAILLE_MAP[1]);
            graphiqueContext2D = canvasCarte.getGraphicsContext2D();


            //-----------------Initiation de carrés-----------------
            graphiqueContext2D.setStroke(COULEUR_GRILLE);
            for (int i = 0; i < TAILLE_MAP[0]; i += CARRE){
                for (int j = 0; j < TAILLE_MAP[1]; j += CARRE){
                    graphiqueContext2D.strokeRect(i, j, CARRE, CARRE);
                }
            }


            //--------------------Numero colonne--------------------
            int numCol = 1;
            graphiqueContext2D.setFill(COULEUR_GRILLE);
            for (int i = CARRE; i < TAILLE_MAP[0]; i += CARRE){
                graphiqueContext2D.fillText(Integer.toString(numCol), i + CARRE/3, CARRE/2);
                numCol ++;
            }
            int nmbColonne = numCol;


            //---------------------Numero ligne----------------------
            int numLigne = 1;
            graphiqueContext2D.setFill(COULEUR_GRILLE);
            for (int i = CARRE; i < TAILLE_MAP[1]; i += CARRE){
                graphiqueContext2D.fillText(Integer.toString(numLigne), CARRE/3, i+CARRE/2);
                numLigne++;
            }
            int nmbLigne = numLigne;


            //----------------Composants à la racine----------------
            this.getChildren().add(labelNombreDePas);
            VBox.setMargin(labelNombreDePas, new Insets(30));
            this.getChildren().add(canvasCarte);
            VBox.setMargin(canvasCarte, new Insets(30));


            //-----------------------Apprenti-----------------------
            graphiqueContext2D.setFill(COULEURS[1]);
            graphiqueContext2D.fillOval(
                    joueur.getPosition().getPosX() * CARRE + CARRE / 8,
                    joueur.getPosition().getPosY() * CARRE + CARRE / 4,
                    LARGEUR_OVALE, HAUTEUR_OVALE);


            //------------------------Event------------------------

            canvasCarte.setOnMouseClicked(eventClicked -> {
                        int abscisse = (int) eventClicked.getX() / CARRE;
                        int ordonnee = (int) eventClicked.getY() / CARRE;
                        int[] positionCliquee = {abscisse, ordonnee};

                        // empêche le programme de dessiner une cible sur une case coordonée
                        if (positionCliquee[0] != 0) {
                            if(positionCliquee[1] != 0) {
                                System.out.println(positionCliquee[0] + ", " + positionCliquee[1]);
                                graphiqueContext2D.setFill(COULEUR_DESTINATION);
                                graphiqueContext2D.fillRect(
                                        positionCliquee[0] * CARRE + CARRE / 8,
                                        positionCliquee[1] * CARRE + CARRE / 4,
                                        LARGEUR_CIBLE, HAUTEUR_CIBLE);

                                // TODO: TEMPORAIRE! NE PAS GARDER ÇA!!!
                                joueur.teleporteur(positionCliquee[0],positionCliquee[1]);
                            }
                        }
                    });
    }

    public static Joueur getJoueur(){
        return joueur;
    }

    public static MenuBar getMenuBar(){return menuBar;}

    public void setTemples(HashSet<Temple> parTemples){
        temples = parTemples;
    }


    public void setCristaux(HashSet <Cristal> parCristaux){
        cristaux = parCristaux;
    }
}




