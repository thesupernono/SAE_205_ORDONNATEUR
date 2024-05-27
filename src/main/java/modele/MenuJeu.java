package modele;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import java.io.File;

public class MenuJeu extends MenuBar {
    private Label labelNombreDePas;
    private int nombrePas;


    public MenuJeu(){

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


        nombrePas = 0;
        labelNombreDePas = new Label("Nombre de pas : 0");


        //----------------Composants à la racine----------------
        this.getChildren().add(labelNombreDePas);
        VBox.setMargin(labelNombreDePas, new Insets(30));
    }


    public Label getLabelNombreDePas(){
        return  labelNombreDePas;
    }

    public void setNombreDePas(int parNombrePas){
        nombrePas = parNombrePas;
        labelNombreDePas = new Label("Nombre de pas : " + nombrePas);
    }
}
