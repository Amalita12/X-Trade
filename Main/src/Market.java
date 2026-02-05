import java.time.LocalDate;
import java.util.*;

public class Market {
    public ArrayList<Trader> traders;
    public static ArrayList<Stock> stocksPossedes;
    public static ArrayList<CryptoCurrency> cryptosPossedes;
    public static ArrayList<Transaction> transactions;


    public Market() {
        this.traders = new ArrayList<>();
        this.stocksPossedes = new ArrayList<>();
        this.cryptosPossedes = new ArrayList<>();
        this.transactions = new ArrayList<>();

    }

    public void ajouterTrader(Trader trader) {
        for (Trader t : traders){
            if(t.getId()==trader.getId()){
                System.out.println("Trader existant! ");
                return;
            }
        }
            traders.add(trader);
            System.out.println("Trader ajouté avec succès");
        }


    public Trader trouverTrader(int id) {
        for (Trader t : traders) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;

    }

    public Asset trouverStock(String code) {
        for (Asset stock : stocksPossedes) {
            if (stock.getCode().equals(code)) {
                return stock;
            }
        }
        return null;
    }

    public Asset trouverCrypto(String code) {
        for (Asset crypto : cryptosPossedes) {
            if (crypto.getCode().equals(code)) {
                return crypto;
            }
        }
        return null;
    }

    public void afficherTrader(int id) {
        Trader rechTrader = trouverTrader(id);
        System.out.println("Trader Id: " + rechTrader.getId() + "|Nom du Trader: " + rechTrader.getName() + "|solde initial: " + rechTrader.getSoldeInitial());
    }

    public void supprimerTrader(int id) {
        Trader suppTrader = trouverTrader(id);
        traders.remove(suppTrader);
    }

    public void ajouterStock(Stock stock) {
        stocksPossedes.add(stock);
        afficherCatalogueStock();
    }

    public void modifierPrixStock() {
        afficherCatalogueStock();
        System.out.println("Entrez le code du Stock que vous voulez modifier: ");
        Scanner s = new Scanner(System.in);
        String code1 = s.next();
        Asset stock = trouverStock(code1);
        if (stock != null) {
            System.out.println("[" + stock.getCode() + "] " + stock.getNom() + " : " + stock.getPrixUnitaire() + "$");
            System.out.println("Entrez le nouveau prix: ");
            double nvPrice = s.nextDouble();
            stock.setPrixUnitaire(nvPrice);
            System.out.println("Prix du Stock modifié avec succès");
            System.out.println("Entrez la quantité: ");
            int q = s.nextInt();
            stock.setQuantite(q);
            System.out.println("Quantité modifiée");
            afficherCatalogueStock();
        } else {
            System.out.println("Stock non trouvé!");
        }

    }

    public Asset supprimerStock(String code) {
        Asset a = trouverStock(code);
        if (a != null) {
            stocksPossedes.remove(a);
            System.out.println("Stock supprimé avec succès");
        } else {
            System.out.println("Stock introuvable!");
        }
        return a;
    }

    public void ajouterCrypto(CryptoCurrency crypto) {
        cryptosPossedes.add(crypto);
        afficherCatalogueCrypto();
    }


    public void modifierPrixCrypto() {
        afficherCatalogueCrypto();
        System.out.println("Entrez le code de Crypto Monnaie que vous voulez modifier: ");
        Scanner s = new Scanner(System.in);
        String code2 = s.next();
        Asset crypto = trouverCrypto(code2);
        if (crypto != null) {
            System.out.println("[" + crypto.getCode() + "] " + crypto.getNom() + " : " + crypto.getPrixUnitaire() + "$");
            System.out.println("Entrez le nouveau prix: ");
            double nvPrice2 = s.nextDouble();
            crypto.setPrixUnitaire(nvPrice2);
            System.out.println("Prix modifié! ");
            System.out.println("Entrez la quantité: ");
            int q = s.nextInt();
            crypto.setQuantite(q);
            System.out.println("Quantité modifiée");
            afficherCatalogueCrypto();
        } else {
            System.out.println("Crypto monnaie non trouvé");
        }


    }


    public Asset supprimerCrypto(String code) {
        Asset a = trouverCrypto(code);
        if (a != null) {
            cryptosPossedes.remove(a);
            System.out.println("Crypto monnaie supprimé avec succès");
        } else {
            System.out.println("Crypto monnaie introuvable!");
        }
        return a;
    }

    public void acheterStock(int traderId, String CodeAsset, int quantite) {
        Trader trader = trouverTrader(traderId);
        Asset stock = trouverStock(CodeAsset);

        if (trader == null) {
            System.out.println("Trader introuvable");
            return;
        }
        if (stock == null) {
            System.out.println("Stock introuvable");
            return;
        }

        double prixTotal = stock.getPrixUnitaire() * quantite;

        if (trader.getSoldeInitial() >= prixTotal) {
            trader.setSoldeInitial(trader.getSoldeInitial() - prixTotal);

            trader.getPortfolio().ajouterActif(stock, quantite);
            transactions.add(new Transaction("ACHAT", quantite, stock.getPrixUnitaire(), LocalDate.now(), trader, stock));
            System.out.println("Achat réussi");
        } else {
            System.out.println("Solde insuffisant! Solde requis: " + prixTotal);
        }
    }

