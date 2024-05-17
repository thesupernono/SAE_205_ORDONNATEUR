package modele;


public class Temple {
     Position position;
     int couleur;


     //--------------------------Constructeur--------------------------
     public Temple(int parPosX, int parPosY, int parNumCouleur){
          position = new Position(parPosX, parPosY);
          couleur = parNumCouleur;
     }


     public Position getPosition(){
          return position;
     }


     public String toString(){
          return "position : (" +position.getPosX() + "," + position.getPosY() + ") couleur :" + couleur;
     }
}
