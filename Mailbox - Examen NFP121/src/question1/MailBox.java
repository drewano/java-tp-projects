package question1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implémentation simple d'une MailBox gérant des destinataires et leurs messages.
 * Chaque destinataire inscrit possède une liste de {@link Message}.
 */
public class MailBox implements IMailBox {

	/**
	 * Stocke, par destinataire (clé), la liste de ses {@link Message}s reçus (valeur)
	 */
	protected Map<String, List<Message>> bal;

	/**
	 * Init la {@link #bal}
	 */
	public MailBox() {
		this.bal = new HashMap<>();
	}

	@Override
	public void add(String dest) throws Exception {
		if (estInscrit(dest))
			throw new Exception("Le destinataire '" + dest + "' est déjà inscrit");
		this.bal.put(dest, new ArrayList<>());
	}

	@Override
	public boolean estInscrit(String dest) throws Exception {
		if (dest == null)
			throw new Exception("Le destinataire ne doit pas être null");
		return bal.containsKey(dest);
	}

	@Override
	public void send(String message, String dest) throws Exception {
		if (!estInscrit(dest))
			throw new Exception("Le destinataire '" + dest + "' n'est pas inscrit");
		if (message == null)
			throw new Exception("Le message ne doit pas être null");

		List<Message> listeMsg = bal.get(dest);
		listeMsg.add(new Message(message));
	}

	/**
	 * Envoie un message à plusieurs destinataires.
	 * @param message   le message à envoyer
	 * @param dest      le nom des destinataires du message
	 * @throws Exception
	 */

	@Override
	public void send(String message, String[] dest) throws Exception {
		if (dest == null)
			throw new Exception("La liste des destinataires ne doit pas être null");
		if (message == null)
			throw new Exception("Le message ne doit pas être null");

		// Stocke les éventuelles erreurs
		StringBuilder erreur = new StringBuilder();

		/**
		 * Nous parcourons chacun des destinataires.
		 * - S'il est inscrit, on ajoute un nouveau Message dans sa liste.
		 * - S'il ne l'est pas, on ajoute un message d'erreur dans 'erreur'.
		 *
		 * Ce choix d'implémentation permet de « distribuer partiellement » le message :
		 *   => Les destinataires valides reçoivent le message, même si d'autres sont invalides.
		 * A la fin, si au moins un destinataire est invalide, on lève une Exception contenant
		 * tous les messages d'erreur.
		 */

		for (String d : dest) {
			try {
				if (!estInscrit(d)) {
					erreur.append("Le destinataire '").append(d).append("' n'est pas inscrit\n");
				} else {
					List<Message> listeMsg = bal.get(d);
					listeMsg.add(new Message(message));
				}
			} catch (Exception e) {
				// Si d == null ou autre cas improbable
				erreur.append(e.getMessage()).append("\n");
			}
		}

		// S'il y a au moins une erreur, on lève une Exception contenant
		// toutes les erreurs recensées.
		if (!erreur.isEmpty()) {
			throw new Exception(erreur.toString());
		}
	}

	/**
	 * Retourne la liste des messages non lus du destinataire.
	 * @param dest      le nom du destinataire.
	 * @return
	 * @throws Exception
	 */

	@Override
	public List<String> read(String dest) throws Exception {
		if (!estInscrit(dest))
			throw new Exception("Le destinataire '" + dest + "' n'est pas inscrit");

		List<String> listeMsgNonLus = new ArrayList<>();
		for (Message msg : bal.get(dest)) {
			if (!msg.estLu()) {
				listeMsgNonLus.add(msg.lire());
			}
		}
		return listeMsgNonLus;
	}

	/**
	 * Retourne la liste des messages non lus du destinataire.
	 * @param dest      le nom du destinataire.
	 * @return
	 * @throws Exception
	 */

	@Override
	public List<String> getAllUnreadMessages(String dest) throws Exception {
		if (!estInscrit(dest))
			throw new Exception("Le destinataire '" + dest + "' n'est pas inscrit");

		/**
		 * Cette liste contiendra tous les messages non lus (mais ne les marque pas comme lus).
		 * Choix d'implémentation : on parcourt les Messages du destinataire,
		 * et on ne fait que collecter ceux qui ne sont pas encore lus.
		 */

		List<String> listeMsgNonLus = new ArrayList<>();
		for (Message msg : bal.get(dest)) {
			if (!msg.estLu()) {
				listeMsgNonLus.add(msg.getTexte());
			}
		}
		return listeMsgNonLus;
	}

	/**
	 * Retourne la liste de tous les messages du destinataire.
	 * @param dest      le nom du destinataire.
	 * @return
	 * @throws Exception
	 */

	@Override
	public List<String> getAllMessages(String dest) throws Exception {
		if (!estInscrit(dest))
			throw new Exception("Le destinataire '" + dest + "' n'est pas inscrit");

		/**
		 * Retourne tous les messages (lus ou non) au format String (juste le texte).
		 * On ne change pas l'état de lecture, on se contente de récupérer
		 * le getTexte() de chacun.
		 */

		List<String> listeMsg = new ArrayList<>();
		for (Message msg : bal.get(dest)) {
			listeMsg.add(msg.getTexte());
		}
		return listeMsg;
	}
}
