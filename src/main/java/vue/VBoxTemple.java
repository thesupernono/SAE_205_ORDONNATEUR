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
    private HashSet<Temple> temples;
    private HashSet<Cristal> cristaux;
    private Label labelNombreDePas;
    private Canvas canvasCarte;
    private static GraphicsContext graphiqueContext2D;

    // private Controller controleur;

    public VBoxTemple() throws Exception {
        map = new Map(SCENARIO_DEFAUT);
        // controleur = new Controleur();

        // Barre de menu
        MenuBar menuBar = new MenuBar();
        this.getChildren().add(menuBar);
        VBox.setMargin(menuBar, new Insets(9));

        // Menu des scénarios
        Menu menuScenarios = new Menu("Scenarios");
        menuBar.getMenus().add(menuScenarios);

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

        menuBar.getMenus().add(infosJoueur);

        infosJoueur.getItems().add(menuItemPosX);
        infosJoueur.getItems().add(menuItemPosY);

        labelNombreDePas = new Label("Nombre de pas : 0");


        //-------------------------Map-------------------------
        canvasCarte = new Canvas();
        canvasCarte.setWidth(TAILLE_MAP[0]);
        canvasCarte.setHeight(TAILLE_MAP[1]);
        graphiqueContext2D = canvasCarte.getGraphicsContext2D();


        //-----------------Initiation de carrés-----------------
        graphiqueContext2D.setStroke(COULEUR_GRILLE);
        for (int i = 0; i < TAILLE_MAP[0]; i += TAILLE_CARRE) {
            for (int j = 0; j < TAILLE_MAP[1]; j += TAILLE_CARRE) {
                graphiqueContext2D.strokeRect(i, j, TAILLE_CARRE, TAILLE_CARRE);
            }
        }


        //--------------------Numero colonne--------------------
        int numCol = 1;
        graphiqueContext2D.setFill(COULEUR_GRILLE);
        for (int i = TAILLE_CARRE; i < TAILLE_MAP[0]; i += TAILLE_CARRE) {
            graphiqueContext2D.fillText(Integer.toString(numCol), i + TAILLE_CARRE / 3, TAILLE_CARRE / 2);
            numCol++;
        }


        //---------------------Numero ligne----------------------
        int numLigne = 1;
        graphiqueContext2D.setFill(COULEUR_GRILLE);
        for (int i = TAILLE_CARRE; i < TAILLE_MAP[1]; i += TAILLE_CARRE) {
            graphiqueContext2D.fillText(Integer.toString(numLigne), TAILLE_CARRE / 3, i + TAILLE_CARRE / 2);
            numLigne++;
        }

        //----------------Composants à la racine----------------
        this.getChildren().add(labelNombreDePas);
        VBox.setMargin(labelNombreDePas, new Insets(30));
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));


        //------------------------Event------------------------

        canvasCarte.setOnMouseClicked(event -> {
            int abscisse = (int) event.getX() / TAILLE_CARRE;
            int ordonnee = (int) event.getY() / TAILLE_CARRE;

            if (abscisse >= 1 && ordonnee >= 1) {
                System.out.println(abscisse + ", " + ordonnee);
                Position posElement = new Position(abscisse, ordonnee);
                ElementsGraphiques.deplacerElement(posElement, Map.getJoueur());
                //joueur.getPosition().deplacement("H");
            }
        });

    }

    public void setTemples(HashSet<Temple> parTemples) {
        temples = parTemples;
    }


    public void setCristaux(HashSet<Cristal> parCristaux) {
        cristaux = parCristaux;
    }

    public static GraphicsContext getGraphiqueContext2D() {
        return graphiqueContext2D;
    }

    public static Map getMap(){
        return map;
    }
}




