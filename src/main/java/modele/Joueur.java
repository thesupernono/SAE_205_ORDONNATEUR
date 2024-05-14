package modele;

public class Joueur {
    private int [] position;
    private Cristal cristaux;

    /**
     * Créer un joueur avec sa position sur la carte et son identifiant (numéro de joueur)
     * @param PosX position x du joueur
     * @param PosY position y du joueur
     */
    public Joueur(int PosX, int PosY){
        position = new int [2];

        position[0] = PosX;
        position[1] = PosY;


        cristaux = null;
    }

    /**
     * Téléporteur pour vérifier si le joueur peut bien sé déplacer
     * @param posX (int) : position à téléporter (en x)
     * @param posY (int) : position à téléporter (en y)
     */
    public void teleporteur(int posX, int posY){
      position[0] = posX;
      position[1] = posY;
    }


    /**
     * Déplace le joueur jusqu'à qu'il soit arrivé
     * @param positionArrivee (int []) : position d'arrivée
     */
    public void deplacement(int [] positionArrivee) throws ExceptionJeu {
        if(positionArrivee.length != 2)
            throw new ExceptionJeu(0);
        while(position != positionArrivee){


            // On vérifie sur l'axe x (position[0])
            if(position[0] != positionArrivee[0]){
                if(position[0] < positionArrivee[0])
                    position[0] ++; // On se décale à droite
                else
                    position[0]--; // On se décale à gauche
            }


            // On vérifie sur l'axe y (position[1])
            else if(position[1] != positionArrivee[1]){
                if(position[1] < positionArrivee[1])
                    position[1] ++; // On se décale en bas
                else
                    position[1]--; // On se décale en haut
            }
        }

  }

    /**
     * Accesseur de Position
     * @return positionX, positionY
     */
    public int [] getPosition(){
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
        return "Position X:" + position[0] + ", Position Y:" + position[1];
    }
}
