package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.CONSTANTES_MAP;
import javafx.scene.control.TableView;
import modele.Map;

public class VBoxInfos extends VBox implements CONSTANTES_MAP {
    private TableView<String> historique = Map.getJoueur().getHistorique();
    private Button prendreCristal;
    private Button poserCristal;
    private Label possession;

    public VBoxInfos(){

        // Initiation des variables
        prendreCristal = new Button("Prendre le cristal");
        poserCristal = new Button("Poser le cristal");
        possession = new Label("Vous n'avez aucun cristal");

        // Ajout sur la fenêtre

        // affichage
        this.getChildren().add(prendreCristal);
        this.getChildren().add(poserCristal);
        this.getChildren().add(possession);
        this.getChildren().add(historique);

        TableColumn<String, String> intituleColumn = new TableColumn<>("historique");

        intituleColumn.setCellValueFactory(new PropertyValueFactory<>("historique"));
        historique.getColumns().add(intituleColumn);

    }

    public void actualiseePossession(){
        if (Map.getJoueur().getCristal() == null){
            possession = new Label("Vous n'avez aucun cristal");
        }
        possession = new Label("Vous avez le cristal" + COULEURS[Map.getJoueur().getCristal().getCouleur()]);
    }
}
