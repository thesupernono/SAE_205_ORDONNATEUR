package modele;

import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import java.io.File;

public class MenuJeu extends MenuBar {
    public MenuJeu(){

        VBox.setMargin(this, new Insets(9));

        // Menu des scénarios
        Menu menuScenarios = new Menu("Scenarios");
        this.getMenus().add(menuScenarios);

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


        // Un joueur ( temporaire )
        Joueur joueur = new Joueur(0, 5);

        MenuItem menuItemPosX = new MenuItem("Position X: " + joueur.getPosition()[0]);
        MenuItem menuItemPosY = new MenuItem("Position Y: " + joueur.getPosition()[1]);

        this.getMenus().add(infosJoueur);

        infosJoueur.getItems().add(menuItemPosX);
        infosJoueur.getItems().add(menuItemPosY);

    }
}
