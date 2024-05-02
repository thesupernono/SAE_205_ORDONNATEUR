package modele;


import javafx.util.Pair;

public class Temple {
     Pair<Integer, Integer> position;
     int couleur;


     //--------------------------Constructeur--------------------------
     public Temple(int parPositionX, int parPositionY, int parNumCouleur){
          position = new Pair<>(parPositionX, parPositionY);
          couleur = parNumCouleur;
     }


     public Pair<Integer, Integer> getPosition(){
          return position;
     }


     public String toString(){
          return position + " avec la couleur " + couleur;
     }
}
