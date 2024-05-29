package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modele.*;

import java.io.File;
import java.util.HashSet;

public class VBoxTemple extends VBox implements CONSTANTES_MAP {

    private static Map map;
    private Canvas canvasCarte;
    private static GraphicsContext graphiqueContext2D;

    // private Controller controleur;

    public VBoxTemple() throws Exception {

        //-------------------------Map-------------------------
        canvasCarte = new Canvas();
        canvasCarte.setWidth(TAILLE_MAP[0]); // NOMBRE_CARRE * TAILLE_CARRE ?
        canvasCarte.setHeight(TAILLE_MAP[1]);
        graphiqueContext2D = canvasCarte.getGraphicsContext2D();

        map = new Map(SCENARIO_DEFAUT);


        //-----------------Initiation des bordures des carrés-----------------
        graphiqueContext2D.setStroke(COULEUR_GRILLE);
        for (int i = 0; i < NOMBRE_CARRE * TAILLE_CARRE; i += TAILLE_CARRE) {
            for (int j = 0; j < NOMBRE_CARRE * TAILLE_CARRE; j += TAILLE_CARRE) {
                graphiqueContext2D.strokeRect(i, j, TAILLE_CARRE, TAILLE_CARRE);
            }
        }


        //--------------------Numero colonne--------------------
        int numCol = 1;
        graphiqueContext2D.setFill(COULEUR_GRILLE);
        for (int i = TAILLE_CARRE; i < NOMBRE_CARRE * TAILLE_CARRE; i += TAILLE_CARRE) {
            graphiqueContext2D.fillText(Integer.toString(numCol), i + TAILLE_CARRE / 3, TAILLE_CARRE / 2);
            numCol++;
        }


        //---------------------Numero ligne----------------------
        int numLigne = 1;
        graphiqueContext2D.setFill(COULEUR_GRILLE);
        for (int i = TAILLE_CARRE; i < NOMBRE_CARRE * TAILLE_CARRE; i += TAILLE_CARRE) {
            graphiqueContext2D.fillText(Integer.toString(numLigne), TAILLE_CARRE / 3, i + TAILLE_CARRE / 2);
            numLigne++;
        }


        //------------------------Event------------------------

        canvasCarte.setOnMouseClicked(event -> {
            Joueur joueur = Map.getJoueur();
            int abscisse = (int) event.getX() / TAILLE_CARRE;
            int ordonnee = (int) event.getY() / TAILLE_CARRE;

            if (abscisse >= 1 && ordonnee >= 1) {
                System.out.println(abscisse + ", " + ordonnee);
                Position posArrivee = new Position(abscisse, ordonnee);
                joueur.deplacement(posArrivee);
            }
        });

        MenuJeu menuJeu = new MenuJeu();

        // ----------------TRI-----------------
        Tri tri = new Tri();
        /*
        tri.TriBasique();
        System.out.println(tri.toString());
        */
        System.out.println(tri.getHashTemples());
        System.out.println(tri.toString());


        this.getChildren().add(menuJeu);
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));

    }

    public static GraphicsContext getGraphiqueContext2D() {
        return graphiqueContext2D;
    }

    public static Map getMap(){
        return map;
    }
}




