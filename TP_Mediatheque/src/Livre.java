/**
 * Représente un Livre, qui est un type de Media.
 * Il contient en plus un nom d'auteur et un nombre de pages.
 */

public class Livre extends Media{
    private String nomAuteur;
    private int nbPages;

    // Constructeur
    public Livre (String titre, double prixttc, String nomAuteur, int nbPages){
        super(titre, prixttc);
        this.nomAuteur = nomAuteur;
        this.nbPages = nbPages;
    }

    // Getters et Setters
    public String getNomAuteur(){
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur){
        this.nomAuteur = nomAuteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages){
        this.nbPages = nbPages;
    }

    // Affichage
    @Override
    public void afficher(){
        System.out.println("[Livre] Titre : " + getTitre()
                + " | Auteur : " + nomAuteur
                + " | Nb pages : " + nbPages
                + " | Prix TTC : " + getPrixttc());
    }
}
