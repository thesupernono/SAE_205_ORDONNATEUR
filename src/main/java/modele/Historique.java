package modele;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashSet;

public class Historique {
    TableView<String> historique;
    TableColumn<String, String> historiqueDetails;

    public Historique(){
        System.out.println("Nouveau historique !");
        historique = new TableView<>();
        historiqueDetails = new TableColumn<>("Historique");

        historiqueDetails.setCellValueFactory(new PropertyValueFactory<>("String"));
        // L'historique n'est pas encore fonctionnel
        // historique.getColumns().add(historiqueDetails);

    }


    public TableView<String> getTableView(){
        return historique;
    }

    //--------------------------Ajout Evenement--------------------------

    // Si un joueur se déplace d'un point A à un point B, on ajoute un évènement
    public void ajoutEvenement(Position positionDepart, Position positionArrivee) {
        System.out.println("Ajout d'une position ");
        // On vérifie si la position est correcte

        String evenement = "Le joueur c'est déplacé de (" + positionDepart.getPosX() +", " + positionDepart.getPosY() +
                ") jusuqu'en (" + positionArrivee.getPosX() + ", " + positionArrivee.getPosY() + ")";
        historique.getItems().add(evenement);
    }


    // Si un cristal est déposé, pris, ou qu'un temple est complêté, on ajoute un évènement
    public void ajoutEvenement(Cristal cristal){
        String evenement;
        if(Map.getJoueur().getCristalEnMain() != null) {
            evenement = "Le cristal " + cristal.getCouleur() + " a été récupéré";
        }
        else{
            evenement = "Le cristal" + cristal.getCouleur() + " a été posé";
        }

        historique.getItems().add(evenement);
    }
}
