package exception;

public class ExceptionProcedure {
    public static void procedureErreur(ExceptionPosition erreur){
        System.out.println(erreur.getMessageErreur());
        System.exit(erreur.getNumErreur());
    }
}
