package modele;


public class Joueur{
    private Position position;
    private Cristal cristal;
    private int pas;

    /**
     * Créer un joueur avec sa position sur la carte et son identifiant (numéro de joueur)
     * @param posX position x du joueur
     * @param posY position y du joueur
     */
    public Joueur(int posX, int posY){
        position = new Position(posX, posY);
        pas = 0;


        cristal = null;
    }

    /**
     * Téléporteur pour vérifier si le joueur peut bien sé déplacer
     * @param posX (int) : position à téléporter (en x)
     * @param posY (int) : position à téléporter (en y)
     */
    public void teleporteur(int posX, int posY){
      position.teleporteur(posX, posY);
    }


    /**
     * Déplace le joueur jusqu'à qu'il soit arrivé
     * @param positionArrivee (int []) : position d'arrivée
     */
    public void deplacement(Position positionArrivee){
        while(position != positionArrivee){


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

    public int getPas(){
        return pas;
    }

    public void ajoutPas(){
        pas++;
        // VBoxTemple.updateNombrePas(); la méthode n'existe pas??
    }


    /**
     * Permet de prendre et échanger les cristaux entre eux
     * @param parCristal le cristal en question
     */
    public void prendreCristal(Cristal parCristal){
        //if(this.cristal == null) {
        //    this.cristal = cristal;
        //}
        //else{
        //    Cristal cristalDepose = this.cristal;
        //    this.cristal = cristal;
        //}
        cristal = parCristal;

        // On met la position -1 -1 dans la position pour enlever le cristal du graphique
        cristal.setPosition(new Position(-1, -1));

    }

    /**
     * méthode qui pose le cristal que l'on a en main
     * @return le cristal que l'on a en main
     */
    public Cristal poserCristal(){

        // On récupère le cristal que l'on va return ( le cristal qu'on a en main)
        Cristal cristalRetournee = cristal;

        // On enlève le cristal de la main
        cristal = null;

        // On return le cristal que l'on avait en main
        return cristal;
    }


    public Joueur getJoueur(){
        return new Joueur(position.getPosX(), position.getPosY());
    }

    /**
     * Permet d'afficher les informations liée au joueur en une string
     * @return une String
     */
    public String toString(){
        return "Position X:" + position.getPosX() + ", Position Y:" + position.getPosY();
    }
}
