package modele;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private int chPosX;
    private int chPosY;
    private int chId;


    /**
     * Créer un joueur avec sa position sur la carte et son identifiant (numéro de joueur)
     * @param PosX position x du joueur
     * @param PosY position y du joueur
     * @param id identifiant
     */
    public Joueur(int PosX, int PosY, int id){
        chPosX = PosX;
        chPosY = PosY;
        chId = id;
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

    /**
     * Permet d'afficher les informations liée au joueur en une string
     * @return une String
     */
    public String toString(){
        return "Position X:" + chPosX + ", Position Y:" + chPosY + ", Identifiant:" + chId;
    }
}
