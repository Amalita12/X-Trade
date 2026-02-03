import java.util.Scanner;

public  class Main{
    public static void main(String[] args) {
Market market = new Market();
market.initialiserMarcheCrypto();
market.initialiserMarcheStock();
        Scanner s = new Scanner(System.in);
        int choice;
        do {
                System.out.println("=======Menu Principal============");
                System.out.println("1.Menu Admin");
                System.out.println("2.Menu Trader");
                System.out.println("0.Quitter");
                System.out.println("Entre votre choix: ");
                choice = s.nextInt();

                switch (choice) {
                    case 1:
                        int choix1;
                        do {
                            System.out.println("======Menu de l'Admin========");
                            System.out.println("1.Ajouter Trader");
                            System.out.println("2.Supprimer Trader");
                            System.out.println("3.Ajouter Stock");
                            System.out.println("4.Modifier Stock");
                            System.out.println("5.Supprimer Stock");
                            System.out.println("6.Ajouter Crypto Currency");
                            System.out.println("7.Modifier Crypto Currency");
                            System.out.println("8.Supprimer Crypto Currency");
                            System.out.println("0.Quitter");
                            System.out.println("Entrez votre choix: ");
                            choix1 = s.nextInt();
                            switch (choix1) {
                                case 1:
                                    System.out.println("Entrez l'ID du Trader: ");
                                    int id = s.nextInt();
                                    System.out.println("Entrez le nom du Trader: ");
                                    String name = s.next();
                                    System.out.println("Entrez son solde initial:");
                                    double solde = s.nextDouble();
                                    Trader nvTrader = new Trader(id, name,solde);
                                    market.ajouterTrader(nvTrader);
                                    System.out.println("Trader ajouté avec succès");
                                    break;
                                case 2:
                                    System.out.println("Entrez l'ID du Trader que vous voulez supprimer: ");
                                    int suppId = s.nextInt();
                                    market.supprimerTrader(suppId);
                                    System.out.println("Trader supprimé avec succès");
                                    break;
                                case 3:
                                    System.out.println("Entrez le code du Stock: ");
                                    String stockCode = s.next();
                                    System.out.println("Entrez le nom du Stock: ");
                                    String stockNom = s.next();
                                    System.out.println("Entrez le prix unitaire du Stock: ");
                                    double stockPrixUni = s.nextDouble();
                                    System.out.println("Entrez le type de cet Actif (Stock / Crypto monnaie): ");
                                    String stockType = s.next();
                                    System.out.println("Entrez la Quantité: ");
                                    int quantite = s.nextInt();
                                    Stock nvStock = new Stock(stockCode, stockNom, stockPrixUni, stockType, quantite);
                                    market.ajouterStock(nvStock);
                                    System.out.println("Stock ajouté");

                                    break;
                                case 4:
                                    market.modifierPrixStock();
                                    break;
                                case 5:
                                    market.afficherCatalogueStock();
                                    System.out.println("Entrez le code du Stock que vous voulez supprimer: ");
                                    String code1  = s.next();
                                   market.supprimerStock(code1);
                                    market.afficherCatalogueStock();
                                    break;
                                case 6:
                                    System.out.println("Entrez le code du Crypto Monnaie: ");
                                    String cryptoCode = s.next();
                                    System.out.println("Entrez le nom du Crypto Monnaie: ");
                                    String cryptoNom = s.next();
                                    System.out.println("Entrez le prix unitaire du Crypto Monnaie: ");
                                    double cryptoPrixUni = s.nextDouble();
                                    System.out.println("Entrez le type de cet Actif (Stock / Crypto monnaie): ");
                                    String cryptoType = s.next();
                                    System.out.println("Entrez la Quantité: ");
                                    int quantite2 = s.nextInt();
                                    CryptoCurrency nvCrypto= new CryptoCurrency(cryptoCode, cryptoNom, cryptoPrixUni, cryptoType, quantite2);
                                    market.ajouterCrypto(nvCrypto);
                                    System.out.println("Crypto Monnaie ajoutée");
                                    break;
                                case 7:
                                    market.modifierPrixCrypto();
                                    break;
                                case 8:
                                    market.afficherCatalogueCrypto();
                                    System.out.println("Entrez le code du Crypto Monnaie que vous voulez supprimer: ");
                                    String code2  = s.next();
                                   market.supprimerCrypto(code2);
                                   market.afficherCatalogueCrypto();
                                    break;
                                case 0:
                                    System.out.println("Merci d'avoir utilisé X-Trade. Au revoir!");
                                    break;
                                default:
                                    System.out.println("choix invalide. Veuillez réessayer");
                                    break;
                            }

                        } while (choix1 != 0);
                        break;


                    case 2:
                        int choix2;
                        do {
                            System.out.println("======Menu du Trader=======");
                            System.out.println("1.Afficher Catalogue du Stock");
                            System.out.println("2.Afficher Catalogue du Crypto Monnaie");
                            System.out.println("3.Acheter Stock");
                            System.out.println("4.Vendre Stock");
                            System.out.println("5.Acheter Crypto Currency");
                            System.out.println("6.Vendre Crypto Currency");
                            System.out.println("7.Consulter Portfolio");
                            System.out.println("0.Quitter");
                            System.out.println("Entrez votre choix");
                            choix2 = s.nextInt();

                            switch (choix2) {
                                case 1:
                                    market.afficherCatalogueStock();

                                    break;
                                case 2:
                                    market.afficherCatalogueCrypto();
                                    break;
                                case 3:
                                    System.out.println("Entrez votre ID: ");
                                    int id = s.nextInt();
                                    System.out.println("Entrez le code du stock à acheter: ");
                                    String code = s.next();
                                    System.out.println("Quelle quantité voulez-vous ?: ");
                                    int quantite = s.nextInt();
                                    market.acheterStock(id,code,quantite);

                                    break;
                                case 4:
                                    System.out.println("Entrez votre ID Trader : ");
                                    int idVente = s.nextInt();
                                    market.afficherPortfolioTrader(idVente);

                                    System.out.println("Code du Stock à vendre : ");
                                    String codeVente = s.next();
                                    System.out.println("Quantité : ");
                                    int qVente= s.nextInt();

                                    market.vendreStock(idVente, codeVente, qVente);

                                    break;
                                case 5:
                                    System.out.println("Entrez votre ID: ");
                                    int id2 = s.nextInt();
                                    System.out.println("Entrez le code du Crypto à acheter: ");
                                    String code2 = s.next();
                                    System.out.println("Quelle quantité voulez-vous ?: ");
                                    int quantite2 = s.nextInt();
                                    market.acheterCrypto(id2,code2,quantite2);

                                    break;
                                case 6:
                                    System.out.println("Entrez votre ID Trader : ");
                                    int idVenteC = s.nextInt();
                                    market.afficherPortfolioTrader(idVenteC);
                                    System.out.println("Code Crypto à vendre : ");
                                    String codeVenteC = s.next();
                                    System.out.println("Quantité : ");
                                    int qteVenteC = s.nextInt();
                                    market.vendreCrypto(idVenteC, codeVenteC, qteVenteC);
                                    break;
                                case 7:
                                    System.out.println("Entrez votre ID Trader : ");
                                    int idConsultation = s.nextInt();
                                    market.afficherPortfolioTrader(idConsultation);
                                    break;
                                case 0:
                                    System.out.println("Merci d'avoir utilisé X-Trade. Au revoir!");
                                    break;
                                default:
                                    System.out.println("choix invalide. Veuillez réessayer");
                                    break;
                            }
                        } while (choix2 != 0);
                        break;
                    case 0:
                        System.out.println("Merci d'avoir  utilisé X-Trade. Au revoir!");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer");
                }


            } while (choice != 0) ;




    }

}
