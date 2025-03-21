package question4;

/**
 * Cette interface IMailBox est l'interface principale des décorateurs MailBox.<br>
 * Elle est donc une extension de toutes les interfaces définies dans les exercices précédents.<br>
 * En effet, pour implémenter le pattern <b>Decorator</b>, l'interface principale doit contenir toutes les opérations
 * des différents types de décorateurs, soit toutes les interfaces des exercices 1 à 3 : {@link question1.IMailBox},
 * {@link question2.IMailBoxNotification} et {@link question3.IMailBoxFilter}.<br>
 * Ainsi les décorateurs MailBox devront implémenter toutes les opérations de cette interface principale. 
 */
public interface IMailBox extends question1.IMailBox, question2.IMailBoxNotification, question3.IMailBoxFilter {

}
