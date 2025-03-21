public class Departement {
    private String nom;
    private String numero;
    private Ville[] villes;
    private Village[] villages;
    private VillePrefecture villePrefecture;
    private int nbVilles;
    private int nbVillages;

    public Departement(String nom, String numero, VillePrefecture villePrefecture) {
        this.nom = nom;
        this.numero = numero;
        this.villePrefecture = villePrefecture;
        this.villes = new Ville[1];
        this.villages = new Village[1];
        this.nbVilles = 0;
        this.nbVillages = 0;
    }

    public void ajouterVille(Ville ville) {
        if (nbVilles == villes.length) {
            Ville[] newVilles = new Ville[villes.length + 1];
            for (int i = 0; i < villes.length; i++) {
                newVilles[i] = villes[i];
            }
            villes = newVilles;
        }
        villes[nbVilles] = ville;
        nbVilles++;
    }

    public void ajouterVillage(Village village) {
        if (nbVillages == villages.length) {
            Village[] newVillages = new Village[villages.length + 1];
            for (int i = 0; i < villages.length; i++) {
                newVillages[i] = villages[i];
            }
            villages = newVillages;
        }
        villages[nbVillages] = village;
        nbVillages++;
    }

    public int calculerNbHabitants() {
        int total = villePrefecture.getNbHabitants();
        for (int i = 0; i < nbVilles; i++) {
            total += villes[i].getNbHabitants();
        }
        for (int i = 0; i < nbVillages; i++) {
            total += villages[i].getNbHabitants();
        }
        return total;
    }

    public void afficher() {
        System.out.println("Département: " + nom + " (" + numero + ")");
        villePrefecture.afficher();
        System.out.println("Villes:");
        for (int i = 0; i < nbVilles; i++) {
            villes[i].afficher();
        }
        System.out.println("Villages:");
        for (int i = 0; i < nbVillages; i++) {
            villages[i].afficher();
        }
    }
}