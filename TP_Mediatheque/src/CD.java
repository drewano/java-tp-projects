/**
 * Représente un CD, qui est un type de Media.
 * Il contient un nom d'interprète et un nombre de chansons.
 */

public class CD extends Media {
    private String nomInterprete;
    private int nbChansons;

    // Constructeur
    public CD(String titre, double prixttc, String nomInterprete, int nbChansons) {
        super(titre, prixttc);
        this.nomInterprete = nomInterprete;
        this.nbChansons = nbChansons;
    }

    // Getters et Setters
    public String getNomInterprete() {
        return nomInterprete;
    }

    public void setNomInterprete(String nomInterprete) {
        this.nomInterprete = nomInterprete;
    }

    public int getNbChansons() {
        return nbChansons;
    }

    public void setNbChansons(int nbChansons) {
        this.nbChansons = nbChansons;
    }

    // Affichage
    @Override
    public void afficher() {
        System.out.println("[CD] Titre : " + getTitre()
                + " | Interprète : " + nomInterprete
                + " | Nb chansons : " + nbChansons
                + " | Prix TTC : " + getPrixttc());
    }
}
