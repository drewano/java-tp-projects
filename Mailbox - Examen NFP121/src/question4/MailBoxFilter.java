package question4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Décorateur MailBox pour filtrer les messages non lus.
 * Sous-classe de {@link MailBoxDecorator}.
 */
class MailBoxFilter extends MailBoxDecorator {

    /**
     * Stocke, par destinataire, la liste de ses filtres
     */
    private Map<String, List<Predicate<String>>> filtres;

    /**
     * Constructeur prenant la MailBox (déjà éventuellement décorée) à laquelle on ajoute
     * la fonctionnalité "Filter".
     *
     * @param mbDecoree MailBox décorée
     */
    public MailBoxFilter(IMailBox mbDecoree) {
        super(mbDecoree);
        this.filtres = new HashMap<>();
    }

    /**
     * On redéfinit add pour initialiser la liste de filtres du nouveau destinataire.
     */
    @Override
    public void add(String dest) throws Exception {
        super.add(dest);
        this.filtres.put(dest, new ArrayList<>());
    }

    /**
     * Enregistre un nouveau filtre pour un destinataire.
     */
    @Override
    public void addMailBoxFilter(String dest, Predicate<String> filter) throws Exception {
        if (!estInscrit(dest))
            throw new Exception("Le destinataire '" + dest + "' n'est pas inscrit");
        if (filter == null)
            throw new Exception("Le filtre ne doit pas être null");
        this.filtres.get(dest).add(filter);
    }

    /**
     * On redéfinit read pour éliminer les messages "filtrés".
     */
    @Override
    public List<String> read(String dest) throws Exception {
        // Récupère la liste brute des nouveaux messages
        List<String> origin = super.read(dest);
        List<String> nonFiltres = new ArrayList<>();

        for (String msg : origin) {
            if (!estFiltre(dest, msg)) {
                nonFiltres.add(msg);
            }
        }
        return nonFiltres;
    }

    /**
     * Vérifie si le message est filtré par au moins l'un des prédicats
     * de la liste associée au destinataire.
     *
     * @param dest    destinataire
     * @param message message lu
     * @return true si filtré, false sinon
     */
    private boolean estFiltre(String dest, String message) {
        List<Predicate<String>> list = this.filtres.get(dest);
        if (list == null) return false;
        for (Predicate<String> p : list) {
            if (p.test(message)) {
                return true;
            }
        }
        return false;
    }
}
