import java.util.Date;

public class Transaction {
    private String typeTransaction;
    private int quantite;
    private double prixUnitaire;
    private Date date;

    public Transaction(String typeTransaction, int quantite, double prixUnitaire, Date date) {
        this.typeTransaction = typeTransaction;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.date = date;
    }
}
