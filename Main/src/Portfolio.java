import javax.lang.model.element.Element;
import java.util.ArrayList;


public class Portfolio<T extends Asset> {


    private class Element<T> {
        private T actif;
        private int quantite; // La variable est ici

        public Element(T actif, int quantite) {
            this.actif = actif;
            this.quantite = quantite;
        }

        public T getActif() {
            return actif;
        }

        public int getQuantite() {
            return quantite;
        }
    }

    //public void ajouterActif(T actif, int quantite) {
        // On cherche si on l'a déjà
    //    for (Element<T> e : contenu) {
     //       if (e.getActif().getCode().equals(actif.getCode())) {
     //           e.setQuantite(e.getQuantite() + quantite);
     //           return;
     //       }
    //    }
        // Si on ne l'a pas trouvé, on l'ajoute à la liste
     //   contenu.add(new Element<>(actif, quantite));
   // }
}
