package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HBoxRoot extends HBox {

    private static VBox vBoxTemple;
    private static VBox vBoxInfos;
    private static Controleur controleur;

    public HBoxRoot() throws Exception {
        // Le controleur
        controleur = new Controleur();;
        vBoxTemple = new VBoxTemple();
        vBoxInfos = new VBoxInfos();

        this.getChildren().add(vBoxTemple);
        this.getChildren().add(vBoxInfos);
    }


    //--------------------Getter--------------------
    public static Controleur getControleur() {
        return controleur;
    }

    public static VBox getVBoxTemple(){
        return vBoxTemple;
    }


}
