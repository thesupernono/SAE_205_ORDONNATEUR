package modele;

public interface CONSTANTES_ERREUR {
    /**
     * Gestionnaire d'erreurs :
     *          numéro de l'erreur  :   Description
     *          0                   :   position.length != 0 (pas que 2 données rentrée pour une position
     */
    public String [] MESSAGE_ERREUR = {
            "Il n'y a pas que 2 axes entrées pour la position",
            "Cristal manquant dans le fichier scenario",
            "Position d'un temple impossible",
            "Position du joueur impossible",
            "Temples manquant dans le fichier scenario"
    };
}
