package question2;

import java.util.List;

/**
 * L’interface IMailBoxListener est implémentée par les destinataires souhaitant être notifiés.<br>
 * Cette interface contient la méthode {@link #onReceive(String)} exécutée à chaque envoi d’un message au destinataire.
 */
public interface IMailBoxListener {

	/**
	 * Méthode appelée à chaque envoi d'un nouveau message au destinataire.<br>
	 * Ce dernier est ajouté à la liste des notifications (liste des nouveaux messages reçus).
	 * 
	 * @param message à ajouter à la liste des notifications
	 */
	public void onReceive(String message);

	/**
	 * Renvoie la liste des notifications (liste des nouveaux messages reçus) et l'efface
	 * 
	 * @return la liste des notifications
	 */
	public List<String> getNotifications();

}
