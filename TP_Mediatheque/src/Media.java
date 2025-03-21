/**
 * Classe abstraite représentant un media général.
 * Elle contient les attributs communs à tous les médias,
 * comme le titre et le prix TTC.
 *
 * Chaque sous-classe (DVD, CD, Livre) doit implémenter
 * la méthode abstraite afficher() pour décrire son affichage.
 */


public abstract class Media {
    private String titre;
    private double prixttc;

    // Constructeur
    public Media(String titre, double prixttc) {
        this.titre = titre;
        this.prixttc = prixttc;
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public double getPrixttc() {
        return prixttc;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPrixttc(double prixttc) {
        this.prixttc = prixttc;
    }

    // Méthode abstraite à implémenter dans les sous-classes
    public abstract void afficher();
}


