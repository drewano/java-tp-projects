/**
 * La classe Mediatheque gère une collection de Media (DVD, Livre, CD).
 * Elle propose plusieurs méthodes pour ajouter un nouveau Media,
 * l'afficher, et calculer le prix total par type ou globalement.
 */

import java.util.ArrayList;

public class Mediatheque {
    private ArrayList<Media> listeMedia;

    // Constructeur : initialise la liste de Media
    public Mediatheque() {
        listeMedia = new ArrayList<Media>();
    }

    //Ajoute un media à la liste
    public void ajouterMedia(Media media) {
        listeMedia.add(media);
    }

    //Affiche le contenu de la médiathèque
    public void afficherMediatheque() {
        if (listeMedia.isEmpty()) {
            System.out.println("La médiathèque est vide.");
        } else {
            for (Media media : listeMedia) {
                media.afficher();
            }
        }
    }

    //Calcule le prix total des DVD de la médiathèque
    public double calculerPrixTotalDVD() {
        double prixTotalDVD = 0;
        // Parcours de la liste de médias pour calculer le prix total des DVD
        for (Media media : listeMedia) {
            // Si le média est un DVD, on ajoute son prix à la somme
            if (media instanceof DVD) {
                prixTotalDVD += media.getPrixttc();
            }
        }
        return prixTotalDVD;
    }

    //Calcule le prix total des CD de la médiathèque
    public double calculerPrixTotalCD() {
        double prixTotalCD = 0;
        // Parcours de la liste de médias pour calculer le prix total des CD
        for (Media media : listeMedia) {
            // Si le média est un CD, on ajoute son prix à la somme
            if (media instanceof CD) {
                prixTotalCD += media.getPrixttc();
            }
        }
        return prixTotalCD;
    }

    public double calculerPrixTotalLivre() {
        double prixTotalLivre = 0;
        // Parcours de la liste de médias pour calculer le prix total des Livres
        for (Media media : listeMedia) {
            // Si le média est un Livre, on ajoute son prix à la somme
            if (media instanceof Livre) {
                prixTotalLivre += media.getPrixttc();
            }
        }
        return prixTotalLivre;
    }

    public double calculerPrixTotal() {
        double prixTotal = 0;
        // Parcours de la liste de médias pour calculer le prix total
        for (Media media : listeMedia) {
            // On ajoute le prix de chaque média à la somme
            prixTotal += media.getPrixttc();
        }
        return prixTotal;
    }
}
