/**
 * Représente un DVD, qui est un type de Media.
 * Il contient en plus un nom de réalisateur et une durée.
 */

public class DVD extends Media {
    private String nomRealisateur;
    private int duree;

    // Constructeur
    public DVD(String titre, double prixttc, String nomRealisateur, int duree) {
        super(titre, prixttc);
        this.nomRealisateur = nomRealisateur;
        this.duree = duree;
    }

    // Getters et Setters
    public String getNomRealisateur() {
        return nomRealisateur;
    }

    public void setNomRealisateur(String nomRealisateur) {
        this.nomRealisateur = nomRealisateur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    // Affichage
    @Override
    public void afficher() {
        System.out.println("[DVD] Titre : " + getTitre()
                + " | Realisateur : " + nomRealisateur
                + " | Duree : " + duree
                + " | Prix TTC : " + getPrixttc());
    }
}
