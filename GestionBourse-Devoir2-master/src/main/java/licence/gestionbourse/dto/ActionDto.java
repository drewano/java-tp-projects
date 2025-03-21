package licence.gestionbourse.dto;

public class ActionDto
{
    private int id;
    private String nom;
    private int quantite;
    private double prix;
    private int numTrader;
    private int quantiteAVendre;

    public ActionDto(int id, String nom, int quantite, double prix, int numTrader) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.numTrader = numTrader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNumTrader() {
        return numTrader;
    }

    public void setNumTrader(int numTrader) {
        this.numTrader = numTrader;
    }

    public int getQuantiteAVendre() {
        return quantiteAVendre;
    }

    public void setQuantiteAVendre(int quantiteAVendre) {
        this.quantiteAVendre = quantiteAVendre;
    }

}
