import java.util.ArrayList;

public class Market {
public ArrayList<Trader> traders;

    public Market(){
        this.traders= new ArrayList<>();

}

public void ajouterTrader(Trader trader){
traders.add(trader);

}
public Trader trouverTrader(int id ){
        for (Trader t : traders){
            if (t.getId() == id){
                return t;
            }
        }
        return null;

}

public void afficherTrader(int id){
        Trader rechTrader= trouverTrader(id);
    System.out.println("Trader Id: "+rechTrader.getId()+ "|Nom du Trader: "+rechTrader.getName()+"|solde initial: "+rechTrader.getSoldeInitial());
}

public void supprimerTrader(int id ){
        Trader suppTrader = trouverTrader(id);
        traders.remove(suppTrader);
}




}
