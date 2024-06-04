package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import interfaces.CONSTANTES_MAP;
import javafx.scene.control.TableView;
import modele.Cristal;
import modele.Map;
import modele.Position;

public class VBoxInfos extends VBox implements CONSTANTES_MAP {
    private Label nombrePasLabel;
    private static Button peuxPrendreCristal;
    private static Button peuxPoserCristal;
    private static Label possessionLabel;

    private TableView<String> historique = Map.getJoueur().getHistorique();

    public VBoxInfos(){

        // Initiation des variables
        nombrePasLabel = Map.getJoueur().getLabelPas();
        peuxPrendreCristal = new Button("Prendre le cristal");
        peuxPoserCristal = new Button("Poser le cristal");
        possessionLabel = new Label("Vous n'avez pas de cristal en main");

        // Ajout sur la fenêtre

        // affichage
        this.getChildren().add(nombrePasLabel);
        this.getChildren().add(peuxPrendreCristal);
        this.getChildren().add(peuxPoserCristal);
        this.getChildren().add(possessionLabel);
        this.getChildren().add(historique);

        TableColumn<String, String> intituleColumn = new TableColumn<>("historique");

        intituleColumn.setCellValueFactory(new PropertyValueFactory<>("historique"));
        historique.getColumns().add(intituleColumn);

        peuxPrendreCristal.setOnAction(HBoxRoot.getControleur());
        peuxPoserCristal.setOnAction(HBoxRoot.getControleur());

    }

    public static void verifPossession(Position positionArrivee){
        // On les initialise à impossible et on change si c'est possible
        peuxPrendreCristal.setUserData("Impossible");
        peuxPoserCristal.setUserData("Impossible");

        // System.out.println("Vérif Possession lancé !!");
        // System.out.println("--------------------");
        if (Map.getJoueur().getCristalEnMain() != null){
            int numCouleur = Map.getJoueur().getCristalEnMain().getCouleur();
            System.out.println("Numéro de la couleur : " + numCouleur);
            possessionLabel.setText("Vous avez le cristal " + NOM_COULEURS[numCouleur]);
        }
        else{
            possessionLabel.setText("Vous n'avez pas de cristal en main");
        }

        // On associe les bouttons aux actions
        // On vérifie si il y a un cristal à la position du joueur
        System.out.println(positionArrivee);

        for (Position posCristal: Map.getCoordonneesCristaux().keySet()) {
            if (positionArrivee.equals(posCristal)) {
                // Si il y a un cristal qui est à cette position
                // on le récupère et on l'associe au bouton getCristal

                Cristal cristalIci = Map.getCoordonneesCristaux().get(posCristal);
                peuxPrendreCristal.setUserData(cristalIci);
            }
        }

        // On vérifie si on a un cristal
        if (Map.getJoueur().getCristalEnMain() != null) {
            // On vérifie si on est sur un temple
            for(Position posTemple: Map.getCoordonneesTemples().keySet()){
                if(posTemple.equals(positionArrivee)) {
                    System.out.println("Cristal peut être posé sur le temple");
                    peuxPoserCristal.setUserData(Map.getCoordonneesTemples().get(posTemple));
                }
            }

        }
    }

}
