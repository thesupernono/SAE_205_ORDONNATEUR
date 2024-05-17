package modele;


public class Joueur{
    private Position position;
    private Cristal cristaux;

    /**
     * Créer un joueur avec sa position sur la carte et son identifiant (numéro de joueur)
     * @param posX position x du joueur
     * @param posY position y du joueur
     */
    public Joueur(int posX, int posY){
        position = new Position(posX, posY);


        cristaux = null;
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


            // On vérifie sur l'axe x (position[0])
            if(position.getPosX() != positionArrivee.getPosX()){
                if(position.getPosX() < positionArrivee.getPosX())
                    position.deplacement("D"); // On se décale à droite
                else
                    position.deplacement("G"); // On se décale à gauche
            }


            // On vérifie sur l'axe y (position[1])
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
     * Permet de prendre et échanger les cristaux entre eux
     * @param cristal le cristal en question
     * @return cristalDepose si le joueur possede déjà un cristal
     * sinon retourne null
     */
    public Cristal prendreCristal(Cristal cristal){
        if(cristaux == null) {
            cristaux = cristal;
        }
        else{
            Cristal cristalDepose = cristaux;
            cristaux = cristal;
            return cristalDepose;
        }
        return null;
    }

    /**
     * Permet d'afficher les informations liée au joueur en une string
     * @return une String
     */
    public String toString(){
        return "Position X:" + position.getPosX() + ", Position Y:" + position.getPosY();
    }
}
