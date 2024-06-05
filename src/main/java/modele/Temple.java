package modele;


import exception.ExceptionManquant;
import exception.ExceptionPosition;
import interfaces.CONSTANTES_MAP;

/**
 * Object pour faire un temple qui contient une position et une couleur
 */
public class Temple implements CONSTANTES_MAP {
     Position position;
     int couleur;

     /**
      * méthode pour copier un temple sans copier l'objet
      * @return : le nouvel objet
      */
     public Temple copy(){
          return new Temple(position.getPosX(), position.getPosY(), couleur);


     }
     //--------------------------Constructeur--------------------------

     /**
      * Constructeur pour créer un temple
      * @param parPosX : position sur l'axe X
      * @param parPosY : position sur l'axe Y
      * @param parNumCouleur : code de la couleur du temple
      */
     public Temple(int parPosX, int parPosY, int parNumCouleur){
          position = new Position(parPosX, parPosY);
          couleur = parNumCouleur;

          // On vérifie si la position et la couleur sont correcte
          ExceptionPosition.VerifierPositionObjet(position, this);
          ExceptionManquant.VerifierCouleurObjet(couleur);
     }

     /**
      * getter de la position
      * @return la position
      */
     public Position getPosition(){
          return position;
     }

     /**
      * getter de la couleur
      * @return la couleur
      */
     public int getCouleur(){
          return couleur;
     }


     /**
      * Méthode toString pour débuggé et savoir où est le temple et quelle est sa couleur
      * @return une phrase pour afficher ses attributs
      */
     public String toString(){
          return "position : (" +position.getPosX() + "," + position.getPosY() + ") couleur :" + couleur;
     }
}
