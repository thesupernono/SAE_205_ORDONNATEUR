package modele;

public class ClientJeu {
    public static void main(String [] args) throws Exception {
        // premier essai d'ajout d'un temple
        int couleurTemple = 1;

        Temple premierTemplate = new Temple(0, 0, couleurTemple);


        LectureScenario lecture = new LectureScenario("Scenario1.txt");

        Joueur sorcier = new Joueur(0,0);


    }
}
