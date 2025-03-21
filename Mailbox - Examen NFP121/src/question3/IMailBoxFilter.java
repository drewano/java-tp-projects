package question3;

import java.util.function.Predicate;

import question1.IMailBox;

/**
 * L’interface IMailBoxFilter étend l'interface {@link IMailBox} avec l'opération :
 * <ul>
 * <li>d’inscription d’un filtre (voir {@link Predicate}) auprès d'un destinataire :
 * {@link #addMailBoxFilter(String, Predicate)},</li>
 * </ul>
 */
public interface IMailBoxFilter extends IMailBox {

	/**
	 * Inscription d'un filtre (prédica) auprès d'un destinataire afin de filtrer ses messages lus.<br>
	 * Un filtre prend une chaine de caractères en paramètre (constructeur).<br>
	 * A la lecture d'un message, il renvoie true si le message testé contient cette chaine, false sinon.<br>
	 * Un destinataire peut avoir plusieurs filtres.
	 * 
	 * @param  dest      le nom du destinataire
	 * @param  filter    filtre à appliquer sur la lecture des messages
	 * @throws Exception si le destinataire est inconnu (non inscrit, voir {@link #add(String)})
	 *                   ou si le filtre est null
	 */
	public void addMailBoxFilter(String dest, Predicate<String> filter) throws Exception;
}