    public void acheterCrypto(int traderId, String CodeAsset, int quantite) {
        Trader trader = trouverTrader(traderId);
        Asset crypto = trouverCrypto(CodeAsset);

        if (trader == null) {
            System.out.println("Trader introuvable");
            return;
        }
        if (crypto == null) {
            System.out.println("Crypto introuvable");
            return;
        }

        double prixTotal = crypto.getPrixUnitaire() * quantite;

        if (trader.getSoldeInitial() >= prixTotal) {
            trader.setSoldeInitial(trader.getSoldeInitial() - prixTotal);
            trader.getPortfolio().ajouterActif(crypto, quantite);
            transactions.add(new Transaction("ACHAT", quantite, crypto.getPrixUnitaire(), LocalDate.now(), trader, crypto));
            System.out.println("Achat réussi");
        } else {
            System.out.println("Solde insuffisant! Solde requis: " + prixTotal);
        }
    }


    public void vendreStock(int id, String code, int quantite) {
        Trader trader = trouverTrader(id);
        Asset stock = trouverStock(code);
        if (trader == null) {
            System.out.println("Trader non trouvé.");
            return;
        }
        if (stock == null) {
            System.out.println("Stock intouvable");
            return;
        }
        double prixVente = stock.getPrixUnitaire() * quantite;

        if (trader.getPortfolio().retirerActif(code, quantite)) {
            trader.setSoldeInitial(trader.getSoldeInitial() + prixVente);
            transactions.add(new Transaction("VENTE", quantite, stock.getPrixUnitaire(), LocalDate.now(), trader, stock));

            System.out.println("Vente réussie ! " + prixVente + "$ ajoutés au solde.");
        } else {
            System.out.println("échec de la vente.");
        }

    }

    public void vendreCrypto(int id, String code, int quantite) {
        Trader trader = trouverTrader(id);
        Asset crypto = trouverCrypto(code);
        if (trader == null) {
            System.out.println("Trader non trouvé.");
            return;
        }
        if (crypto == null) {
            System.out.println("Stock intouvable");
            return;
        }

        double prixVente = crypto.getPrixUnitaire() * quantite;

        if (trader.getPortfolio().retirerActif(code, quantite)) {

            trader.setSoldeInitial(trader.getSoldeInitial() + prixVente);
            transactions.add(new Transaction("VENTE", quantite, crypto.getPrixUnitaire(), LocalDate.now(), trader, crypto));
            System.out.println("Vente réussie ! " + prixVente + "$ ajoutés au solde.");
        } else {
            System.out.println("échec de la vente.");
        }

    }

    public void initialiserMarcheStock() {
        // stock (actions)
        stocksPossedes.add(new Stock("AAPL", "Apple Inc.", 180.0, "Stock", 100));
        stocksPossedes.add(new Stock("TSLA", "Tesla", 240.0, "Stock", 200));
        stocksPossedes.add(new Stock("MSFT", "Microsoft", 400.0, "Stock", 300));
    }

    public void initialiserMarcheCrypto() {
        // Crypto Currencies
        cryptosPossedes.add(new CryptoCurrency("BTC", "Bitcoin", 87863.10, "Crypto", 100));
        cryptosPossedes.add(new CryptoCurrency("ETH", "Ethereum", 2939.67, "Crypto", 200));
        cryptosPossedes.add(new CryptoCurrency("SOL", "Solana", 123.0, "Crypto", 300));
    }

    public static void afficherCatalogueStock() {
        System.out.println("======== Liste de tous les Actions (Stocks) disponibles ==========");
        for (Asset a : stocksPossedes) {
            if (a instanceof Stock) {
                System.out.println("[" + a.getCode() + "] " + a.getNom() + " : " + a.getPrixUnitaire() + "$" + "| Quantité: " + a.getQuantite());
            }
        }
    }

    public static void afficherCatalogueCrypto() {
        System.out.println("======== Liste de tous les Crypto Monnaies diponibles ==========");
        for (Asset a : cryptosPossedes) {
            if (a instanceof CryptoCurrency) {
                System.out.println("[" + a.getCode() + "] " + a.getNom() + " : " + a.getPrixUnitaire() + "$" + "| Quantité: " + a.getQuantite());
            }
        }
    }

