package exception;

import interfaces.CONSTANTES_ERREUR;
import interfaces.CONSTANTES_MAP;

/**
 * Gestion des erreurs quand il manque des éléments
 */
public class ExceptionManquant extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP {
    /** code erreur */
    int numErreur;

    /** message d'erreur */
    String messageErreur;

    /**
     * Constructeur d'une erreur en fonction du code erreur
     * @param parNumErreur : le code erreur / numéro de l'erreur
     */
    public ExceptionManquant(int parNumErreur) {
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR_MANQUANT[parNumErreur];
    }

    /**
     * Méthode pour vérifier si un code couleur donné est correct
     * @param numCouleur : numéro du code couleur
     */
    public static void VerifierCouleurObjet(int numCouleur){
        try{
            if (numCouleur >= COULEURS.length || numCouleur < 1){
                System.out.println(numCouleur);
                // La couleur 1 est prise par le joueur
                // donc il ne faut pas que d'autres éléments aient la même couleur
                System.out.println("LAAAA");
                throw new ExceptionManquant(2);
            }
        } catch(ExceptionManquant erreur){
            System.out.println(erreur.getMessageErreur());
            System.exit(erreur.getNumErreur());
        }
    }

    /**
     * getter du code d'erreur
     * @return le numéro de l'erreur
     */
    public int getNumErreur(){
        return numErreur;
    }

    /**
     * getter du message d'erreur
     * @return le message d'erreur de type String
     */
    public String getMessageErreur(){return messageErreur;}

    /**
     * méthode toString pour afficher l'erreur avec son code
     * @return phrase du toString
     */
    public String toString(){
        return "L'application s'est terminé avec le code erreur " + numErreur + ": " + messageErreur;
    }

}