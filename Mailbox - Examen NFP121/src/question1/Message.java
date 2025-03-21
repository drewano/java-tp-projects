package question1;

/**
 * Classe d'un message géré par une {@link question1.IMailBox}.<br>
 * Un message est caractérisé par :
 * <ul>
 * <li>un texte,</li>
 * <li>un indicateur de lecture (true si lu, false sinon)</li>
 * </ul>
 */
public class Message {

	private String texte;
	private boolean lu;

	/**
	 * Init le texte du message et l'indicateur de lecture à false.
	 * 
	 * @param texte du message
	 */
	public Message(String texte) {
		this.texte = texte;
		this.lu = false;
	}

	/**
	 * Retourne le texte du message sans changer l'indicateur de lecteur.
	 * 
	 * @return le texte
	 */
	public String getTexte() {
		return this.texte;
	}

	/**
	 * Retourne l'indicateur de lecture du message.
	 * 
	 * @return true si le message est lu, false sinon
	 */
	public boolean estLu() {
		return this.lu;
	}

	/**
	 * Lit le message.<br>
	 * Retourne le texte du message et positionne l'indicateur de lecture à true.
	 * 
	 * @return le texte
	 */
	public String lire() {
		this.lu = true;
		return this.texte;
	}

	@Override
	public String toString() {
		return "{texte: '" + this.texte + ", lu: " + this.lu + "}";
	}

}
