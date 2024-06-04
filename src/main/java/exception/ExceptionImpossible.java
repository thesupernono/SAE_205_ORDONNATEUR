package exception;

import interfaces.CONSTANTES_ERREUR;
import interfaces.CONSTANTES_MAP;

import static exception.ExceptionProcedure.procedureErreur;

public class ExceptionImpossible extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP {
    int numErreur;
    String messageErreur;

    public ExceptionImpossible(int parNumErreur) {
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR_IMPOSSIBLE[parNumErreur];
    }


    public int getNumErreur(){
        return numErreur;
    }

    public String getMessageErreur(){return messageErreur;}

}
