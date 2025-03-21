package question4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import question2.IMailBoxListener;
import question4.TestMailBoxDecorator.TestMailBoxFilter;
import question4.TestMailBoxDecorator.TestMailBoxListener;

public class TestMailBoxDecorator {

	public class TestMailBoxListener implements IMailBoxListener {
		private List<String> notifications = new ArrayList<>();

		@Override
		public void onReceive(String message) {
			notifications.add(message);
		}

		@Override
		public List<String> getNotifications() {
			List<String> notifs = notifications;
			notifications = new ArrayList<>();
			return notifs;
		}
	}

	public class TestMailBoxFilter implements Predicate<String> {

		private String filtre;

		public TestMailBoxFilter(String filtre) {
			this.filtre = filtre;
		}

		@Override
		public boolean test(String message) {
			return message.contains(filtre);
		}
	}
	
	@Test
	public void testScenario1() throws Exception {
		IMailBox mb = new MailBoxNotification(new MailBox());
		IMailBoxListener listener = new TestMailBoxListener();
	
		// "a" est inscrit
		mb.add("a");
		
		// inscrit le listener auprès de "a"
		mb.setMailBoxListener("a", listener);
		
		// envoie 2 messages à "a"
		String msg1 = "msg1";
		String msg2 = "msg2";
		mb.send(msg1, "a");
		mb.send(msg2, "a");
		
		List<String> notifs = listener.getNotifications();
		assertEquals(msg1, notifs.get(0));
		assertEquals(msg2, notifs.get(1));
		assertEquals(0, listener.getNotifications().size());
	}
	
	@Test
	public void testScenario2() throws Exception {
		IMailBox mb = new MailBoxFilter(new MailBox());
		Predicate<String> filterMsg = new TestMailBoxFilter("1");

		// "a" est inscrit
		mb.add("a");
		
		// inscrit le filtre auprès de "a"
		mb.addMailBoxFilter("a", filterMsg);

		// envoie 2 messages à "a"
		String msg1 = "msg1";
		String msg2 = "msg2";
		mb.send(msg1, "a");
		mb.send(msg2, "a");
				
		List<String> listeMsg = mb.read("a");
		assertEquals(1, listeMsg.size());
		assertEquals(msg2, listeMsg.get(0));
	}

	
	@Test
	public void testScenario3() throws Exception {
		IMailBox mb = new MailBoxNotification(new MailBoxFilter(new MailBox()));
		IMailBoxListener listener = new TestMailBoxListener();
		Predicate<String> filterMsg = new TestMailBoxFilter("1");

		// "a" est inscrit
		mb.add("a");

		// inscrit le listener auprès de "a"
		mb.setMailBoxListener("a", listener);
		
		// inscrit le filtre auprès de "a"
		mb.addMailBoxFilter("a", filterMsg);

		// envoie 2 messages à "a"
		String msg1 = "msg1";
		String msg2 = "msg2";
		mb.send(msg1, "a");
		mb.send(msg2, "a");
		
		List<String> notifs = listener.getNotifications();
		assertEquals(msg1, notifs.get(0));
		assertEquals(msg2, notifs.get(1));
		assertEquals(0, listener.getNotifications().size());
		
		List<String> listeMsg = mb.read("a");
		assertEquals(1, listeMsg.size());
		assertEquals(msg2, listeMsg.get(0));
	}
	
	@Test
	public void testScenario4() throws Exception {
		IMailBox mb = new MailBoxFilter(new MailBoxNotification(new MailBox()));
		IMailBoxListener listener = new TestMailBoxListener();
		Predicate<String> filterMsg = new TestMailBoxFilter("1");

		// "a" est inscrit
		mb.add("a");

		// inscrit le listener auprès de "a"
		mb.setMailBoxListener("a", listener);
		
		// inscrit le filtre auprès de "a"
		mb.addMailBoxFilter("a", filterMsg);

		// envoie 2 messages à "a"
		String msg1 = "msg1";
		String msg2 = "msg2";
		mb.send(msg1, "a");
		mb.send(msg2, "a");
		
		List<String> notifs = listener.getNotifications();
		assertEquals(msg1, notifs.get(0));
		assertEquals(msg2, notifs.get(1));
		assertEquals(0, listener.getNotifications().size());
		
		List<String> listeMsg = mb.read("a");
		assertEquals(1, listeMsg.size());
		assertEquals(msg2, listeMsg.get(0));
	}
}
