package modele;


import exception.ExceptionImpossible;
import exception.ExceptionManquant;
import exception.ExceptionPosition;
import interfaces.CONSTANTES_MAP;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Systeme de lecture d'un scenario
 */
public class LectureScenario implements CONSTANTES_MAP {
    private static HashSet<Temple> temples = new HashSet<>();
    private static HashSet<Cristal> cristaux = new HashSet<>();

    /**
     * Constructeur de l'objet à partir du nom du fichier que l'on veut charger
     * @param nomFichierScenario : le nom du fichier que l'on veut charger
     * @throws Exception :  le fait de charger un fichier peut produire des erreurs,
     *                      si le fichier est mal configuré
     */
    public LectureScenario(String nomFichierScenario) throws Exception{

        // On clear les temples et les cristaux quand on relit un nouveau scenario
        temples.clear();
        cristaux.clear();

        Scanner scanner; // on prépare un scanner
        // On charge le fichier
        try {
            scanner = new Scanner(new File("Scenario" + File.separator + nomFichierScenario)).useDelimiter(";");
        } catch (Exception erreur){
            throw new ExceptionImpossible(1);
        }


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


            // On vérifie si la position du temple et du cristal est correcte
            Position positionVerif = new Position(positionX, positionY);
            ExceptionPosition.VerifierPositionObjet(positionVerif, nouveauTemple);

            // On passe proprement à la ligne suivante :
            if (scanner.hasNextLine()){
                scanner.nextLine();
            }

        }

        // On vérifie si tous les temples sont finissables, sinon c'est que la configuration du fichier
        // a mal été fait et que le jeu n'est pas finissable
        for(Temple temple: temples){
            // Pour vérifier, on met une variable que l'on initie à false et qui vaut true quand
            // la couleur d'un temple est la couleur d'un cristal
            boolean verifTemple = false;

            // On récupère sa position
            int couleurTemple = temple.getCouleur();
            for(Cristal cristal: cristaux){
                if(cristal.getCouleur() == couleurTemple){
                    verifTemple = true;
                }
            }

            // Si aucun cristal n'a la même couleur qu'un temple
            // C'est qu'il y a un problème
            // Et dans ce cas, le jeu n'est pas finissable
            if(!verifTemple){
                throw new ExceptionManquant(3);
            }
        }
    }


    /**
     * getter des temples
     * @return un HashSet de tous les temples chargés du fichier
     */
    public static HashSet <Temple> getTemples() {
        return temples;
    }

    /**
     * getter des cristaux
     * @return un HashSet de tous les cristaux chargés du fichier
     */
    public static HashSet <Cristal> getCristaux() {
        return cristaux;
    }

}
