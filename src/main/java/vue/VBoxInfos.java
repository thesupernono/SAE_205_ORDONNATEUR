package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.CONSTANTES_MAP;
import javafx.scene.control.TableView;
import modele.Cristal;
import modele.Map;

public class VBoxInfos extends VBox implements CONSTANTES_MAP {
    private Label nombrePasLabel;
    private Button prendreCristal;
    private Button poserCristal;
    private Label possession;

    private TableView<String> historique = Map.getJoueur().getHistorique();

    public VBoxInfos(){

        // Initiation des variables
        nombrePasLabel = Map.getJoueur().getLabelPas();
        prendreCristal = new Button("Prendre le cristal");
        poserCristal = new Button("Poser le cristal");
        possession = new Label("Vous n'avez aucun cristal");

        // Ajout sur la fenêtre

        // affichage
        this.getChildren().add(nombrePasLabel);
        this.getChildren().add(prendreCristal);
        this.getChildren().add(poserCristal);
        this.getChildren().add(possession);
        this.getChildren().add(historique);

        TableColumn<String, String> intituleColumn = new TableColumn<>("historique");

        intituleColumn.setCellValueFactory(new PropertyValueFactory<>("historique"));
        historique.getColumns().add(intituleColumn);

        actualiseePossession();

        prendreCristal.setOnAction(HBoxRoot.getControleur());
        poserCristal.setOnAction(HBoxRoot.getControleur());

    }

    public void actualiseePossession(){
        if (Map.getJoueur().getCristal() != null){
            possession = new Label("Vous avez le cristal" + COULEURS[Map.getJoueur().getCristal().getCouleur()]);
        }
        else{
            possession = new Label("Vous n'avez aucun cristal");
        }

        // On associe les bouttons aux actions
        // On vérifie si on est sur un cristal avant de le prendre
        if (Map.getCoordonneesCristaux().get(Map.getJoueur().getPosition()) != null){
            Cristal cristalIci = Map.getCoordonneesCristaux().get(Map.getJoueur().getPosition());
            prendreCristal.setUserData(cristalIci);
        }
        else{
            prendreCristal.setUserData("Impossible");
        }

        // On vérifie si on a un cristal
        if (Map.getJoueur().getCristal() != null) {
            Cristal cristalPossede = Map.getJoueur().getCristal();
            poserCristal.setUserData(cristalPossede);
        }
        else{
            poserCristal.setUserData("Impossible");

        }
    }

}
