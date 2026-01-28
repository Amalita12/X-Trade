import java.util.ArrayList;

public class Market {
public ArrayList<Trader> traders;
public ArrayList<Asset> actifsPossedes;
    public Market(){
        this.traders= new ArrayList<>();
        this.actifsPossedes = new ArrayList<>();

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
public Asset trouverActif(String code){
        for (Asset actif : actifsPossedes){
            if (actif.getCode().equals(code)  ){
                return actif;
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
public void ajouterStock(Asset stock){
        actifsPossedes.add(stock);
}
    public Asset supprimerStock(String code){
        Asset a = trouverActif(code);
        if (a!= null){
            actifsPossedes.remove(a);
            System.out.println("Stock supprimé avec succès");
        }else {
            System.out.println("Stock introuvable!");
        }
        return a;
    }

    public void ajouterCrypto(Asset crypto){
        actifsPossedes.add(crypto);
    }
    public void modifierCrypto(String code){
        Asset a = trouverActif(code);
    }
    public Asset supprimerCrypto(String code){
        Asset a = trouverActif(code);
        if (a!= null){
            actifsPossedes.remove(a);
            System.out.println("Crypto monnaie supprimé avec succès");
        }else {
            System.out.println("Crypto monnaie introuvable!");
        }
        return a;
    }

public void acheterActif(int traderId, String CodeAsset){
        Trader trader = trouverTrader(traderId);
        Asset actif = trouverActif(CodeAsset);
//
     //
     //
     //
     //
}
public void initialiserMarcheStock() {
    // stock (actions)
    actifsPossedes.add(new Stock("AAPL", "Apple Inc.", 180.0, "Stock"));
    actifsPossedes.add(new Stock("TSLA", "Tesla", 240.0, "Stock"));
    actifsPossedes.add(new Stock("MSFT", "Microsoft", 400.0, "Stock"));
}
public void initialiserMarcheCrypto(){
    // Crypto Currencies
    actifsPossedes.add(new CryptoCurrency("BTC", "Bitcoin", 42000.0, "Crypto"));
    actifsPossedes.add(new CryptoCurrency("ETH", "Ethereum", 2200.0, "Crypto"));
    actifsPossedes.add(new CryptoCurrency("SOL", "Solana", 95.0, "Crypto"));
    }

    public  void afficherCatalogueStock() {
        System.out.println("======== Liste de tous les Actions (Stocks) disponibles ==========");
        for (Asset a : actifsPossedes) {
            if (a instanceof Stock) {
                System.out.println("[" + a.getCode() + "] " + a.getNom() + " : " + a.getPrixUnitaire() + "$");
            }
        }
    }

    public  void afficherCatalogueCrypto() {
        System.out.println("======== Liste de tous les Crypto Monnaies diponibles ==========");
        for (Asset a : actifsPossedes) {
            if (a instanceof CryptoCurrency) {
                System.out.println("[" + a.getCode() + "] " + a.getNom() + " : " + a.getPrixUnitaire() + "$");
            }
        }
    }



}
