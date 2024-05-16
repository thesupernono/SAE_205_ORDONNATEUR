package vue;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import modele.Cristal;
import modele.Joueur;
import modele.MenuJeu;
import modele.Temple;

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
        MenuBar menuJeu = new MenuJeu();
        this.getChildren().add(menuJeu);
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