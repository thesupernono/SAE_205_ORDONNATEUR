package modele;


public class Temple implements CONSTANTES_MAP{
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

     public int getCouleur(){
          return couleur;
     }


     public String toString(){
          return "position : (" +position.getPosX() + "," + position.getPosY() + ") couleur :" + couleur;
     }
}
