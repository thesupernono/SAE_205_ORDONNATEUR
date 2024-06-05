package modele;

/**
 * Evenement qui serrent à gérer l'historique
 */
public class EvenementHistorique {
    private String messageEvenement;

    /**
     * Constructeur qui prend en paramètre un message et qui l'assigne
     * @param message
     */
    public EvenementHistorique(String message){
        messageEvenement = message;
    }

    /**
     * getter du message
     * @return le message de l'event
     */
    public String getMessageEvenement() {
        return messageEvenement;
    }

    /**
     * Le toString afin d'avoir une sortie pour historique
     * @return le message de l'evenement
     */
    @Override
    public String toString() {
        return messageEvenement;
    }
}
