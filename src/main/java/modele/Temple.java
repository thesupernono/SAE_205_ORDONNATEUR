package modele;


import exception.ExceptionManquant;
import exception.ExceptionPosition;
import interfaces.CONSTANTES_MAP;

public class Temple implements CONSTANTES_MAP {
     Position position;
     int couleur;


     //--------------------------Constructeur--------------------------
     public Temple(int parPosX, int parPosY, int parNumCouleur){
          position = new Position(parPosX, parPosY);
          couleur = parNumCouleur;

          // On vérifie si la position et la couleur sont correcte
          ExceptionPosition.VerifierPositionObjet(position, this);
          ExceptionManquant.VerifierCouleurObjet(couleur);
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
