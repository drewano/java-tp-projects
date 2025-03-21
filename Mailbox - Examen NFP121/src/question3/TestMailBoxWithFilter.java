package question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class TestMailBoxWithFilter {

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
	public void testScenario1() throws Exception{
		IMailBoxFilter mb = new MailBoxFilter();
		Predicate<String> filterSPAM = new TestMailBoxFilter("SPAM");
		
		// "a" est inscrit
		mb.add("a");
		
		// inscrit un filtre auprès de "a"
		mb.addMailBoxFilter("a", filterSPAM);
		
		// envoie un message à "a"
		String msg = "msg";
		mb.send(msg,"a");
		assertEquals(msg,mb.read("a").get(0));
		
		mb.send("SPAM : message","a");
		assertEquals(0,mb.read("a").size());
		}

	@Test
	public void testScenario2() throws Exception{
		IMailBoxFilter mb = new MailBoxFilter();
		
		// 2 destinataires inscrits : "a" et "b"
		mb.add("a");
		mb.add("b");
		
		// inscrit 2 filtres auprès de "a"
		Predicate<String> filterMsg1 = new TestMailBoxFilter("1");
		mb.addMailBoxFilter("a", filterMsg1);
		
		Predicate<String> filterMsg2 = new TestMailBoxFilter("2");
		mb.addMailBoxFilter("a", filterMsg2);
		
		// envoie un message à "a"
		String msg1 = "msg1";
		mb.send(msg1, "a");
		
		// envoie un message à "a" et "b"
		String msg2 = "msg2";
		mb.send(msg2,new String[]{"a","b"});
		
		List<String> listeMsgA = mb.read("a");
		List<String> listeMsgB = mb.read("b");
		assertEquals(0,listeMsgA.size());
		assertEquals(msg2,listeMsgB.get(0));
	}
}
