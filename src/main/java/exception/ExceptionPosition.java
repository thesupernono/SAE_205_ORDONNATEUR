package exception;

import interfaces.CONSTANTES_ERREUR;
import interfaces.CONSTANTES_MAP;
import modele.Joueur;
import modele.Position;
import modele.Temple;

/**
 * Gestion des erreurs des positions
 */
public class ExceptionPosition extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP {
    /** code erreur */
    int numErreur;

    /** message d'erreur */
    String messageErreur;

    /**
     * Constructeur à partir du code d'erreur
     * @param parNumErreur : le code erreur
     */
    public ExceptionPosition(int parNumErreur){
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR_POSITION[parNumErreur];
    }

    /**
     * Regarde si la Position selectionné est dans les limite de la map.
     * @param position : position
     * @param element : element sur lequel on vérifie la position
     *                  afin de générer une erreur plus précise si besoin
     */
    public static void VerifierPositionObjet(Position position, Object element){
        try {
            if ((position.getPosX() > NOMBRE_CARRE || position.getPosX() < 1) // On vérifie les absices
              || position.getPosY() > NOMBRE_CARRE || position.getPosY() < 1) { // On vérifie les ordonnées
                if(element instanceof Joueur)
                    throw new ExceptionPosition(0);
                else if (element instanceof Temple)
                    // Si le temple est mal initié pour un temple, c'est aussi le cas pour un cristal
                    throw new ExceptionPosition(1);
                else {
                    System.out.println("C'est iCI");
                    throw new ExceptionPosition(2);
                }
            }
        }
        catch(ExceptionPosition erreur){
            System.out.println(erreur.getMessageErreur());
            System.exit(erreur.getNumErreur());
        }
    }

    /**
     * getter du numéro de l'erreur
     * @return : numéro de l'erreur
     */
    public int getNumErreur(){
        return numErreur;
    }

    /**
     * getter du message d'erreur
     * @return message d'erreur
     */
    public String getMessageErreur(){return messageErreur;}

    /**
     * Méthode toString afin de voir l'erreur avec le message
     * @return : la phrase du toString
     */
    public String toString(){
        return "L'application s'est terminé avec le code erreur " + numErreur + ": " + messageErreur;
    }
}
