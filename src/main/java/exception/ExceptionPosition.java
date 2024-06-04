package exception;

import interfaces.CONSTANTES_ERREUR;
import interfaces.CONSTANTES_MAP;
import modele.Joueur;
import modele.Position;
import modele.Temple;

import static exception.ExceptionProcedure.procedureErreur;

public class ExceptionPosition extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP {
    int numErreur;
    String messageErreur;

    public ExceptionPosition(int parNumErreur){
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR_POSITION[parNumErreur];
    }

    /**
     * Regarde si la Position selectionné est dans les limite de la map.
     * @param position position
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
                else
                    throw new ExceptionPosition(2);
            }
        }
        catch(ExceptionPosition e){
            procedureErreur(e);
        }
    }

    public static void VerifierCouleurObjet(int numCouleur){
        try{
            if (numCouleur > COULEURS.length || numCouleur < 1){
                // La couleur 1 est prise par le joueur
                // donc il ne faut pas que d'autres éléments aient la même couleur
                throw new ExceptionPosition(3);
            }
        } catch(ExceptionPosition e){
            procedureErreur(e);
        }
    }

    public int getNumErreur(){
        return numErreur;
    }

    public String getMessageErreur(){return messageErreur;}

    public String toString(){
        return "L'application s'est terminé avec le code erreur " + numErreur + ": " + messageErreur;
    }
}
