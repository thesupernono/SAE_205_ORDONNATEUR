package modele;


import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class LectureScenario implements CONSTANTES_MAP{
    HashSet<Temple> temples = new HashSet<>();
    HashSet<Cristal> cristaux = new HashSet<>();


    public LectureScenario(String nomFichierScenario) throws Exception{

        // On charge le fichier
        Scanner scanner = new Scanner(new File("Scenario" + File.separator + nomFichierScenario)).useDelimiter(";");


        // On analyse élément par élément
        while (scanner.hasNext()){
            int positionX = scanner.nextInt();
            int positionY = scanner.nextInt();


            // On reprend le numéro des couleurs
            int numCouleurTemple = scanner.nextInt();
            int numCouleurCristal = scanner.nextInt();


            // On initie le temple
            Temple nouveauTemple = new Temple(positionX, positionY, numCouleurTemple);
            temples.add(nouveauTemple);


            // On initie le cristal
            Cristal nouveauCristal = new Cristal(positionX, positionY, numCouleurCristal);
            cristaux.add(nouveauCristal);


            // On passe proprement à la ligne suivante :
            if (scanner.hasNextLine()){
                scanner.nextLine();
            }

        }
        System.out.println(cristaux);
        System.out.println(temples);
    }


    public HashSet <Temple> getTemple() {
        return temples;
    }


    public HashSet <Cristal> getCristal() {
        return cristaux;
    }
}
