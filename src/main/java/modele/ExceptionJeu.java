package modele;

public class ExceptionJeu extends Exception implements CONSTANTES_ERREUR{
    int numErreur;
    String messageErreur;


    public ExceptionJeu(int parNumErreur){
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR[parNumErreur];
        System.out.println("erreur : " + messageErreur);
    }
}
