abstract class Asset {
    private String code;
    private String nom;
    private double prixUnitaire;
    private String typeActif;

    public Asset(String code, String nom, double prixUnitaire, String typeActif) {
        this.code = code;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.typeActif = typeActif;
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


}
