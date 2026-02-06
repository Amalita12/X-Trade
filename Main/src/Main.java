import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public  class Main{
    public static void main(String[] args) {
Market market = new Market();
market.initialiserMarcheCrypto();
market.initialiserMarcheStock();
        Scanner s = new Scanner(System.in);
        int choice;
        do {
            try {


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
                            System.out.println("9.Afficher Historique des Transactions");
                            System.out.println("10.Afficher Historique des Transactions per Trader");
                            System.out.println("11.Filtrer les Transactions");
                            System.out.println("12.Trier les Transactions");
                            System.out.println("13.Volume Total échangé par Actif");
                            System.out.println("14.Volume Total des ACHATS & VENTES");
                            System.out.println("15.Analyse de performance par trader");
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
                                case 9:
                                    market.historiqueTransactions();
                                    break;
                                case 10:
                                    System.out.println("Entrez l'ID du Trader: ");
                                    int id1= s.nextInt();
                                    market.historiqueTransactionsPerTrader(id1);
                                    break;
                                case 11:
                                    int choix;
                                    do {
                                        System.out.println("==========Filtrer Par Transaction==========");
                                        System.out.println("1.Filtrer par type (ACHAT/VENTE)");
                                        System.out.println("2.Filtrer par Actif financier");
                                        System.out.println("3.Filter par Date");
                                        System.out.println("0.Quitter");
                                        System.out.println("Entrez votre choix: ");
                                        choix = s.nextInt();
                                        switch (choix){
                                            case 1:
                                                System.out.println("Entrez le type de la Transaction (ACHAT/VENTE): ");
                                                String type = s.next();
                                                market.FiltrerTransactionnsParType(type);
                                                break;
                                            case 2:
                                                System.out.println("Entrez le code de l'Actif: ");
                                                String code = s.next();
                                                market.FiltrageTransactionsParActif(code);
                                                break;
                                            case 3:
                                                System.out.println("Entrez la date de début (yyyy-MM-dd) :");
                                                String startDate = s.next();
                                                LocalDate date1 = LocalDate.parse(startDate);
                                                System.out.println("Entrez la date de fin (yyyy-MM-dd) :");
                                                String endtDate = s.next();
                                                LocalDate date2 = LocalDate.parse(endtDate);
                                                market.FiltrageTransactionsParDate(date1,date2);
                                                System.out.println();
                                                break;
                                            case 0:
                                                System.out.println("Retour.......");
                                                break;
                                            default:
                                                System.out.println("Choix invalide! Veuillez réessayer.");
                                                break;

                                        }
                                    }while(choix!=0);
                                    break;
                                case 12:
                                    int choix4;
                                    do {
                                        System.out.println("=========Le Tri de toutes Les Transactions=========");
                                        System.out.println("1. Trier par Date toutes les Transactions");
                                        System.out.println("2. Trier par Montant toutes les Transactions");
                                        System.out.println("0. Quitter");
                                        System.out.println("Entrez votre choix: ");
                                        choix4 = s.nextInt();
                                        switch (choix4){
                                            case 1:
                                                market.triParDate();
                                                break;
                                            case 2:
                                                market.triParMontant();
                                                break;
                                            case 0:
                                                System.out.println("Retour.......");
                                                break;
                                            default:
                                                System.out.println("Choix invalide! Veuillez réessayer.");
                                                break;
                                        }

                                    }while(choix4!=0);
                                    break;
                                case 13:
                                    System.out.println("Entrez le code de l'Actif");
                                    String code = s.next();
                                    market.VolumeTotalActif(code);
                                    break;
                                case 14:
                                    market.VolumeTotalAchatVente();
                                    break;
                                case 15:
                                    int choix2;
                                    do {
                                        System.out.println("======= Analyse de performance par trader ========");
                                        System.out.println("1.Volume total échangé par trader");
                                        System.out.println("2.Nombre total d’ordres passés");
                                        System.out.println("3.Classement des traders par volume ");
                                        System.out.println("0.Quitter");
                                        System.out.println("Entrez votre choix: ");
                                        choix2 = s.nextInt();
                                        switch (choix2){
                                            case 1:
                                                System.out.println("Entrez l'ID du Trader: ");
                                                int id2= s.nextInt();
                                                market.VolumeTotalParTrader(id2);
                                                break;
                                            case 2:

                                                 break;
                                            case 3:

                                                break;


                                        }

                                    }while(choix2!=0);
                                case 0:
                                    System.out.println("Retour au Menu Principal.......");
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
                                    market.afficherCatalogueStock();
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
                                    market.afficherCatalogueCrypto();
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
                                    System.out.println("Retour au Menu Principal.......");
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

            } catch (Exception e) {
                System.out.println("Une erreur inattendue est survenue." );
                s.nextLine();
                choice = 0;
            }
            } while (choice != 0) ;





    }

}
