
public class VillePrefecture {
    private String nom;
    private String codePostal;
    private int nbHabitants;

    public VillePrefecture(String nom, String codePostal, int nbHabitants) {
        this.nom = nom;
        this.codePostal = codePostal;
        this.nbHabitants = nbHabitants;
    }

    public void afficher() {
        System.out.println("Ville Prefecture: " + nom + " (" + codePostal + ") - " + nbHabitants + " habitants");
    }

    public int getNbHabitants() {
        return nbHabitants;
    }
}