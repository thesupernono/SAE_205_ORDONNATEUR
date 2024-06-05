package modele;

import interfaces.CONSTANTES_MAP;

import java.util.HashMap;

/**
 * Objet qui contient les différents tris
 */
public class Tri implements CONSTANTES_MAP {

    /**
     * Fait un tri basique par couleurs en bulle
     * @return : retourne un tableau te temple, sachant qu'il faut commencer par le premier et finir par le dernier
     */
    public static Temple [] TriBasique(){
        HashMap <Position, Temple> hashTemples = Map.getCoordonneesTemples();
        Temple [] listeTemples = hashTemples.values().toArray(Temple []::new); // convertit hashTemples en Array
        int taille = listeTemples.length;
        Temple tampon;
        for(int i=0; i < taille; i++) { //parcours la liste
            for(int j=1; j < (taille-i); j++) {
                if(listeTemples[j-1].getCouleur() > listeTemples[j].getCouleur()) {
                    //echanges les elements
                    tampon = listeTemples[j-1];
                    listeTemples[j-1] = listeTemples[j];
                    listeTemples[j] = tampon;
                }
            }
        }
        return listeTemples;
    }

    /**
     * Fait un tri heuristique distances
     * @return : retourne un tableau te temple, sachant qu'il faut commencer par le premier et finir par le dernier
     */
    public static Temple [] TriHeuristique(){
        HashMap <Position, Temple> hashTemples = Map.getCoordonneesTemples();
        Temple [] listeTemples = hashTemples.values().toArray(Temple []::new); // convertit hashTemples en Array
        Position posJoueur = Map.getJoueur().getPosition();

        for (int i = 0; i < listeTemples.length; i++) { // on parcours tout les temples pour trouver les distances à trier
            boolean templesTriee = true; // variable permettant de stopper la boucle si le tri est terminé

            for(int j = 0; j < listeTemples.length - 1; j++){// verifie si nous sommes pas en fin de tableau
                int distance = posJoueur.distance(listeTemples[j].getPosition());
                int distanceDapres = posJoueur.distance(listeTemples[j+1].getPosition());
                if (distanceDapres < distance){
                    // echange les éléments
                    Temple tampon = listeTemples[j + 1];
                    listeTemples[j + 1] = listeTemples[j];
                    listeTemples[j] = tampon;

                    // continue le tableau en mettant la variable en false
                    templesTriee = false;
                }
            }
            if (templesTriee){
                break; // arrete la boucle
            }
        }

        // Maintenant que c'est trié, on return le résultat
        return listeTemples;
    }

    /**
     * On défini un protocole pour que les tri puissent marcher
     * @param templeAParcourir : les temples à parcourir (dans l'ordre où il faut passer)
     */
    public static void parcours(Temple [] templeAParcourir) {
        // On va au premier, il sort du lot, on commence par se déplacer jusqu'à là bas
        Temple premierTemple = templeAParcourir[0];
        // On déplace le joueur à ce temple
        Map.getJoueur().deplacement(premierTemple.getPosition());

        for(int indice = 1; indice < templeAParcourir.length; indice+= 1){
            // On prend le cristal
            Map.getJoueur().prendreCristal();

            // On récupère un nouveau temple
            Temple templeActuel = templeAParcourir[indice];

            // On va à ce temple
            Map.getJoueur().deplacement(premierTemple.getPosition());

            // On pose le cristal
            Map.getJoueur().poserCristal(templeActuel);

        }
    }
}
