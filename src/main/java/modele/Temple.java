package modele;


public class Temple {
     int [] position;
     int couleur;


     //--------------------------Constructeur--------------------------
     public Temple(int parPositionX, int parPositionY, int parNumCouleur){
          position = new int[2];
          position[0] = parPositionX;
          position[1] = parPositionY;
          couleur = parNumCouleur;
     }


     public int [] getPosition(){
          return position;
     }


     public String toString(){
          return "position : (" +position[0] + "," + position[1] + ") couleur :" + couleur;
     }
}
