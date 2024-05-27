package modele;

public class ExceptionJeu extends Exception implements CONSTANTES_ERREUR{
    int numErreur;
    String messageErreur;

    public ExceptionJeu(int parNumErreur){
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR[parNumErreur];
    }

    public String toString(){
        return "L'application s'est terminé avec le code erreur " + numErreur + ": " + messageErreur;
    }
}
