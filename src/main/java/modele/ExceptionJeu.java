package modele;

import interfaces.CONSTANTES_ERREUR;
import interfaces.CONSTANTES_MAP;

public class ExceptionJeu extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP {
    int numErreur;
    String messageErreur;

    public ExceptionJeu(int parNumErreur){
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR[parNumErreur];
    }

    public static void procedureErreur(ExceptionJeu erreur){
        System.out.println(erreur.getMessageErreur());
        System.exit(erreur.getNumErreur());
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
                    throw new ExceptionJeu(0);
                else if (element instanceof Temple)
                    // Si le temple est mal initié pour un temple, c'est aussi le cas pour un cristal
                    throw new ExceptionJeu(1);
                else
                    throw new ExceptionJeu(2);
            }
        }
        catch(ExceptionJeu e){
            procedureErreur(e);
        }
    }

    public static void VerifierCouleurObjet(int numCouleur){
        try{
            if (numCouleur > COULEURS.length || numCouleur < 0){
                throw new ExceptionJeu(3);
            }
        } catch(ExceptionJeu e){
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
