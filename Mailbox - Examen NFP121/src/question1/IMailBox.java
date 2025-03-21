package question1;

import java.util.List;

/**
 * L’interface IMailBox propose les opérations :
 * <ul>
 * <li>d’inscription d’un destinataire de messages : {@link #add(String)},</li>
 * <li>de vérification qu'un destinataire est inscrit : {@link #estInscrit(String)},</li>
 * <li>d’envoi d’un message à un seul destinataire : {@link #send(String, String)},</li>
 * <li>d’envoi d’un message à plusieurs destinataires : {@link #send(String, String[])},</li>
 * <li>pour relever les messages non lus d'un destinataire : {@link #read(String)},</li>
 * <li>d'obtention de tous les messages d'un destinataire : {@link #getAllMessages(String)},</li>
 * <li>d'obtention de tous les messages non lus d'un destinataire : {@link #getAllUnreadMessages(String)},</li>
 * </ul>
 */
public interface IMailBox {

	/**
	 * Inscription du destinataire.<br>
	 * L’inscription est obligatoire afin de recevoir des messages.<br>
	 * <b>Attention, pas d'homonyme possible.</b>
	 * 
	 * @param  dest      le nom du destinataire (nom de l’utilisateur par exemple)
	 * @throws Exception si le destinataire est déjà inscrit
	 */
	public void add(String dest) throws Exception;

	/**
	 * Vérification que le destinataire est inscrit.
	 * 
	 * @param  dest      le nom du destinataire
	 * @return           true si le destinataire est inscrit, false sinon
	 * @throws Exception si le destinataire est null
	 */
	public boolean estInscrit(String dest) throws Exception;

	/**
	 * Envoi du message au destinataire inscrit.
	 * 
	 * @param  message   le message à envoyer
	 * @param  dest      le nom du destinataire du message
	 * @throws Exception si le destinataire est inconnu (non inscrit, voir {@link #add(String)})
	 *                   ou si le message est null
	 */
	public void send(String message, String dest) throws Exception;

	/**
	 * Envoi du message à tous les destinataires inscrits.
	 * 
	 * @param  message   le message à envoyer
	 * @param  dest      le nom des destinataires du message
	 * @throws Exception si un des destinataires (au moins) est inconnu (non inscrit, voir {@link #add(String)})
	 *                   ou si le message est null
	 */
	public void send(String message, String[] dest) throws Exception;

	/**
	 * Relevé des messages non lus du destinataire.
	 * 
	 * @param  dest      le nom du destinataire
	 * @return           la liste contenant les nouveaux messages, depuis le dernier relevé
	 * @throws Exception si le destinataire est inconnu (non inscrit, voir {@link #add(String)})
	 */
	public List<String> read(String dest) throws Exception;

	/**
	 * Relevé de tous les messages du destinataire.
	 * 
	 * @param  dest      le nom du destinataire
	 * @return           la liste contenant tous les messages, lus ou non
	 * @throws Exception si le destinataire est inconnu (non inscrit, voir {@link #add(String)})
	 */
	public List<String> getAllMessages(String dest) throws Exception;

	/**
	 * Relevé de tous les messages non lus du destinataire.
	 * 
	 * @param  dest      le nom du destinataire.
	 * @return           la liste contenant tous les messages non lus.
	 * @throws Exception si le nom du destinataire est inconnu (non inscrit, voir {@link #add(String)})
	 */
	public List<String> getAllUnreadMessages(String dest) throws Exception;

}
