package modele;

import java.util.HashSet;

public class Historique {
    HashSet<String> historique;


    public Historique(){
        historique = new HashSet<>();
    }


    //--------------------------Ajout Evenement--------------------------

    // Si un joueur se déplace, on ajoute un évènement
    public void ajoutEvenement(int []positionJoueur) throws ExceptionJeu {

        // On vérifie si la position est correcte
        if(positionJoueur.length != 2)
            throw new ExceptionJeu(0);
            //TODO : Créer une class Position

        String evenement = "Le joueur c'est déplacé en " + positionJoueur[0] +", " + positionJoueur[1];
        historique.add(evenement);
    }


    // Si un cristal est déposé, pris, ou qu'un temple est complêté, on ajoute un évènement
    public void ajoutEvenement(String message){
        String evenement = "Vous avez " + message;

        historique.add(evenement);
    }
}
