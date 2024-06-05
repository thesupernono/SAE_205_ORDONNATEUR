package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Racine de toutes les box afin de tout relier
 */
public class HBoxRoot extends HBox {

    private static VBox vBoxTemple;
    private static VBox vBoxInfos;
    private static Controleur controleur;

    /**
     * Constructeur principal
     * @throws Exception : on peut s'attendre à des erreurs de VBoxTemple qui sont géré par les exceptions
     */
    public HBoxRoot() throws Exception {
        // Le controleur
        controleur = new Controleur();
        vBoxTemple = new VBoxTemple();
        vBoxInfos = new VBoxInfos();

        this.getChildren().add(vBoxTemple);
        this.getChildren().add(vBoxInfos);
    }


    //--------------------Getter--------------------

    /**
     * getter static du controleur
     * @return : le controleur
     */
    public static Controleur getControleur() {
        return controleur;
    }

    /**
     * getter static de la VBoxTemple
     * @return la box Temple (de type VBox)
     */
    public static VBox getVBoxTemple(){
        return vBoxTemple;
    }


}