    public void afficherPortfolioTrader(int traderId) {
        Trader trader = trouverTrader(traderId);

        if (trader == null) {
            System.out.println("Erreur : Trader avec l'ID " + traderId + " introuvable.");
            return;
        }

        System.out.println("\n======= PORTFOLIO DE " + trader.getName().toUpperCase() + " =======");
        System.out.println("Solde disponible : " + trader.getSoldeInitial() + " $");

        Portfolio portfolio = trader.getPortfolio();
        List<Portfolio.ElementPortefeuille> lignes = portfolio.getLignes();

        if (lignes.isEmpty()) {
            System.out.println("Votre portefeuille est actuellement vide.");
        } else {
            System.out.println("Actifs possédés :");
            for (Portfolio.ElementPortefeuille ligne : lignes) {
                Asset actif = (Asset) ligne.getActif();
                int qte = ligne.getQuantite();

                System.out.println("- [" + actif.getCode() + "] " + actif.getNom() +
                        " | Qté: " + qte +
                        " | Valeur Actuelle: " + actif.getPrixUnitaire() + "$ " +
                        " | Sous-total: " + (qte * actif.getPrixUnitaire()) + "$");
            }
            System.out.println("----------------------------------------------");
            System.out.println("VALEUR TOTALE DES ACTIFS : " + portfolio.calculerValeurTotale() + " $");
        }
        System.out.println("==============================================\n");
    }


    public void historiqueTransactions() {
        System.out.println("\n======= HISTORIQUE DES TRANSACTIONS =======");

        for (Trader t : traders) {
            for (Transaction trans : t.getTransactions()) {
                System.out.println("Trader: " + t.getName() + " | " + trans.toString());
            }
        }
        System.out.println("============================================");
    }

    // Partie 2:

    public void historiqueTransactionsPerTrader(int id) {
        Trader trader = trouverTrader(id);
        if (trader != null) {
            System.out.println("--- Historique pour " + trader.getName() + " ---");
            for (Transaction trans : transactions) {
                System.out.println("Name: " + trader.getName() + "|Date: " + trans.toString());
            }
        } else {
            System.out.println("Erreur : Aucun trader trouvé avec l'ID " + id);
        }
    }


    public void FiltrerTransactionnsParType(String type) {
        List<Transaction> filtrage = transactions.stream()
                .filter(t -> t.getTypeTransaction().equalsIgnoreCase(type))
                .toList();
        filtrage.forEach(System.out::println);
    }

    public void FiltrageTransactionsParActif(String code) {
        List<Transaction> filtrage = transactions.stream()
                .filter(t -> t.getActif().getCode().equalsIgnoreCase(code))
                .toList();
        filtrage.forEach(System.out::println);
    }

    public void FiltrageTransactionsParDate(LocalDate startDate, LocalDate endDate) {
        List<Transaction> dates = transactions.stream()
                .filter(d -> !d.getDate().isAfter(endDate) && !d.getDate().isBefore(startDate))
                .toList();
        if (dates.isEmpty()) {
            System.out.println("Aucune transaction effectuée durant cette période");
        } else {
            dates.forEach(System.out::println);
        }
    }
    public void triParDate() {
        System.out.println("======= HISTORIQUE DES DATES : DU PLUS RÉCENT AU PLUS ANCIEN =======");

        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed())
                .forEach(t -> {
                    System.out.println("Date: " + t.getDate() +
                            "| Actif: "+t.getActif().getNom()+
                            " | Type: " + t.getTypeTransaction() +
                            " | Montant: " + (t.getQuantite() * t.getPrixUnitaire()) + "$");
                });
    }
    public void triParMontant() {
        System.out.println("======= HISTORIQUE PAR MONATANT: DU PLUS RÉCENT AU PLUS ANCIEN =======");

        transactions.stream()
                .sorted(Comparator.comparingDouble((Transaction t) -> t.getQuantite()* t.getPrixUnitaire()).reversed())
                .forEach(t -> {
                    System.out.println(
                            " Type: " + t.getTypeTransaction() +
                            " | Montant: " + (t.getQuantite() * t.getPrixUnitaire()) + "$"+ 
                                    " | Actif : " + t.getActif().getNom() + " | Date : " + t.getDate());
                });
    }

    public void VolumeTotalActif(String code){
        System.out.println("========Le Volume Total échangé par "+code.toUpperCase()+"==========");
        
       double total=  transactions.stream()
                .filter(t -> t.getActif().getCode().equalsIgnoreCase(code))
                .mapToDouble(t-> t.getPrixUnitaire() * t.getQuantite())
                .sum();
        System.out.println("Volume total pour "+code+" : "+total+" $");


    }

    public void VolumeTotalAchatVente(){
        System.out.println("========= Le Volume Total des ACHATS et VENTES ==========");

        double totalAchat = transactions.stream()
                .filter(t-> t.getTypeTransaction().equals("ACHAT"))
                .mapToDouble(t->t.getPrixUnitaire()*t.getQuantite())
                .sum();
        double totalVente = transactions.stream()
                .filter(t->t.getTypeTransaction().equalsIgnoreCase("VENTE"))
                .mapToDouble(t->t.getPrixUnitaire()*t.getQuantite())
                .sum();

        System.out.println("======= ANALYSE GLOBALE DU MARCHÉ =======");
        System.out.println("Montant total des ACHATS : " + totalAchat + " $");
        System.out.println("Montant total des VENTES : " + totalVente + " $");
        System.out.println("-----------------------------------------");
        System.out.println("Volume TOTAL du marché   : " + (totalAchat + totalVente) + " $");
    }
    }













}





