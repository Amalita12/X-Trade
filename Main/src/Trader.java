import java.util.ArrayList;
import java.util.List;

public class Trader extends Person  {
private double soldeInitial;
private Portfolio portfolio;
private List<Transaction> transactions;

public Trader(int id, String nom, double soldeInitial) {
    super(id, nom);

    this.soldeInitial = soldeInitial;
    this.portfolio = new Portfolio(this);
    this.transactions = new ArrayList<>();
}
    public double getSoldeInitial() {
        return soldeInitial;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setSoldeInitial(double soldeInitial) {
        this.soldeInitial = soldeInitial;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }



    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
