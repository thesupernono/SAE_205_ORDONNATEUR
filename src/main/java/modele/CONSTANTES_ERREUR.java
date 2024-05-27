package modele;

public interface CONSTANTES_ERREUR {
    /**
     * Gestionnaire d'erreurs :
     *          numéro de l'erreur  :   Description
     *          0                   :   position.length != 0 (pas que 2 données rentrée pour une position)
     */
    public String [] MESSAGE_ERREUR = {
            "Position non valide",
            "Cristal manquant dans le fichier scenario",
            "Position d'un temple impossible",
            "Position du joueur impossible",
            "Couleur non valide",
            "Aucun temple dans le fichier scenario"
    };
}
