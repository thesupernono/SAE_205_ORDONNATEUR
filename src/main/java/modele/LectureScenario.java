package modele;


import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class LectureScenario implements CONSTANTES_MAP{
    HashSet<Temple> Temples = new HashSet<>();
    HashSet<Cristal> Cristaux = new HashSet<>();
    public LectureScenario(int numeroScenario) throws Exception{

        // On charge le fichier
        String nomFichier = "Scenario" + numeroScenario + ".txt";
        Scanner scanner = new Scanner(new File("Scenario" + File.separator + nomFichier)).useDelimiter(";");


        // On analyse élément par élément
        while (scanner.hasNext()){
            int positionX = scanner.nextInt();
            int positionY = scanner.nextInt();


            // On reprend le numéro des couleurs
            int numCouleurTemple = scanner.nextInt();
            int numCouleurCristal = scanner.nextInt();


            // On initie le temple
            Temple nouveauTemple = new Temple(positionX, positionY, numCouleurTemple);
            Temples.add(nouveauTemple);


            // On initie le cristal
            Cristal nouveauCristal = new Cristal(positionX, positionY, numCouleurCristal);
            Cristaux.add(nouveauCristal);


            // On passe proprement à la ligne suivante :
            if (scanner.hasNextLine()){
                scanner.nextLine();
            }

        }
        System.out.println(Cristaux);
        System.out.println(Temples);
    }


    public HashSet <Temple> listeTemple() {
        return Temples;
    }


    public HashSet <Cristal> listeCristal() {
        return Cristaux;
    }
}
