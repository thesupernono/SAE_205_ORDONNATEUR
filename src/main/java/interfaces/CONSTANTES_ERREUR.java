package interfaces;

public interface CONSTANTES_ERREUR {
    /**
     * Gestionnaire d'erreurs :
     *          numéro de l'erreur  :   Description
     *          0                   :   position.length != 0 (pas que 2 données rentrée pour une position)
     */
    public String [] MESSAGE_ERREUR_POSITION = {
            "Position du joueur non valide",                                // 0
            "Position d'un temple / cristal n'est pas valide dans la map",  // 1
            "Position d'un objet n'est pas valide",                         // 2
    };

    public String [] MESSAGE_ERREUR_MANQUANT = {
            "Cristal manquant dans le fichier scenario",                    // 0
            "Aucun temple dans le fichier scenario",                        // 1
            "Le numéro de la couleur n'est pas configuré"                   // 2
    };

    public String [] MESSAGE_ERREUR_IMPOSSIBLE = {
            "L'action que vous venez de faire est impossible",              // 0
            "Le fichier de scenario n'a pas pu être lu"                     // 1
    };
}
