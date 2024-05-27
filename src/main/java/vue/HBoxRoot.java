package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HBoxRoot extends HBox {

    private static VBox vBoxTemple;
    private static Controleur controleur;

    public HBoxRoot() throws Exception {
        // Le controleur
        controleur = new Controleur();

        vBoxTemple = new VBoxTemple();
        this.getChildren().add(vBoxTemple);
    }


    //--------------------Getter--------------------
    public static Controleur getControleur() {
        return controleur;
    }

    public static VBox getVBoxTemple(){
        return vBoxTemple;
    }


}
