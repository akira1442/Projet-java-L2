//Nawad KARIHILA
import java.util.ArrayList;
public class Agent6{

    //Variables d'attributs
    private int x;
    private int y;
    private ArrayList<Joyaux> sac;
    private Grille grille;

    //Constructeur
    public Agent6(int x, int y, Grille grille){

        this.x = x;
        this.y = y;
        sac = new ArrayList<Joyaux>();
        this.grille = grille;
    }

    //Méthode concrète
    public String contenueSac(){

        if (sac.size() == 0){
            return "Le sac est vide.";
        }

        String s = "";
        int i = 1;

        for (Joyaux j : sac){
            s += i + ". " + j.toString() + "\n";
            i++;
        }

        return s;
    }

    public void seDeplacer(int xnew, int ynew) throws DeplacementIncorrectException, CoordonneesIncorrectesException, CaseNonPleineException{

        if (!grille.sontValides(xnew, ynew)){

            throw new DeplacementIncorrectException("Déplacement impossible.");
        }
        else{
            this.x = xnew;
            this.y = ynew;
            if (grille.getCase(x, y) instanceof Joyaux){
                sac.add((Joyaux)grille.getCase(x, y));
                grille.videCase(x, y);
            }else if (grille.getCase(x,y) instanceof Gardiens){
                sac.clear();
            }
        }
    }

    public void seDeplacer(int xnew, int ynew, int f) throws DeplacementIncorrectException, CaseNonPleineException, CoordonneesIncorrectesException{

        if (!grille.sontValides(xnew, ynew)){

            throw new DeplacementIncorrectException("Déplacement impossible: "+xnew+","+ynew);
        }
        else{
            this.x = xnew;
            this.y = ynew;
            Contenu ctn = grille.getCase(x, y);

            if (ctn instanceof Joyaux){
                sac.add((Joyaux)ctn);
                grille.videCase(x, y);
            }else if (ctn instanceof Gardiens){
                Gardiens g = (Gardiens)ctn;
                if (f < g.getPV()){
                    sac.clear();
                    g.perdrePV(f);    
                }
                else{
                    grille.videCase(x, y);
                }
            }
        }
    }

    public double fortune(){

        double fortune = 0.0;

        for (Joyaux j : sac){
            fortune += j.getPrix() * j.getQuantite();
        }

        return fortune;
    } 

    public String contenuSac(){

        String s = "";

        for (Joyaux j : sac){

            s += j.toString() + "\n";
        }

        return s;
    }
    //Méthode récurrentes
    public String toString(){

        return "Agent placé aux coordonnées: (" + x + " ; " + y + "), contenue sac:\n" + contenueSac() + ", fortune: %.2f".formatted(fortune());
    }

    //Accesseur
    public int getX(){

        return x;
    }

    public int getY(){

        return y;
    }
}