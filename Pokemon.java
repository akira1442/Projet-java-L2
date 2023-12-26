public class Pokemon extends Joyaux{

    //Variable d'attribut
    private final int rare;
    private static String[] pokedex = {"Brindibou", "Evoli", "Fantominus", "Raikou", "Carapuce"};

    //Constructeur
    public Pokemon(String type, int quantite, int rare){

        super(type, quantite);
        this.rare = rare;
    }

    public Pokemon(){
        
        this(pokedex[(int)(Math.random() * pokedex.length)], 1, (int)(Math.random() * 50));
    }

    //Méthode concrète
    public void affichePokedex(){
        
        for (String pokemon : pokedex){
            System.out.println(pokemon);
        }
    }

    //Accesseur
    public int getRare(){

        return rare;
    }

    public static String getPokedex(int indice){

        return pokedex[indice];
    }

    //Méthode récurrente
    public String toString(){

        return super.toString() + "rareté: " + rare;
    }
}