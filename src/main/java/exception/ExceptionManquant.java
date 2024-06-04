package exception;

import interfaces.CONSTANTES_ERREUR;
import interfaces.CONSTANTES_MAP;


public class ExceptionManquant extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP {
    int numErreur;
    String messageErreur;

    public ExceptionManquant(int parNumErreur) {
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR_MANQUANT[parNumErreur];
    }

    public static void VerifierCouleurObjet(int numCouleur){
        try{
            if (numCouleur > COULEURS.length || numCouleur < 1){
                // La couleur 1 est prise par le joueur
                // donc il ne faut pas que d'autres éléments aient la même couleur
                throw new ExceptionPosition(2);
            }
        } catch(ExceptionPosition erreur){
            System.out.println(erreur.getMessageErreur());
            System.exit(erreur.getNumErreur());
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