package modele;

public class ClientJeu {
    public static void main(String [] args) throws Exception {
        // premier essai d'ajout d'un temple
        int couleurTemple = 1;

        Temple premierTemplate = new Temple(0, 0, couleurTemple);


        LectureScenario lecture = new LectureScenario(1);

        Joueur sorcier = new Joueur(0,0);

        for(int i=0; i < 10; i++) {
            System.out.println(sorcier.toString());
            sorcier.deplacement(i,i);
        }
        System.out.println(sorcier.getPosition().toString());
    }
}
