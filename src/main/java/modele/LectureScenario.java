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

            // On reprend la donnée
            int donnee;
            String donneeStr = scanner.next();


            // Si la ligne a un nombre et un \n, alors il y a un retour à la ligne
            if(donneeStr.contains("\n")){
                System.out.println("nouvelle ligne");


                // On enlève le \n et on le converti en int
                donnee = Integer.parseInt(donneeStr.replace("\n", ""));
            }else{
                donnee = Integer.parseInt(donneeStr);
            }
            System.out.println("" + donnee);
        }
    }
}
