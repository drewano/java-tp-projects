package question3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import question1.MailBox;

/**
 * Implémentation d'une MailBox qui applique un ou plusieurs filtres
 * sur les messages "lus" afin de ne renvoyer que ceux qui ne correspondent pas
 * à un filtre.
 */
class MailBoxFilter extends MailBox implements IMailBoxFilter {

	/**
	 * Stocke, par destinataire (clé), la liste de ses filtres (valeur)
	 */
	private Map<String, List<Predicate<String>>> filtres;

	/**
	 * Init les {@link #filtres}
	 */
	public MailBoxFilter() {
		this.filtres = new HashMap<>();
	}

	@Override
	public void add(String dest) throws Exception {
		super.add(dest);
		// Initialise la liste de filtres pour ce nouveau destinataire
		this.filtres.put(dest, new ArrayList<>());
	}

	@Override
	public void addMailBoxFilter(String dest, Predicate<String> filter) throws Exception {
		if (!estInscrit(dest))
			throw new Exception("Le destinataire '" + dest + "' n'est pas inscrit");
		if (filter == null)
			throw new Exception("Le filtre ne doit pas être null");

		/**
		 * Simplement, on récupère la liste de filtres pour ce destinataire
		 * et on ajoute le nouveau filter.
		 *
		 * Ce choix suit le design : un destinataire peut avoir plusieurs filtres
		 * (chacun s’appliquera en lecture).
		 */

		this.filtres.get(dest).add(filter);
	}

	@Override
	public List<String> read(String dest) throws Exception {
		/**
		 * On s’appuie d’abord sur la méthode 'read' de MailBox
		 * pour récupérer tous les messages non lus.
		 * Ensuite, on ne garde que ceux qui ne sont pas filtrés.
		 */
		List<String> listeMsg = super.read(dest);
		List<String> listeMsgNonFiltres = new ArrayList<>();
		for (String m : listeMsg) {
			// On utilise la méthode 'filtre(dest, m)' pour savoir si c’est filtré
			if (!filtre(dest, m)) {
				listeMsgNonFiltres.add(m);
			}
		}
		return listeMsgNonFiltres;
	}

	/**
	 * Détermine si le message doit être « filtré »
	 * (c’est-à-dire s’il correspond à l’un des filtres).
	 *
	 * @param  dest      nom du destinataire
	 * @param  message   le message à tester
	 * @return           true si un des filtres 'test' le message, false sinon
	 */
	private boolean filtre(String dest, String message) {
		// On récupère la liste de prédicats/filtres pour le destinataire
		List<Predicate<String>> listeFiltres = filtres.get(dest);
		if (listeFiltres == null) return false;  // aucun filtre => message autorisé
		// Si l'un des filtres renvoie true (match),
		// alors on considère le message comme filtré => on arrête et retourne true
		for (Predicate<String> p : listeFiltres) {
			if (p.test(message)) {
				return true;
			}
		}
		// aucun filtre n’a matché => on retourne false (pas filtré)
		return false;
	}
}
