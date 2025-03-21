
public class Region {
    private String nom;
    private Departement[] departements;
    private double superficie;
    private int nbDepartements;

    public Region(String nom, double superficie) {
        this.nom = nom;
        this.superficie = superficie;
        this.departements = new Departement[1];
        this.nbDepartements = 0;
    }

    public void ajouterDepartement(Departement departement) {
        if (nbDepartements == departements.length) {
            Departement[] newDepartements = new Departement[departements.length + 1];
            for (int i = 0; i < departements.length; i++) {
                newDepartements[i] = departements[i];
            }
            departements = newDepartements;
        }
        departements[nbDepartements] = departement;
        nbDepartements++;
    }

    public int calculerNbHabitants() {
        int total = 0;
        for (int i = 0; i < nbDepartements; i++) {
            total += departements[i].calculerNbHabitants();
        }
        return total;
    }

    public void afficher() {
        System.out.println("Région: " + nom);
        System.out.println("Superficie: " + superficie + " km²");
        System.out.println("Départements:");
        for (int i = 0; i < nbDepartements; i++) {
            departements[i].afficher();
        }
        System.out.println("Nombre total d'habitants: " + calculerNbHabitants());
    }
}