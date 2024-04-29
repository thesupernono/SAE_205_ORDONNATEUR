package modele;

import java.io.File;
import java.util.Scanner;

public class LectureScenario {
    public LectureScenario(int numeroScenario) throws Exception{
        String nomFichier = "Scenario" + numeroScenario + ".txt";


        // On charge le fichier
        Scanner scanner = new Scanner(new File("Scenario" + File.separator + nomFichier)).useDelimiter(";");


        // On analyse élément par élément
        while (scanner.hasNext()){
            int donnee = scanner.nextInt();

            System.out.println("abc");
            System.out.println("" + donnee);
        }
    }
}
