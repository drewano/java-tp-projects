
public class Village {
    private String nom;
    private String codePostal;
    private int nbHabitants;

    public Village(String nom, String codePostal, int nbHabitants) {
        this.nom = nom;
        this.codePostal = codePostal;
        if (nbHabitants <= 5000) {
            this.nbHabitants = nbHabitants;
        } else {
            System.out.println("Erreur: Un village ne peut pas avoir plus de 5000 habitants");
            this.nbHabitants = 5000;
        }
    }

    public void afficher() {
        System.out.println("Village: " + nom + " (" + codePostal + ") - " + nbHabitants + " habitants");
    }

    public int getNbHabitants() {
        return nbHabitants;
    }
}