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

    public void displayDetails(){
        System.out.println("code: "+code+"nom"+nom+"prix unitaire"+prixUnitaire+"type actif"+typeActif);
    }
}
