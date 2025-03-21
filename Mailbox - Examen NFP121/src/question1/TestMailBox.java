package question1;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class TestMailBox {

	@Test
	void testScenario1() throws Exception {
		IMailBox mb = new MailBox();

		// 4 destinataires inscrits : "a", "b", "c" et "d"
		mb.add("a");
		mb.add("b");
		mb.add("c");
		mb.add("d");

		// envoie un message à “a”
		String msg1 = "msg1";
		mb.send(msg1, "a");

		// lit les messages non lus de "a"
		List<String> list = mb.read("a");
		assertEquals(1, list.size());
		assertEquals(msg1, list.get(0));

		// lit les messages non lus de "a"
		list = mb.read("a");
		assertEquals(0, list.size());

		// envoie un message à "a"
		String msg2 = "msg2";
		mb.send(msg2, "a");

		// lit les messages non lus de "a"
		list = mb.read("a");

		// envoie un message à "a", "b", "c", "d"
		String msg3 = "msg3";
		mb.send(msg3, new String[] { "a", "b", "c", "d" });

		// envoie un message à "a", "b", "c"
		String msg4 = "msg4";
		mb.send(msg4, new String[] { "a", "b", "c" });

		// lit les messages non lus de "b"
		list = mb.read("b");
		assertEquals(2, list.size());
		assertEquals(msg3, list.get(0));
		assertEquals(msg4, list.get(1));

		// récupére tous les messages de "a"
		list = mb.getAllMessages("a");
		assertEquals(4, list.size());
		assertEquals(msg1, list.get(0));
		assertEquals(msg2, list.get(1));
		assertEquals(msg3, list.get(2));
		assertEquals(msg4, list.get(3));

		// récupére tous les messages non lus de "a"
		list = mb.getAllUnreadMessages("a");
		assertEquals(2, list.size());
		assertEquals(msg3, list.get(0));
		assertEquals(msg4, list.get(1));
	}

	@Test
	public void testScenario2() throws Exception {
		IMailBox mb = new MailBox();

		// 4 destinataires inscrits : "a", "b", "c" et "d"
		mb.add("a");
		mb.add("b");
		mb.add("c");
		mb.add("d");

		// envoie un message à "a", "b", "x" et "c"
		String msg1 = "msg1";
		try {
			mb.send(msg1, new String[] { "a", "b", "x", "c" });
			fail("x est inconnu, une exception doit être levée");
		} catch (Exception e1) {
			// lit les messages non lus de "a", "b", "c" et "d"
			assertEquals(msg1, mb.read("a").get(0));
			assertEquals(msg1, mb.read("b").get(0));
			assertEquals(msg1, mb.read("c").get(0));
			assertEquals(0, mb.read("d").size());
		}
	}

	@Test
	void testException() throws Exception {
		IMailBox mb = new MailBox();

		// ajoute un destinataire null
		Exception erreur = assertThrows(Exception.class, () -> {
			mb.add(null);
		}, "Exception was expected");
		assertEquals("Le destinataire ne doit pas être null", erreur.getMessage());

		// ajoute un destinataire existant déjà
		mb.add("a");
		erreur = assertThrows(Exception.class, () -> {
			mb.add("a");
		}, "Exception was expected");
		assertEquals("Le destinataire 'a' est déjà inscrit", erreur.getMessage());

		// envoie un message null
		erreur = assertThrows(Exception.class, () -> {
			mb.send(null, "a");
		}, "Exception was expected");
		assertEquals("Le message ne doit pas être null", erreur.getMessage());

		// envoie un message à un destinataire null
		String dest = null;
		erreur = assertThrows(Exception.class, () -> {
			mb.send("message", dest);
		}, "Exception was expected");
		assertEquals("Le destinataire ne doit pas être null", erreur.getMessage());

		// envoie un message à un destinataire inconnu
		erreur = assertThrows(Exception.class, () -> {
			mb.send("message", "z");
		}, "Exception was expected");
		assertEquals("Le destinataire 'z' n'est pas inscrit", erreur.getMessage());

		// envoie un message null
		final String[] dests = { "a" };
		erreur = assertThrows(Exception.class, () -> {
			mb.send(null, dests);
		}, "Exception was expected");
		assertEquals("Le message ne doit pas être null", erreur.getMessage());

		// envoi d’un message à un destinataire null
		final String[] destss = null;
		erreur = assertThrows(Exception.class, () -> {
			mb.send("message", destss);
		}, "Exception was expected");
		assertEquals("La liste des destinataires ne doit pas être null", erreur.getMessage());

		// envoie un message à un destinataire inconnu
		final String[] destsss = { "a", "b", "z" };
		erreur = assertThrows(Exception.class, () -> {
			mb.send("message", destsss);
		}, "Exception was expected");
		assertEquals("Le destinataire 'b' n'est pas inscrit\nLe destinataire 'z' n'est pas inscrit\n",
				erreur.getMessage());

		// lit les messages non lus d'un destinataire null
		erreur = assertThrows(Exception.class, () -> {
			mb.read(null);
		}, "Exception was expected");
		assertEquals("Le destinataire ne doit pas être null", erreur.getMessage());

		// lit les messages non lus d'un destinataire inconnu
		erreur = assertThrows(Exception.class, () -> {
			mb.read("z");
		}, "Exception was expected");
		assertEquals("Le destinataire 'z' n'est pas inscrit", erreur.getMessage());

		// récupère tous les messages d'un destinataire null
		erreur = assertThrows(Exception.class, () -> {
			mb.getAllMessages(null);
		}, "Exception was expected");
		assertEquals("Le destinataire ne doit pas être null", erreur.getMessage());

		// récupère tous les messages d'un destinataire inconnu
		erreur = assertThrows(Exception.class, () -> {
			mb.getAllMessages("z");
		}, "Exception was expected");
		assertEquals("Le destinataire 'z' n'est pas inscrit", erreur.getMessage());

		// récupère tous les messages non lus d'un destinataire null
		erreur = assertThrows(Exception.class, () -> {
			mb.getAllUnreadMessages(null);
		}, "Exception was expected");
		assertEquals("Le destinataire ne doit pas être null", erreur.getMessage());

		// récupère tous les messages non lus d'un destinataire inconnu
		erreur = assertThrows(Exception.class, () -> {
			mb.getAllUnreadMessages("z");
		}, "Exception was expected");
		assertEquals("Le destinataire 'z' n'est pas inscrit", erreur.getMessage());
	}

}
