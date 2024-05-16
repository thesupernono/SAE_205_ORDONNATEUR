package modele;

public class ClientJeu {
    public static void main(String [] args) throws Exception {

        Map map = new Map("Scenario1.txt");

        System.out.println(map.getCoordonneesCristaux());
        System.out.println(map.getCoordonneesTemples());

    }
}
