package question2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import question1.IMailBox;
import question1.MailBox;

class TestMailBoxWithNotification {

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

	@Test
	public void testScenario1() throws Exception{
		IMailBoxNotification mb = new MailBoxNotification();
		IMailBoxListener listenerA = new TestMailBoxListener();
		
		// "a" est inscrit
		mb.add("a");
		
		// inscrit un listener auprès de "a"
		mb.setMailBoxListener("a", listenerA);
		
		// "b" est inscrit
		mb.add("b");
		
		// envoie un message à "a"
		String msg = "msg";
		mb.send(msg,"a");
		
		// envoie un message à "b"
		mb.send(msg,"b");
				
		assertEquals(msg,listenerA.getNotifications().get(0));
		assertEquals(0,listenerA.getNotifications().size());
		}

	@Test
	public void testScenario2() throws Exception{
		IMailBoxNotification mb = new MailBoxNotification();
		
		// 3 destinataires inscrits : "a", "b" et "c"
		mb.add("a");
		mb.add("b");
		mb.add("c");
		
		// inscrit un listener auprès de "a"
		TestMailBoxListener listenerA = new TestMailBoxListener();
		mb.setMailBoxListener("a", listenerA);
		
		// inscrit un listener auprès de "b"
		TestMailBoxListener listenerB = new TestMailBoxListener();
		mb.setMailBoxListener("b", listenerB);
		
		// envoie un message à "a"
		String msg1 = "msg1";
		mb.send(msg1, "a");
		
		// envoie un message à "a", "b" et "c"
		String msg2 = "msg2";
		mb.send(msg2,new String[]{"a","b","c"});
		
		List<String> notifsA = listenerA.getNotifications();
		assertEquals(msg1,notifsA.get(0));
		assertEquals(msg2,notifsA.get(1));
		assertEquals(msg2,listenerB.getNotifications().get(0));
	}

}
