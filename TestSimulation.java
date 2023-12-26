import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestSimulation{
    public static void main(String[] args) throws InputMismatchException, CoordonneesIncorrectesException, DeplacementIncorrectException, CaseNonPleineException, InterruptedException, FileNotFoundException{

        //Création de la grille
        System.out.println("CHOOSE_TWO_NUMBERS_BETWEEN_1_AND_20");
        Scanner x = new Scanner(System.in), y = new Scanner(System.in);
        Grille grille = null;
        int ligne, colonne;

        try{
            ligne = x.nextInt();
            colonne = y.nextInt();
            grille = new Grille(ligne, colonne);
        }
        
        catch(InputMismatchException e){
            System.out.println("!!!ERROR!!!\nSIMULATION_FAILURE!!!\nRESTART_WITH_INTEGER_NUMBER");
        }

        //Initialisation de la simulation
        System.out.println("HOW_MANY_ROUND_YOU_WANT");
        Scanner n = new Scanner(System.in);

        try {
            // Redirection de System.out vers un fichier
            FileOutputStream filename = new FileOutputStream("log.txt");
            PrintStream ps = new PrintStream(filename);
            System.setOut(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }

        int nbContenu = (int)((Math.random() * ((grille.nbLignes * grille.nbColonnes) - 1)+1));
        Simulation sim = new Simulation(grille, nbContenu);

        try {
            int nbSim = n.nextInt();
            sim.lance(nbSim);
        }

        catch(InputMismatchException e){
            System.out.println("!!!ERROR!!!\nSIMULATION_FAILURE!!!\nRESTART_WITH_INTEGER_NUMBER");
        }        
    }
}