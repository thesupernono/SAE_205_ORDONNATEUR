package exception;

import interfaces.CONSTANTES_ERREUR;
import interfaces.CONSTANTES_MAP;

/**
 * Gestion des cas où l'on essaye de faire des choses impossible
 */
public class ExceptionImpossible extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP {
    /** numéro de l'erreur */
    int numErreur;

    /** message d'erreur */
    String messageErreur;

    /**
     * Constructeur de l'exception
     * @param parNumErreur : numéro de l'erreur
     */
    public ExceptionImpossible(int parNumErreur) {
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR_IMPOSSIBLE[parNumErreur];
    }

    /**
     * getter du numéro de l'erreur
     * @return numéro de l'erreyr (int)
     */
    public int getNumErreur(){
        return numErreur;
    }

    /**
     * getter du message d'erreur
     * @return le message d'erreur de type String
     */
    public String getMessageErreur(){return messageErreur;}

}
