package exception;

import interfaces.CONSTANTES_ERREUR;
import interfaces.CONSTANTES_MAP;

import static exception.ExceptionProcedure.procedureErreur;

public class ExceptionManquant extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP {
    int numErreur;
    String messageErreur;

    public ExceptionManquant(int parNumErreur) {
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR_POSITION[parNumErreur];
    }

}