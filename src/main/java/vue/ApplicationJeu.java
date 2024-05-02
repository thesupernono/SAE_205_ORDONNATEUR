package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationJeu extends Application {
    @Override
    public void start(Stage stage) {
        VBoxTemple root = new VBoxTemple();
        Scene scene = new Scene(root, 1280,720);
        stage.setTitle("SAE ORDONNATEUR");
        stage.show();
    }
    public static void main(String [] args){
        Application.launch();
    }
}
