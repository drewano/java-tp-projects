package question2;

import java.util.HashMap;
import java.util.Map;

import question1.MailBox;

/**
 * Implémentation d'une MailBox qui gère aussi la notification à un observateur
 * dès qu'un message est envoyé au destinataire observé.
 */
class MailBoxNotification extends MailBox implements IMailBoxNotification {

	/**
	 * Stocke, par destinataire (clé), son observateur (voir {@link IMailBoxListener}) (valeur)
	 */
	private Map<String, IMailBoxListener> observateurs;

	/**
	 * Init les {@link #observateurs}
	 */
	public MailBoxNotification() {
		this.observateurs = new HashMap<>();
	}

	@Override
	public void setMailBoxListener(String dest, IMailBoxListener listener) throws Exception {
		if (!estInscrit(dest))
			throw new Exception("Le destinataire '" + dest + "' n'est pas inscrit");
		if (listener == null)
			throw new Exception("L'observateur ne doit pas être null");

		observateurs.put(dest, listener);
	}

	/**
	 * Envoie un message à un destinataire et notifie l'observateur si présent.
	 */
	@Override
	public void send(String message, String[] dest) throws Exception {
		if (dest == null)
			throw new Exception("La liste des destinataires ne doit pas être null");
		if (message == null)
			throw new Exception("Le message ne doit pas être null");

		StringBuilder erreurs = new StringBuilder();

		/**
		 * Nous itérons sur chacun des destinataires.
		 * Pour notifier l'observateur de chacun, nous appelons
		 * la méthode send(String, String) surchargée ci-dessus
		 * (et non pas super.send(...)).
		 */

		for(String d : dest) {
			try {
				this.send(message, d);
			} catch(Exception e) {
				erreurs.append(e.getMessage()).append("\n");
			}
		}
		if(!erreurs.isEmpty()) {
			throw new Exception(erreurs.toString());
		}
	}

	/**
	 * Envoie le message à un seul destinataire en notifiant l’observateur
	 */
	@Override
	public void send(String message, String dest) throws Exception {
		super.send(message, dest);

		/**
		 * Après l’envoi, on vérifie si le destinataire possède un listener.
		 * S’il y en a un, on l’appelle (onReceive).
		 *
		 * Ce choix d’implémentation respecte le design pattern
		 * « Observer » : à chaque nouvel envoi, on notifie.
		 */

		IMailBoxListener listener = observateurs.get(dest);
		if (listener != null) {
			listener.onReceive(message);
		}
	}
}