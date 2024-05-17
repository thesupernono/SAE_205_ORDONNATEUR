package modele;

import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import vue.VBoxTemple;

import java.io.File;

public class MenuJeu extends MenuBar {
    public MenuJeu(){

        VBox.setMargin(this, new Insets(9));

        // Menu des scénarios
        Menu menuScenarios = new Menu("Scenarios");
        this.getMenus().add(menuScenarios);

        //listes des scénario du menu
        File[] scenarios = new File("Scenario").listFiles();


        for (File scenario : scenarios) { // lecture de la LISTE des fichiers
            MenuItem menuItemScenar = new MenuItem(scenario.getName());
            menuItemScenar.setUserData(scenarios);

            // menuItemScenar.setOnAction(controleur); Quand on aura un controleur fonctionnel
            menuScenarios.getItems().add(menuItemScenar);
        }


        //Informations sur le joueur
        //TODO: changer l'endroit ou et affiché les infos joueur lors de la mise en place du GridPane
        Menu infosJoueur = new Menu("infos");


        // Un joueur ( temporaire )
        Joueur joueur = VBoxTemple.getJoueur();

        MenuItem menuItemPosX = new MenuItem("Position X: " + joueur.getPosition().getPosX());
        MenuItem menuItemPosY = new MenuItem("Position Y: " + joueur.getPosition().getPosX());

        this.getMenus().add(infosJoueur);

        infosJoueur.getItems().add(menuItemPosX);
        infosJoueur.getItems().add(menuItemPosY);
    }
}
