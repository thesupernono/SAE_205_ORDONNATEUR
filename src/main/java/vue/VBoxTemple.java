package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modele.CONSTANTES_MAP;
import modele.Cristal;
import modele.Joueur;
import modele.Temple;

import java.io.File;
import java.util.HashSet;

public class VBoxTemple extends VBox implements CONSTANTES_MAP {

    private Joueur joueur;
    private HashSet <Temple> temples;
    private HashSet <Cristal> cristaux;
    private Label labelNombreDePas;
    private Canvas canvasCarte;
    private GraphicsContext graphiqueContext2D;

    // private Controller controleur;

    public VBoxTemple() {
        joueur = new Joueur(CENTRE_X, CENTRE_Y);
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


        for (int i = 0 ; i < scenarios.length; i++){ // lecture de la LISTE des fichiers
            MenuItem menuItemScenar = new MenuItem(scenarios[i].getName());
            menuItemScenar.setUserData(scenarios);

            // menuItemScenar.setOnAction(controleur); Quand on aura un controleur fonctionnel
            menuScenarios.getItems().add(menuItemScenar);
        }




        //Informations sur le joueur
        Menu infosJoueur = new Menu("Infos");
        MenuItem menuItemPosX = new MenuItem("Position X: " + joueur.getPosition()[0]);
        MenuItem menuItemPosY = new MenuItem("Position Y: " + joueur.getPosition()[1]);

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
                    joueur.getPosition()[0] * CARRE + CARRE / 8,
                    joueur.getPosition()[1] * CARRE + CARRE / 4,
                    LARGEUR_OVALE, HAUTEUR_OVALE);


            //------------------------Event------------------------
        /*
            canvasCarte.setOnMouseClicked(event -> {
                int abscisse = (int) event.getX() / CARRE;
                int ordonnee = (int) event.getY() / CARRE;
                int [] positionCliquee = {abscisse,ordonnee};
                System.out.println(positionCliquee);
                graphiqueContext2D.setFill(COULEUR_DESTINATION);
                graphiqueContext2D.fillRect(
                        positionCliquee.getAbscisse() * CARRE + CARRE / 8,
                        positionCliquee.getOrdonnee() * CARRE + CARRE / 4,
                        LARGEUR_CIBLE, HAUTEUR_CIBLE);
            });
         */
        }

    public Joueur getJoueur(){
        return joueur;
    }

    public void setTemples(HashSet<Temple> parTemples){
        temples = parTemples;
    }


    public void setCristaux(HashSet <Cristal> parCristaux){
        cristaux = parCristaux;
    }
}



