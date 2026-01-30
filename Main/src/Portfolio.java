import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Asset> {
    // La liste des lignes du portfolio (Actif + Quantité)
    private List<ElementPortefeuille<T>> lignes;

    public Portfolio() {
        this.lignes = new ArrayList<>();
    }

    // Méthode pour ajouter un actif (utilisée lors de l'achat)
    public void ajouterActif(T actif, int quantite) {
        // On vérifie si le trader possède déjà cet actif pour augmenter la quantité
        for (ElementPortefeuille<T> ligne : lignes) {
            if (ligne.getActif().getCode().equalsIgnoreCase(actif.getCode())) {
                ligne.setQuantite(ligne.getQuantite() + quantite);
                return;
            }
        }
        // Sinon, on crée une nouvelle ligne
        lignes.add(new ElementPortefeuille<>(actif, quantite));
    }

    // Méthode pour retirer un actif (utilisée lors de la vente)
    public boolean retirerActif(String code, int quantite) {
        for (ElementPortefeuille<T> ligne : lignes) {
            if (ligne.getActif().getCode().equalsIgnoreCase(code)) {
                if (ligne.getQuantite() >= quantite) {
                    ligne.setQuantite(ligne.getQuantite() - quantite);
                    // Si la quantité devient nulle, on supprime l'actif du portfolio
                    if (ligne.getQuantite() == 0) {
                        lignes.remove(ligne);
                    }
                    return true; // Succès du check et du retrait
                } else {
                    return false; // Échec : Quantité possédée insuffisante
                }
            }
        }
        return false; // Échec : Actif non trouvé dans le portfolio
    }

    // Méthode pour calculer la valeur totale
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

    // --- CLASSE INTERNE (INNER CLASS) ---
    // Représente chaque ligne du portfolio
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