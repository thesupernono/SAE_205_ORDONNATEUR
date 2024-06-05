package modele;


import exception.ExceptionPosition;
import javafx.scene.control.Label;
import vue.VBoxInfos;

import java.util.HashMap;

/**
 * Objet joueur qui contient sa position, son cristal en main (qui vaut null quand il ne porte rien),
 * son nombre de pas, et le label sur ce nombre de pas
 */
public class Joueur{
    private Position position;
    private Cristal cristalEnMain;
    private int pas;
    private Label LabelPas = new Label("Vous avez fait 0 pas");

    private Historique historique;
    /**
     * Créer un joueur avec sa position sur la carte et son identifiant (numéro de joueur)
     * @param posX position x du joueur
     * @param posY position y du joueur
     */
    public Joueur(int posX, int posY) {
        position = new Position(posX, posY);
        pas = 0;

        // On défini son historique
        historique = new Historique();

        // On ne met rien dans sa main par défaut
        cristalEnMain = null;

        // On vérifie si le joueur a une position correcte
        ExceptionPosition.VerifierPositionObjet(position, this);
    }

    /**
     * setter d'une nouvelle position
     * @param nouvPosition : la nouvelle position du joueur
     */
    public void setPosition(Position nouvPosition){
        position = nouvPosition;
    }

    /**
     * getter du label du nombre de pas
     * @return le label du nombre de pas
     */
    public Label getLabelPas(){
        return LabelPas;
    }

    /**
     * getter de l'historique du joueur
     * @return l'historique
     */
    public Historique getHistorique(){
        return historique;
    }

    /**
     * getter du cristal en main
     * @return le cristal en main
     */
    public Cristal getCristalEnMain(){
        return cristalEnMain;
    }



    /**
     * Déplace le joueur jusqu'à qu'il soit arrivé
     * @param positionArrivee (int []) : position d'arrivée
     */
    public void deplacement(Position positionArrivee){
        System.out.println("marche Joueur l79");
        Map.getJoueur().getHistorique().ajoutEvenement(position, positionArrivee);
        while(position.getPosX() != positionArrivee.getPosX()
           || position.getPosY() != positionArrivee.getPosY()){


            // On vérifie sur l'axe x
            if(position.getPosX() != positionArrivee.getPosX()){
                if(position.getPosX() < positionArrivee.getPosX())
                    position.deplacement("D"); // On se décale à droite
                else
                    position.deplacement("G"); // On se décale à gauche
            }


            // On vérifie sur l'axe y
            else if(position.getPosY() != positionArrivee.getPosY()){
                if(position.getPosY() < positionArrivee.getPosY())
                    position.deplacement("B"); // On se décale en bas
                else
                    position.deplacement("H"); // On se décale en haut
            }
        }

  }
    /**
     * Accesseur de Position
     * @return positionX, positionY
     */
    public Position getPosition(){
        return position;
    }

    /**
     * getter du nombre de pas du joueur
     * @return le nombre de pas de type int
     */
    public int getPas(){
        return pas;
    }

    /**
     * méthode pour ajouter un pas
     */
    public void ajoutPas(){
        pas++;
        LabelPas.setText("Vous avez fait " + pas + " pas");
        // VBoxTemple.updateNombrePas(); la méthode n'existe pas??
    }


    /**
     * Permet de prendre un cristal
     */
    public void prendreCristal(){
        Position position = Map.getJoueur().getPosition();

        if (cristalEnMain != null) {
            System.out.println("Vous avez déjà un cristal en main");
            //TODO: exception : on ne peut pas récupérer un cristal si on en a déjà un en main
            return;
        }


        HashMap<Position, Cristal> coordonneesCristal = Map.getCoordonneesCristaux();

        // On cherche l'objet cristal à partir de sa position
        // Et on prend le cristal dans la main
        for(Position posCristal: coordonneesCristal.keySet()){
            if(posCristal.equals(position)){
                cristalEnMain = coordonneesCristal.get(posCristal);

                // On enlève le cristal de la map
                Map.getCoordonneesCristaux().remove(posCristal);

                // On arrète la boucle
                break;
            }
        }


        // On remet à jour les infos
        VBoxInfos.verifPossession(position);

    }

    /**
     * méthode qui pose le cristal que l'on a en main
     * @param temple : le temple sur lequel on est
     */
    public void poserCristal(Temple temple){
        // On vérifie si on a bien un cristal
        if(cristalEnMain == null)
            // TODO: faire une exception : on a pas de cristal et on veut en poser un
            return;

        System.out.println("première verif passée");

        // On vérifie si c'est le temple qui doit recevoir le cristal que l'on a
        // Si c'est le cas, on peut l'enlever de nôtre main et on a pas besoin de l'afficher de nouveau
        if (cristalEnMain.getCouleur() == temple.getCouleur()){
            cristalEnMain = null;
            ElementsGraphiques.resetGraphique(temple.getPosition());
            return;
        }
        System.out.println("deuxème verif passée");

        // Sinon, on commence par vérifier si on peut poser le cristal là où l'on est
        // C'est à dire si il n'y a pas déjà un cristal sur le temple
        for(Position posCristalCheck: Map.getCoordonneesCristaux().keySet()){
            if(posCristalCheck.equals(temple.getPosition()))
                //TODO: Dire que c'est impossible de poser un cristal là où il y en a déjà un
                return;
        }

        // Si on est arrivé là c'est que tout est bon, on peut poser le cristal
        // On fait une copie du cristal pour ne pas le perdre quand on l'enlèvera de la main
        Cristal cristalTemp = cristalEnMain.copy();

        // On l'ajouter sur la map
        Map.getCoordonneesCristaux().put(temple.getPosition(), cristalTemp);
        System.out.println("------------------");
        System.out.println(Map.getCoordonneesCristaux());

        // On le retire de nôtre main
        cristalEnMain = null;

        System.out.println("cristal posé");


        // On remet à jour les infos
        VBoxInfos.verifPossession(position);
    }

    /**
     * Permet d'afficher les informations liée au joueur en une string
     * @return une String
     */
    public String toString(){
        return "Position X:" + position.getPosX() + ", Position Y:" + position.getPosY();
    }
}
