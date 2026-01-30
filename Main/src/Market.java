import java.util.ArrayList;
import java.util.Scanner;

public class Market {
public ArrayList<Trader> traders;
    public static ArrayList<Stock> stocksPossedes;
    public static ArrayList<CryptoCurrency> cryptosPossedes;


    public Market(){
        this.traders= new ArrayList<>();
        this.stocksPossedes= new ArrayList<>();
        this.cryptosPossedes = new ArrayList<>();

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
public  Asset trouverStock(String code){
        for (Asset stock : stocksPossedes){
            if (stock.getCode().equals(code)  ){
                return stock;
            }
        }
    return null;
}

    public  Asset trouverCrypto(String code){
        for (Asset crypto : cryptosPossedes){
            if (crypto.getCode().equals(code)  ){
                return crypto;
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
public void ajouterStock(Stock stock){
        stocksPossedes.add(stock);
}

    public  void modifierPrixStock(){
        afficherCatalogueStock();
        System.out.println("Entrez le code du Stock que vous voulez modifier: ");
        Scanner s = new Scanner(System.in);
        String code1 = s.next();
        Asset stock =  trouverStock(code1);
        if (stock!=null){
        System.out.println("[" + stock.getCode() + "] " + stock.getNom() + " : " + stock.getPrixUnitaire() + "$");
        System.out.println("Entrez le nouveau prix: ");
        double nvPrice = s.nextDouble();
        stock.setPrixUnitaire(nvPrice);
        System.out.println("Prix du Stock modifié avec succès");
        }else {
            System.out.println("Stock non trouvé!");
        }

    }

    public Asset supprimerStock(String code){
   Asset a = trouverStock(code);
      if (a!= null){
           stocksPossedes.remove(a);
           System.out.println("Stock supprimé avec succès");
        }else {
            System.out.println("Stock introuvable!");
      }
        return a;
    }

    public void ajouterCrypto(CryptoCurrency crypto){
        cryptosPossedes.add(crypto);
    }


    public  void modifierPrixCrypto(){
        afficherCatalogueCrypto();
        System.out.println("Entrez le code de Crypto Monnaie que vous voulez modifier: ");
        Scanner s = new Scanner(System.in);
        String code2 = s.next();
            Asset crypto = trouverCrypto(code2);
            if(crypto!=null) {
                System.out.println("[" + crypto.getCode() + "] " + crypto.getNom() + " : " + crypto.getPrixUnitaire() + "$");
                System.out.println("Entrez le nouveau prix: ");
                double nvPrice2 = s.nextDouble();
                crypto.setPrixUnitaire(nvPrice2);
                System.out.println("Prix modifié! ");
            }else {
                System.out.println("Crypto monnaie non trouvé");
            }



    }


   public Asset supprimerCrypto(String code){
       Asset a = trouverCrypto(code);
       if (a!= null){
           cryptosPossedes.remove(a);
           System.out.println("Crypto monnaie supprimé avec succès");
       }else {
           System.out.println("Crypto monnaie introuvable!");
        }
        return a;
    }

public void acheterStock(int traderId, String CodeAsset, int quantite){
        Trader trader = trouverTrader(traderId);
        Asset stock = trouverStock(CodeAsset);

        if (trader== null){
            System.out.println("Trader introuvable");
            return;
        }
        if (stock == null) {
            System.out.println("Stock introuvable");
            return;
        }

       double prixTotal = stock.getPrixUnitaire()*quantite;

        if (stock.getPrixUnitaire()>prixTotal){
            trader.setSoldeInitial(trader.getSoldeInitial()-prixTotal);

            trader.getPortfolio().ajouterActif(stock,quantite);
            System.out.println("Achat réussi");
        }else {
            System.out.println("Solde insuffisant! Solde requis: " + prixTotal);
        }
}

    public void acheterCrypto(int traderId, String CodeAsset, int quantite) {
        Trader trader = trouverTrader(traderId);
        Asset crypto = trouverStock(CodeAsset);

        if (trader == null) {
            System.out.println("Trader introuvable");
            return;
        }
        if (crypto == null) {
            System.out.println("Crypto introuvable");
            return;
        }

        double prixTotal = crypto.getPrixUnitaire() * quantite;

        if (crypto.getPrixUnitaire() > prixTotal) {
            trader.setSoldeInitial(trader.getSoldeInitial() - prixTotal);

            trader.getPortfolio().ajouterActif(crypto, quantite);
            System.out.println("Achat réussi");
        } else {
            System.out.println("Solde insuffisant! Solde requis: " + prixTotal);
        }
    }


    public  void vendreStock(int id,String code,int quantite){
        Trader trader = trouverTrader(id);
        Asset stock = trouverStock(code);
        if(trader == null){
            System.out.println("Trader non trouvé.");
            return;
        }
        if (stock == null){
            System.out.println("Stock intouvable");
            return;
        }
        boolean aEteVendu = trader.getPortfolio().retirerActif(code,quantite);
        double prixVente =  stock.getPrixUnitaire()* quantite;

        if (aEteVendu){
            trader.setSoldeInitial(trader.getSoldeInitial()+prixVente);
            System.out.println("Vente réussie ! " + prixVente + "$ ajoutés au solde.");
        }else {
            System.out.println("échec de la vente.");
        }

    }
    public  void vendreCrypto(int id,String code,int quantite){
        Trader trader = trouverTrader(id);
        Asset crypto = trouverCrypto(code);
        if(trader == null){
            System.out.println("Trader non trouvé.");
            return;
        }
        if (crypto == null){
            System.out.println("Stock intouvable");
            return;
        }
        boolean aEteVendu = trader.getPortfolio().retirerActif(code,quantite);
        double prixVente =  crypto.getPrixUnitaire()* quantite;

        if (aEteVendu){
            trader.setSoldeInitial(trader.getSoldeInitial()+prixVente);
            System.out.println("Vente réussie ! " + prixVente + "$ ajoutés au solde.");
        }else {
            System.out.println("échec de la vente.");
        }

    }

    public void initialiserMarcheStock() {
    // stock (actions)
    stocksPossedes.add(new Stock("AAPL", "Apple Inc.", 180.0, "Stock", 100));
    stocksPossedes.add(new Stock("TSLA", "Tesla", 240.0, "Stock",200));
    stocksPossedes.add(new Stock("MSFT", "Microsoft", 400.0, "Stock",300));
}
public void initialiserMarcheCrypto(){
    // Crypto Currencies
    cryptosPossedes.add(new CryptoCurrency("BTC", "Bitcoin", 87863.10, "Crypto",100));
    cryptosPossedes.add(new CryptoCurrency("ETH", "Ethereum", 2939.67, "Crypto",200));
    cryptosPossedes.add(new CryptoCurrency("SOL", "Solana", 123.0, "Crypto",300));
    }

    public static void afficherCatalogueStock() {
        System.out.println("======== Liste de tous les Actions (Stocks) disponibles ==========");
        for (Asset a : stocksPossedes) {
            if (a instanceof Stock) {
                System.out.println("[" + a.getCode() + "] " + a.getNom() + " : " + a.getPrixUnitaire() + "$");
            }
        }
    }

    public static void afficherCatalogueCrypto() {
        System.out.println("======== Liste de tous les Crypto Monnaies diponibles ==========");
        for (Asset a : cryptosPossedes) {
            if (a instanceof CryptoCurrency) {
                System.out.println("[" + a.getCode() + "] " + a.getNom() + " : " + a.getPrixUnitaire() + "$");
            }
        }
    }





}
