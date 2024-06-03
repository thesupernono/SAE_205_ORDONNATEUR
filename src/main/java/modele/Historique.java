package modele;

import java.util.HashSet;

public class Historique {
    HashSet<String> historique;


    public Historique(){
        historique = new HashSet<>();
    }


    //--------------------------Ajout Evenement--------------------------

    // Si un joueur se déplace d'un point A à un point B, on ajoute un évènement
    public void ajoutEvenement(Position positionJoueur) throws ExceptionJeu {

        // On vérifie si la position est correcte

        String evenement = "Le joueur c'est déplacé en " + positionJoueur.getPosX() +", " + positionJoueur.getPosY();
        historique.add(evenement);
    }


    // Si un cristal est déposé, pris, ou qu'un temple est complêté, on ajoute un évènement
    public void ajoutEvenement(String message){
        historique.add(message);
    }
}
