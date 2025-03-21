package question4;

import java.util.HashMap;
import java.util.Map;

import question2.IMailBoxListener;

/**
 * Décorateur MailBox pour notifier un observateur à l'envoi d'un nouveau message.
 * Sous-classe de {@link MailBoxDecorator}.
 */
class MailBoxNotification extends MailBoxDecorator {

    /**
     * Stocke, par destinataire (clé), l'observateur associé, s'il existe
     */
    private Map<String, IMailBoxListener> observateurs;

    /**
     * Constructeur : on injecte la mailBox (déjà décorée ou pas) qu’on veut
     * enrichir avec la fonctionnalité "notification".
     *
     * @param mbDecoree mailBox déjà existante ou décorée
     */
    public MailBoxNotification(IMailBox mbDecoree) {
        super(mbDecoree);
        this.observateurs = new HashMap<>();
    }

    /**
     * On redéfinit l'opération add pour initialiser un "slot" d'observateur.
     */
    @Override
    public void add(String dest) throws Exception {
        super.add(dest);
        this.observateurs.put(dest, null);
    }

    /**
     * Inscrit un observateur en local, sans oublier de faire les vérifications
     * via la mailBox décorée.
     */
    @Override
    public void setMailBoxListener(String dest, IMailBoxListener listener) throws Exception {
        if (!estInscrit(dest))
            throw new Exception("Le destinataire '" + dest + "' n'est pas inscrit");
        if (listener == null)
            throw new Exception("L'observateur ne doit pas être null");

        this.observateurs.put(dest, listener);
    }

    /**
     * On redéfinit l'envoi à un destinataire unique pour déclencher la notification
     * si un observateur est présent.
     */
    @Override
    public void send(String message, String dest) throws Exception {
        super.send(message, dest);
        IMailBoxListener listener = observateurs.get(dest);
        if (listener != null) {
            listener.onReceive(message);
        }
    }
}
