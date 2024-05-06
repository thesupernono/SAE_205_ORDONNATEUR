package modele;

import javafx.util.Pair;

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


        cristaux = null;
    }

   public void deplacement(int posX, int posY){
      position[0] = posX;
      position[1] = posY;
  }

    /**
     * Accesseur de Position
     * @return positionX, positionY
     */
    public int [] getPosition(){
//        List <Integer> listPos = new ArrayList<Integer>();
//        listPos.add(chPosX);
//        listPos.add(chPosY);
//        Remplacer par Pair
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
