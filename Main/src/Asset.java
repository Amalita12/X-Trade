abstract class Asset {
    private String code;
    private String nom;
    private double prixUnitaire;
    private String typeActif;
    int quantite;

    public Asset(String code, String nom, double prixUnitaire, String typeActif, int quantite) {
        this.code = code;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.typeActif = typeActif;
        this.quantite= quantite;
    }


    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public  void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setTypeActif(String typeActif) {
        this.typeActif = typeActif;
    }

    public String getTypeActif() {
        return typeActif;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
