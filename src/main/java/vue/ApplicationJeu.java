package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static modele.CONSTANTES_MAP.TAILLE_FENETRE;

public class ApplicationJeu extends Application {
    @Override
    public void start(Stage stage) {
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root, TAILLE_FENETRE[0],TAILLE_FENETRE[1]);
        stage.setScene(scene);
        stage.setTitle("SAE ORDONNATEUR");
        stage.show();
    }
    public static void main(String [] args){
        Application.launch();
    }
}