//Nawad KARIHILA
public class Joyaux extends Contenu{

    //Variable d'attribut
    private final double prix;
    private static String[] minerai = {"Ruby", "Saphir", "Emeraude", "Diamand", "Perle", "Platine"}; 

    //Constrcteur
    public Joyaux(String type, int quantite){

        super(type, quantite);
        prix = Math.random() * (6000 + 1);
    }

    public Joyaux(int quantite){

        this(minerai[(int)(Math.random() * 6)], quantite);
    }


    //Méthode récurrentes
    public String toString(){

        return super.toString() + " Prix : %.2f".formatted(prix);
    }

    //Accesseurs
    public double getPrix(){

        return prix;
    }
}