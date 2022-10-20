package assign06;

import java.net.URL;
import java.util.NoSuchElementException;

/**
 * 
 * @author Casey Parker and Jonah Matousek
 * @version October 19, 2022
 */
public class WebBrowser {
	private Stack<URL> backHistory;
	private Stack<URL> forwardHistory;
	private URL currentPage;

	/**
	 * This constructor creates a new web browser with no previously-visited
	 * webpages and no webpages to visit next.
	 */
	public WebBrowser() {

	}

	/**
	 * This constructor creates a new web browser with a preloaded history of
	 * visited webpages, given as a list of URL objects. The first webpage in the
	 * list is the "current" page visited, and the remaining webpages are ordered
	 * from most recently visited to least recently visited.
	 */
	public WebBrowser(SinglyLinkedList<URL> history) {
		currentPage = history.getFirst();
		history.deleteFirst();
		LinkedListStack<URL> temp = new LinkedListStack<URL>();
		for (int i = 0; i < history.size(); i++) {
			temp.push(history.getFirst());
			history.deleteFirst();
		}
		for (int i = 0; i < temp.size(); i++) {
			backHistory.push(history.getFirst());
			history.deleteFirst();
		}
	}

	/**
	 * This method simulates visiting a webpage, given as a URL. Note that calling
	 * this method should clear the forward stack, since there is no URL to visit
	 * next. This is just like a forward button (right facing arrow) on a real web
	 * browser. When you visit a link, the right-arrow is cleared.
	 * 
	 * @param webpage
	 */
	public void visit(URL webpage) {
		currentPage = webpage;
		forwardHistory.clear();
	}

	/**
	 * This method simulates using the back button, returning the URL visited.
	 * NoSuchElementException is thrown if there is no previously-visited URL.
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	public URL back() throws NoSuchElementException {
		if (backHistory.size() <= 0 || backHistory.equals(null)) {
			throw new NoSuchElementException();
		}
		forwardHistory.push(currentPage);
		currentPage = backHistory.peek();
		return backHistory.pop();

	}

	/**
	 * This method simulates using the forward button, returning the URL visited.
	 * NoSuchElementException is thrown if there is no URL to visit next.
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	public URL forward() throws NoSuchElementException {
		if (forwardHistory.size() <= 0 || forwardHistory.equals(null)) {
			throw new NoSuchElementException();
		}
		backHistory.push(currentPage);
		currentPage = forwardHistory.peek();
		return forwardHistory.pop();
	}

	/**
	 * This method generates a history of URLs visited, as a list of URL objects
	 * ordered from most recently visited to least recently visited (including the
	 * "current" page visited), without altering subsequent behavior of this web
	 * browser. "Forward" links are not included. The behavior of the method must be
	 * O(N), where N is the number of URLs.
	 * 
	 * @return
	 */
	public SinglyLinkedList<URL> history() {
		LinkedListStack<URL> temp = new LinkedListStack<URL>();
		temp.push(currentPage);
		for (int i = 0; i < backHistory.size(); i++) {
			temp.push(backHistory.pop());
		}
		SinglyLinkedList<URL> output = new SinglyLinkedList<URL>();
		for (int i = 0; i < temp.size(); i++) {
			output.insertFirst(temp.pop());
		}
		return output;
	}
}
