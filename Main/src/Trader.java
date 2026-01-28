public class Trader extends Person  {
private double soldeInitial;
private Portfolio portfolio;

public Trader(int id, String nom, double soldeInitial){
    this.soldeInitial= soldeInitial;
    this.portfolio = new Portfolio();
    super(id,nom);
}

    public double getSoldeInitial() {
        return soldeInitial;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
