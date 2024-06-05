package vue;

import interfaces.CONSTANTES_MAP;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import modele.*;

import java.io.File;

/**
 * Box de la partie graphique des cristaux, des temples et du joueur
 */
public class VBoxTemple extends VBox implements CONSTANTES_MAP {

    private static Map map;
    private static Canvas canvasCarte;
    private static GraphicsContext graphiqueContext2D;

    /**
     * Constructeur de la partie graphique
     * @throws Exception : gestion des erreurs de la map et des génération des cristaux / temples
     */
    public VBoxTemple() throws Exception {

        //-------------------------Map-------------------------
        canvasCarte = new Canvas();
        canvasCarte.setWidth(TAILLE_MAP[0]); // NOMBRE_CARRE * TAILLE_CARRE ?
        canvasCarte.setHeight(TAILLE_MAP[1]);
        graphiqueContext2D = canvasCarte.getGraphicsContext2D();

        map = new Map(SCENARIO_DEFAUT);

        // On initie la map en la faisant reset
        resetMap();

        // ---------------------Menu---------------------
        // Barre de menu
        MenuBar menuBar = new MenuBar();
        VBox.setMargin(menuBar, new Insets(9));

        // Menu des scénarios
        Menu menuScenarios = new Menu("Scenarios");

        //listes des scénario du menu
        File[] scenarios = new File("Scenario").listFiles();


        for (File scenario : scenarios) { // lecture de la LISTE des fichiers
            MenuItem menuItemScenar = new MenuItem(scenario.getName());
            menuItemScenar.setUserData(scenario);

            menuItemScenar.setOnAction(HBoxRoot.getControleur());
            menuScenarios.getItems().add(menuItemScenar);
        }

        menuBar.getMenus().addAll(menuScenarios); // ajout du menu à la barre
        this.getChildren().add(menuBar);


        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));
    }

    /**
     * getter du graphique
     * @return le graphique de type GraphicsContext
     */
    public static GraphicsContext getGraphiqueContext2D() {
        return graphiqueContext2D;
    }

    /**
     * getter de la map
     * @return la map
     */
    public static Map getMap(){
        return map;
    }

    /**
     * setter static d'une nouvelle map
     * @param nouvelleMap : la nouvelle map à associé
     */
    public static void setMap(Map nouvelleMap){
        map = nouvelleMap;
    }

    /**
     * Méthode static pour reset entièrement la map
     */
    public static void resetMap(){
        System.out.println("Reset lancé");

        //-----------------Initiation des bordures des carrés-----------------
        graphiqueContext2D.setStroke(COULEUR_GRILLE);

        // On met pour chaque carré une bordure, + 1 pour l'affichage du nombre de ligne et de colone
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
        System.out.println("marche VBoxTemple l138");

        canvasCarte.setOnMouseClicked(event -> {
            Joueur joueur = Map.getJoueur();
            int abscisse = (int) event.getX() / TAILLE_CARRE;
            int ordonnee = (int) event.getY() / TAILLE_CARRE;

            System.out.println("abscisse : " + abscisse);
            System.out.println("ordonnée : " + ordonnee);
            if (abscisse >= 1 && ordonnee >= 1) {
                Position posArrivee = new Position(abscisse, ordonnee);
                System.out.println("marche VBoxTemple l146");
                VBoxInfos.verifPossession(posArrivee);
                joueur.deplacement(posArrivee);
            }
        });
    }
}




