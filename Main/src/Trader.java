public class Trader extends Person  {
private double soldeInitial;

public Trader(int id, String nom, double soldeInitial){
    this.soldeInitial= soldeInitial;
    super(id,nom);
}

    public double getSoldeInitial() {
        return soldeInitial;
    }
}
