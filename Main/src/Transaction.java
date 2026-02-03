import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
    private String typeTransaction;
    private int quantite;
    private double prixUnitaire;
    private Date date;
    private  Trader trader;
    private Asset actif;

    public Transaction(String typeTransaction, int quantite, double prixUnitaire, Date date, Trader trader, Asset actif) {
        this.typeTransaction = typeTransaction;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.date = date;
        this.trader = trader;
        this.actif = actif;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public Date getDate() {
        return date;
    }

    public Trader getTrader() {
        return trader;
    }

    public Asset getActif() {
        return actif;
    }
    @Override
    public String toString() {
        return date + " | " + typeTransaction + " | Actif: " + actif.getNom() +
                " | Qté: " + quantite + " | Prix: " + prixUnitaire + "$";
    }
}
