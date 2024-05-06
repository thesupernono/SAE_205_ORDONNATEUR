package vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modele.Joueur;

import java.io.File;

public class VBoxTemple extends VBox{
    private Joueur apprenti;
    // private Controller controleur;

    public VBoxTemple(){
        apprenti = new Joueur(0,0);
        // controleur = new Controleur();

        // Barre de menu
        MenuBar menuBar = new MenuBar();
        this.getChildren().add(menuBar);
        VBox.setMargin(menuBar, new Insets(9));

        // Menu des scénarios
        Menu menuScenarios = new Menu("Scenarios");
        menuBar.getMenus().add(menuScenarios);

        //items du menu scénario
        File[] scenarios = new File("scenarios").listFiles();
        for (int i = 0 ; i < scenarios.length; i++){ // lecture de la LISTE des fichiers
            MenuItem menuItem = new MenuItem(scenarios[i].getName());
            menuItem.setUserData(scenarios);
            // menuItem.setOnAction(controleur); Quand on aura un controleur fonctionnel
            menuScenarios.getItems().add(menuItem);

        }
    }
}