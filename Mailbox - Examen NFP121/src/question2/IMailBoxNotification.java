package question2;

import question1.IMailBox;

/**
 * L’interface IMailBoxNotification étend l'interface {@link IMailBox} avec l'opération :
 * <ul>
 * <li>d’inscription d’un observateur (voir {@link IMailBoxListener}) auprès d'un destinataire :
 * {@link #setMailBoxListener(String, IMailBoxListener)},</li>
 * </ul>
 */
public interface IMailBoxNotification extends IMailBox {

	/**
	 * Inscription d'un observateur (listener) auprès d'un destinataire afin de lui notifier les nouveaux messages.<br>
	 * Lorsqu'un nouveau message est envoyé au destinataire, l'observateur est notifié (le message est ajouté à sa liste
	 * des notifications).<br>
	 * Si le destinataire a déjà un observateur, celui-ci est remplacé par celui passé en paramètre.
	 * 
	 * @param  listener  l'observateur notifié à chaque envoie de nouveau message au destinataire
	 * @param  dest      le nom du destinataire
	 * @throws Exception si le destinataire est inconnu (non inscrit, voir {@link #add(String)})
	 *                   ou si l'observateur est null
	 */
	public void setMailBoxListener(String dest, IMailBoxListener listener) throws Exception;

}
