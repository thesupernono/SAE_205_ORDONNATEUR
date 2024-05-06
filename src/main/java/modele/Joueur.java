package modele;

import javafx.util.Pair;

public class Joueur {
    private Pair<Integer,Integer> chPosition;
    private Cristal chCristalPorte;

    /**
     * Créer un joueur avec sa position sur la carte et son identifiant (numéro de joueur)
     * @param PosX position x du joueur
     * @param PosY position y du joueur
     */
    public Joueur(int PosX, int PosY){
        chPosition = new Pair<>(PosX,PosY);
        chCristalPorte = null;
    }

   public void deplacement(int PosX, int PosY){
      chPosition = new Pair<>(PosX,PosY);
  }

    /**
     * Accesseur de Position
     * @return listPos
     */
    public Pair <Integer, Integer> getPosition(){
//        List <Integer> listPos = new ArrayList<Integer>();
//        listPos.add(chPosX);
//        listPos.add(chPosY);
//        Remplacer par Pair
        return chPosition;
    }


    /**
     * Permet de prendre et échanger les cristaux entre eux
     * @param cristal le cristal en question
     * @return cristalDepose si le joueur possede déjà un cristal
     * sinon retourne null
     */
    public Cristal prendreCristal(Cristal cristal){
        if(chCristalPorte == null) {
            chCristalPorte = cristal;
        }
        else{
            Cristal cristalDepose = chCristalPorte;
            chCristalPorte = cristal;
            return cristalDepose;
        }
        return null;
    }

    /**
     * Permet d'afficher les informations liée au joueur en une string
     * @return une String
     */
    public String toString(){
        return "Position X:" + chPosition.getKey() + ", Position Y:" + chPosition.getValue();
    }
}
