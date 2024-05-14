package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modele.Cristal;
import modele.Joueur;
import modele.Temple;

import java.io.File;
import java.util.HashSet;

public class VBoxTemple extends VBox{
    private Joueur joueur;

    private HashSet <Temple> temples;
    private HashSet <Cristal> cristaux;
    private GridPaneMap gridPaneMap;


    // private Controller controleur;

    public VBoxTemple() {
        joueur = new Joueur(0, 0);
        // controleur = new Controleur();
        gridPaneMap = new GridPaneMap();

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
        //TODO: changer l'endroit ou et affiché les infos joueur lors de la mise en place du GridPane
        Menu infosJoueur = new Menu("Infos");
        MenuItem menuItemPosX = new MenuItem("Position X: " + joueur.getPosition()[0]);
        MenuItem menuItemPosY = new MenuItem("Position Y: " + joueur.getPosition()[1]);

        menuBar.getMenus().add(infosJoueur);

        infosJoueur.getItems().add(menuItemPosX);
        infosJoueur.getItems().add(menuItemPosY);

        this.getChildren().add(gridPaneMap);
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