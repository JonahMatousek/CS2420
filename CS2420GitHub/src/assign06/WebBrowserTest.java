package assign06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class WebBrowserTest {

	@Test
	void testVisit() {
		try {

			WebBrowser browser = new WebBrowser();
			URL site = new URL("http://www.example.com/docs/resource1.html");
			URL site2 = new URL("http://www.example.com/index.html");
			browser.visit(site);

			assertEquals(browser.getCurrentPage().toString(), site.toString());
			assertTrue(browser.getForwardHistory().size() == 0);

			browser.visit(site2);

			assertEquals(browser.getCurrentPage().toString(), site2.toString());
			assertTrue(browser.getBackHistory().size() == 1);

			browser.back();
			browser.visit(site);

			assertTrue(browser.getForwardHistory().size() == 0);
			assertTrue(browser.getBackHistory().size() == 1);

			browser.visit(site2);

			assertTrue(browser.getBackHistory().size() == 2);

			browser.visit(site);

			assertTrue(browser.getBackHistory().size() == 3);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testBack() {
		try {

			WebBrowser browser = new WebBrowser();
			URL site = new URL("http://www.example.com/docs/resource1.html");
			URL site2 = new URL("http://www.example.com/index.html");
			browser.visit(site);
			browser.visit(site2);
			browser.back();

			assertEquals(browser.getCurrentPage().toString(), site.toString());
			assertTrue(browser.getForwardHistory().size() == 1);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testForward() {
		try {

			WebBrowser browser = new WebBrowser();
			URL site = new URL("http://www.example.com/docs/resource1.html");
			URL site2 = new URL("http://www.example.com/index.html");
			browser.visit(site);
			browser.visit(site2);
			browser.back();
			browser.forward();

			assertEquals(browser.getCurrentPage().toString(), site2.toString());
			assertTrue(browser.getForwardHistory().size() == 0);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testHistory() {
		try {

			WebBrowser browser = new WebBrowser();
			URL site = new URL("http://www.example.com/docs/resource1.html");
			URL site2 = new URL("http://www.example.com/index.html");
			URL site3 = new URL("http://www.example.com/FAQ.html");
			URL site4 = new URL("http://www.example.com/Help.html");
			browser.visit(site);
			browser.visit(site2);
			browser.visit(site3);
			browser.visit(site4);

			SinglyLinkedList<URL> history = new SinglyLinkedList<URL>();
			history = browser.history();
			String[] arr = new String[] {"http://www.example.com/Help.html","http://www.example.com/FAQ.html","http://www.example.com/index.html","http://www.example.com/docs/resource1.html"};
			assertTrue(history.size() == 4);
			//System.out.println(Arrays.toString(history.toArray()));
			assertTrue(Arrays.toString(arr).compareTo(Arrays.toString(history.toArray()))==0);
		//System.out.println(history.getFirst());
//			history.deleteFirst();
		//System.out.println(history.getFirst());
//			history.deleteFirst();
		//System.out.println(history.getFirst());
//			history.deleteFirst();
		//System.out.println(history.getFirst());
			
			
//			assertEquals(site,history.getFirst());
//			assertEquals(history.get(1), site2);
//			assertEquals(history.get(2), site);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
