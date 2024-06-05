package interfaces;

/**
 * Gestion des messages d'erreurs
 */
public interface CONSTANTES_ERREUR {
    /**
     * liste des message des phrases pour gérer les erreurs lié aux positions
     */
    String [] MESSAGE_ERREUR_POSITION = {
            "Position du joueur non valide",                                // 0
            "Position d'un temple / cristal n'est pas valide dans la map",  // 1
            "Position d'un objet n'est pas valide",                         // 2
    };

    /**
     * liste des message des phrases pour gérer les erreurs lors qu'il manque un élément
     */
    String [] MESSAGE_ERREUR_MANQUANT = {
            "Cristal manquant dans le fichier scenario",                    // 0
            "Aucun temple dans le fichier scenario",                        // 1
            "Le numéro de la couleur n'est pas configuré",                  // 2
            "Au moins un temple n'a pas son cristal associé"                // 3
    };
    /**
     * liste des message des phrases pour gérer les erreurs lors d'une action impossible
     */
    String [] MESSAGE_ERREUR_IMPOSSIBLE = {
            "L'action que vous venez de faire est impossible",              // 0
            "Le fichier de scenario n'a pas pu être lu"                     // 1
    };

    String [] MOUVEMENT_INTERDIT = {
            "Vous ne pouvez pas poser un cristal si vous n'en avez pas ",   // 0
            "Vous ne pouvez pas poser un cristal là où il y en a déjà un",  // 1
            "Vous ne pouvez pas prendre plusieurs cristaux à la fois"       // 2
    };
}
