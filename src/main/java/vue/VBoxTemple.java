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

        // On met pour chaque carré une bordure, + 1 pour l'affichage du nombre de ligne et de colone
        for (int i = 0; i < NOMBRE_CARRE * TAILLE_CARRE; i += TAILLE_CARRE) {
            for (int j = 0; j < NOMBRE_CARRE * TAILLE_CARRE; j += TAILLE_CARRE) {
                System.out.println("carré en " + i + ", " + j);
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
                Position posArrivee = new Position(abscisse, ordonnee);
                VBoxInfos.verifPossession(posArrivee);
                joueur.deplacement(posArrivee);
            }
        });

        // ---------------------Menu---------------------
        // Barre de menu
        MenuBar menuBar = new MenuBar();
        VBox.setMargin(menuBar, new Insets(9));

        // Menu des scénarios
        Menu menuScenarios = new Menu("Scenarios");

        //listes des scénario du menu
        File[] scenarios = new File("Scenario").listFiles();


        for (int i = 0; i < scenarios.length; i++) { // lecture de la LISTE des fichiers
            MenuItem menuItemScenar = new MenuItem(scenarios[i].getName());
            menuItemScenar.setUserData(scenarios);

            // menuItemScenar.setOnAction(controleur); Quand on aura un controleur fonctionnel
            menuScenarios.getItems().add(menuItemScenar);
        }


        //Informations sur le joueur
        Menu infosJoueur = new Menu("Infos");
        MenuItem menuItemPosX = new MenuItem("Position X: " + Map.getJoueur().getPosition().getPosX());
        MenuItem menuItemPosY = new MenuItem("Position Y: " + Map.getJoueur().getPosition().getPosY());
        infosJoueur.getItems().addAll(menuItemPosX, menuItemPosY);

        //Selection de Tri
        Menu triMenu = new Menu("Algorithmes");
        MenuItem menuTriBulle = new MenuItem("Tri bulle");
        MenuItem menuTriHeur = new MenuItem("Tri Heuristique");
        triMenu.getItems().addAll(menuTriBulle, menuTriHeur);


        menuBar.getMenus().addAll(menuScenarios,infosJoueur,triMenu); // ajoute tout les menu ensemble
        this.getChildren().add(menuBar);

        // ----------------TRI-----------------
        Tri tri = new Tri();
        System.out.println("Tri basique");
        tri.TriBasique();
        System.out.println(tri.toString());

        System.out.println("Tri heuristique:");
        tri.TriHeuristique();
        System.out.println(tri.toString());

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




