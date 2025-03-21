package question4;

import java.util.List;

/**
 * Cette classe MailBox hérite de {@link MailBoxDecorator} afin d'être décorée mais n'est pas un décorateur.<br>
 * C'est pourquoi, son constructeur ne prend pas de MailBox à décorer (l'init à null).<br>
 * En conséquence, elle doit implémenter toutes les opérations de l'interface principale {@link IMailBox}.<br>
 * Pour éviter de re-coder toutes ces opérations, elle instantie {@link question1.MailBox} pour utiliser le code déjà écrit.
 */
class MailBox extends MailBoxDecorator {

	/**
	 * Utilise une instance de {@link question1.MailBox} pour éviter de re-coder toutes les opérations
	 */
	private question1.MailBox mb = new question1.MailBox();
	
	public MailBox() {
		super(null);
	}

	@Override
	public void add(String dest) throws Exception {
		mb.add(dest);
	}

	@Override
	public boolean estInscrit(String dest) throws Exception {
		return mb.estInscrit(dest);
	}

	@Override
	public void send(String message, String dest) throws Exception {
		mb.send(message, dest);
	}

	@Override
	public void send(String message, String[] dest) throws Exception {
		mb.send(message, dest);
	}

	@Override
	public List<String> read(String dest) throws Exception {
		return mb.read(dest);
	}

	@Override
	public List<String> getAllMessages(String dest) throws Exception {
		return mb.getAllMessages(dest);
	}

	@Override
	public List<String> getAllUnreadMessages(String dest) throws Exception {
		return mb.getAllUnreadMessages(dest);
	}
	
}
