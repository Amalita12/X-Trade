import java.sql.SQLOutput;
import java.util.Scanner;

public  class Main{
    public static void main(String[] args) {

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

                                    break;
                                case 2:

                                    break;
                                case 3:

                                    break;
                                case 4:

                                    break;
                                case 5:

                                    break;
                                case 6:

                                    break;
                                case 7:

                                    break;
                                case 8:

                                    break;
                                case 0:
                                    System.out.println("Merci d'utilisé X-Trade. Au revoir!");
                                    break;
                                default:
                                    System.out.println("hoix invalide. Veuillez réessayer");
                                    break;
                            }

                        } while (choix1 != 0);
                        break;


                    case 2:
                        int choix2;
                        do {
                            System.out.println("======Menu du Trader=======");
                            System.out.println("1.Acheter Stock");
                            System.out.println("2.Vendre Stock");
                            System.out.println("3.Acheter Crypto Currency");
                            System.out.println("4.Vendre Crypto Currency");
                            System.out.println("0.Quitter");
                            System.out.println("Entrez votre choix");
                            choix2 = s.nextInt();

                            switch (choix2) {
                                case 1:
                                    System.out.println("Achter stock will be her later");
                                    break;
                                case 2:
                                    System.out.println();

                                    break;
                                case 3:

                                    break;
                                case 4:

                                    break;
                                case 0:
                                    System.out.println("Merci d'utilisé X-Trade. Au revoir!");
                                    break;
                                default:
                                    System.out.println("hoix invalide. Veuillez réessayer");
                                    break;
                            }
                        } while (choix2 != 0);
                        break;
                    case 0:
                        System.out.println("Merci d'utilisé X-Trade. Au revoir!");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer");
                }


            } while (choice != 0) ;




    }

}
