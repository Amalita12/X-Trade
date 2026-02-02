import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Asset> {

    private List<ElementPortefeuille<T>> lignes;

    public Portfolio() {
        this.lignes = new ArrayList<>();
    }

    public void ajouterActif(T actif, int quantite) {

        for (ElementPortefeuille<T> ligne : lignes) {
            if (ligne.getActif().getCode().equalsIgnoreCase(actif.getCode())) {
                ligne.setQuantite(ligne.getQuantite() + quantite);
                return;
            }
        }

        lignes.add(new ElementPortefeuille<>(actif, quantite));
    }

    // Méthode pour retirer un actif (utilisée lors de la vente)
    public boolean retirerActif(String code, int quantite) {
        for (ElementPortefeuille<T> ligne : lignes) {
            if (ligne.getActif().getCode().equalsIgnoreCase(code)) {
                if (ligne.getQuantite() >= quantite) {
                    ligne.setQuantite(ligne.getQuantite() - quantite);

                    if (ligne.getQuantite() == 0) {
                        lignes.remove(ligne);
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public double calculerValeurTotale() {
        double total = 0;
        for (ElementPortefeuille<T> ligne : lignes) {
            total += ligne.getActif().getPrixUnitaire() * ligne.getQuantite();
        }
        return total;
    }

    public List<ElementPortefeuille<T>> getLignes() {
        return lignes;
    }

    public static class ElementPortefeuille<T> {
        private T actif;
        private int quantite;

        public ElementPortefeuille(T actif, int quantite) {
            this.actif = actif;
            this.quantite = quantite;
        }

        public T getActif() { return actif; }
        public int getQuantite() { return quantite; }
        public void setQuantite(int quantite) { this.quantite = quantite; }
    }

}