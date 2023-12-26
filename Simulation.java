import java.util.ArrayList;
public class Simulation{
    
    //Variable d'attribut
    private Agent6 agent;
    private Grille grille;
    private ArrayList<Contenu> list;
    
    //Constructeur
    public Simulation(Grille grille, int m) throws CoordonneesIncorrectesException{

        list = new ArrayList<Contenu>();

        while (m > 0){
            int x, y;

            x = (int)(Math.random() * (grille.nbLignes));
            y = (int)(Math.random() * (grille.nbColonnes));

            if (grille.caseEstVide(x,y)){
                int r = (int)(Math.random()*101);
                if (r <= 30){
                    grille.setCase(x, y, new Gardiens("Gardien", 1));
                }else{
                    grille.setCase(x, y, new Joyaux((int)(Math.random() * 6)+1));
                }
                m--;
                list.add(grille.getCase(x, y));
            }
        }
        int xa = (int)(Math.random() * grille.nbLignes);
        int ya = (int)(Math.random() * grille.nbColonnes);

        this.grille = grille;
        this.agent = new Agent6(xa, ya, this.grille);
    }

    //Méthode concrète

    public void lance(int nbEtapes) throws CoordonneesIncorrectesException, DeplacementIncorrectException, CaseNonPleineException, InterruptedException{

        int r = 0, tour = 1;

        while (tour <= nbEtapes){

            int x = agent.getX(), y = agent.getY();
            int f = 0;

            do{
                x += (int)(Math.random() * 3) - 1;
                y += (int)(Math.random() * 3) - 1;
            }while (!grille.sontValides(x, y));
            
            r = (int)(Math.random() * 99 + 1);
            f = (int)(Math.random() * (100 - 10));

            if (r <= 30){
                agent.seDeplacer(x, y, f);
            }
            else{
                agent.seDeplacer(x, y);
            }
            
            System.out.println("\t\t\t\tROUND_"+tour+"\n");
            grille.affiche(10);
            System.out.println(toString());
            tour++;
            System.out.println("===================================================================================");
        }
        System.out.println("\t\t\tEND_OF_SIMULATION\nLOG_OUT...");
    }


    //Méthode récurrente
    public String toString(){

        String s = grille.toString() + "\n\n";
        ArrayList<Contenu> listC = grille.lesContenus();
        for (Contenu c : listC){
            s += c.toString() + "\n";
        }

        return s + "\n" + agent.toString();
    }
}