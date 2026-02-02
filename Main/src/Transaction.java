import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
    private String typeTransaction;
    private int quantite;
    private double prixUnitaire;
    private Date date;
    private  Trader trader;

    public Transaction(String typeTransaction, int quantite, double prixUnitaire, Date date, Trader trader) {
        this.typeTransaction = typeTransaction;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.date = date;
        this.trader = trader;
    }
}
