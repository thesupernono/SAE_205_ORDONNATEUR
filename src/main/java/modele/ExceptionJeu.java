package modele;

public class ExceptionJeu extends Exception implements CONSTANTES_ERREUR, CONSTANTES_MAP{
    int numErreur;
    String messageErreur;

    public ExceptionJeu(int parNumErreur){
        numErreur = parNumErreur;
        messageErreur = MESSAGE_ERREUR[parNumErreur];
    }

    /**
     * Regarde si la Position selectionné est dans les limite de la map.
     * @param parX position X
     * @param parY position Y
     */
    public static void VerifierObjet(int parX, int parY, int parCouleur){
        //TODO: CHANGER LES INT DANS LES IF AVEC LES CONSTANTES DE CONSTANTES_MAP
        try {
            if (parX > 10 || parX < 1) {
                throw new ExceptionJeu(2);
            }
            else if (parY > 10 || parY < 1) {
                throw new ExceptionJeu(2);
            }
            else if (parCouleur > COULEURS.length){
                throw new ExceptionJeu(4);
            }
        }
        catch(ExceptionJeu e){
            System.out.println(e.toString());
            System.exit(e.getNumErreur());
        }
    }

    public int getNumErreur(){
        return numErreur;
    }

    public String toString(){
        return "L'application s'est terminé avec le code erreur " + numErreur + ": " + messageErreur;
    }
}
