//Nawad KARIHILA
public class Gardiens extends Contenu{

    //Variable d'attribut
    private int pv;

    //Constructeur
    public Gardiens(String type, int quantite){

        super(type, quantite);
        pv = 200;
    }

    //Méthode concrète
    public void perdrePV(int degat){

        pv -= degat;
    }

    //Méthode récurente
    public String toString(){

        return super.toString() + ", pv : " + pv;
    }

    //Accesseurs
    public int getPV(){

        return pv;
    }
}