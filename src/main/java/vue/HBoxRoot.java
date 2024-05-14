package vue;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HBoxRoot extends HBox {
    private VBox vBoxTemple;
    public HBoxRoot(){
        vBoxTemple = new VBoxTemple();
        this.getChildren().add(vBoxTemple);
    }

}
