package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static interfaces.CONSTANTES_MAP.TAILLE_FENETRE;

/**
 * Application pour démarrer notre jeu
 */
public class ApplicationJeu extends Application {

    /**
     * Démarrage de l'application
     * @param stage : Fenêtre donnée
     * @throws Exception : gestion des erreurs de HBoxRoot
     */
    @Override
    public void start(Stage stage) throws Exception {
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root, TAILLE_FENETRE[0],TAILLE_FENETRE[1]);
        stage.setScene(scene);
        stage.setTitle("SAE ORDONNATEUR");
        stage.show();
    }

    /**
     * Méthode appellée par défaut pour démarrer l'applcation
     * @param args : listre non utilisé de paramètre
     */
    public static void main(String [] args){
        Application.launch();
    }
}