package modele;

import javafx.util.Pair;

public class Joueur {
    private int chPosX;
    private int chPosY;
    private Cristal chCristalPorte;

    /**
     * Créer un joueur avec sa position sur la carte et son identifiant (numéro de joueur)
     * @param PosX position x du joueur
     * @param PosY position y du joueur
     */
    public Joueur(int PosX, int PosY){
        chPosX = PosX;
        chPosY = PosY;
    }

   public void deplacement(){
      chPosX += 1; // TODO: A REMPLACER PLUS TARD BIEN ENTENDU
      chPosY += 1;
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
        return new Pair<>(chPosX, chPosY);
    }


    public void prendreCristal(Cristal cristal){
        chCristalPorte = cristal;
    }

    /**
     * Permet d'afficher les informations liée au joueur en une string
     * @return une String
     */
    public String toString(){
        return "Position X:" + chPosX + ", Position Y:" + chPosY + ", Identifiant:";
    }
}
