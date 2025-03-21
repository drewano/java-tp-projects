package question4;

import java.util.List;
import java.util.function.Predicate;
import question2.IMailBoxListener;

/**
 * Superclasse abstraite des décorateurs MailBox.<br>
 * Elle implémente l'interface principale {@link IMailBox} et donc toutes les opérations.<br>
 * Elle prend en paramètre (constructeur) une MailBox à décorer.<br>
 * Par défaut, ses opérations appellent l'opération correspondante de la MailBox décorée (ne change pas le
 * fonctionnement de la MailBox décorée).<br>
 * Ses sous-classes devront ré-écrire uniquement les opérations qu'elles décorent vraiment (ajoute un traitement
 * supplémentaire à celui de la MailBox décorée).
 */
abstract class MailBoxDecorator implements IMailBox {

	protected IMailBox mbDecoree;

	/**
	 * Constructeur avec la MailBox à décorer
	 * 
	 * @param mbDecoree MailBox décorée
	 */
	public MailBoxDecorator(IMailBox mbDecoree) {
		this.mbDecoree = mbDecoree;
	}

	@Override
	public void add(String dest) throws Exception {
		mbDecoree.add(dest);
	}

	@Override
	public boolean estInscrit(String dest) throws Exception {
		return mbDecoree.estInscrit(dest);
	}

	@Override
	public void send(String message, String dest) throws Exception {
		mbDecoree.send(message, dest);
	}

	@Override
	public void send(String message, String[] dest) throws Exception {
		mbDecoree.send(message, dest);
	}

	@Override
	public List<String> read(String dest) throws Exception {
		return mbDecoree.read(dest);
	}

	@Override
	public List<String> getAllMessages(String dest) throws Exception {
		return mbDecoree.getAllMessages(dest);
	}

	@Override
	public List<String> getAllUnreadMessages(String dest) throws Exception {
		return mbDecoree.getAllUnreadMessages(dest);
	}

	@Override
	public void setMailBoxListener(String dest, IMailBoxListener listener) throws Exception {
		this.mbDecoree.setMailBoxListener(dest, listener);
	}

	@Override
	public void addMailBoxFilter(String dest, Predicate<String> listener) throws Exception {
		this.mbDecoree.addMailBoxFilter(dest, listener);
	}

}
