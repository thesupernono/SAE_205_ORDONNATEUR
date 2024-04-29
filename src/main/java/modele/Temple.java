package modele;

import javafx.scene.paint.Color;
import javafx.util.Pair;

public class Temple {
     Pair<Integer, Integer> position;
     Color couleur;


     //--------------------------Constructeur--------------------------
     public Temple(Pair<Integer, Integer> parPosition, Color parCouleur){
          position = parPosition;
          couleur = parCouleur;
     }


     public String toString(){
          return position + " avec la couleur " + couleur.toString();
     }
}
