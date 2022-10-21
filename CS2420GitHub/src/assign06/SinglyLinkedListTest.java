package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * @author Casey Parker and Jonah Matousek
 * @version October 19, 2022
 */
class SinglyLinkedListTest {

	@Test
	void testInsertFirst() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		String[] correct = new String[] { "Hello" };
		// System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(), correct));
	}

	@Test
	void testInsertFirstInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		Object[] correct = new Object[] { 1 };
		//System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(), correct));
	}

	@Test
	void testInsertFirstMultiple() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		String[] correct = new String[] { "No", "Bye", "Hello" };
		// System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(), correct));
	}

	@Test
	void testInsertFirstMultipleInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		Object[] correct = new Object[] { 3, 2, 1 };
		// System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(), correct));
	}

	@Test
	void testInsertMiddle() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		list.insertFirst("Nope");
		list.insertFirst("again");
		list.insert(3, "Surprise");
		String[] correct = new String[] { "again", "Nope", "No", "Surprise", "Bye", "Hello" };
		// System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(), correct));
	}

	@Test
	void testInsertMiddleInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		list.insertFirst(5);
		list.insert(3, 6);
		Object[] correct = new Object[] { 5, 4, 3, 6, 2, 1 };
		// System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(), correct));
	}

	@Test
	void testInsertEnd() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		list.insert(3, "Surprise");
		String[] correct = new String[] { "No", "Bye", "Hello", "Surprise" };
		// System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(), correct));
	}

	@Test
	void testInsertEndInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insert(3, 4);
		Object[] correct = new Object[] { 3, 2, 1, 4 };
		// System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(), correct));
	}
	@Test
	void testInsertException() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertThrows(IndexOutOfBoundsException.class,()->{list.insert(3,2);});
	}

	@Test
	void testGetFirst() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertTrue(list.getFirst().compareTo("No") == 0);
	}
	@Test
	void testGetLast() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertTrue(list.get(list.size()-1).compareTo("Hello") == 0);
	}
	@Test
	void testGetFirstException() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertThrows(NoSuchElementException.class,()->{list.getFirst();});
	}

	@Test
	void testGetFirstInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		assertTrue(list.getFirst().compareTo(3) == 0);
	}

	@Test
	void testGetIndex() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		// System.out.println(list.get(1));
		assertTrue(list.get(2).compareTo("Hello") == 0);
	}
	@Test
	void testGetIndexException() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertThrows(IndexOutOfBoundsException.class,()->{list.get(4);});
	}


	@Test
	void testGetIndexInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		// System.out.println(list.get(1));
		assertTrue(list.get(2).compareTo(1) == 0);
	}

	@Test
	void testDeleteFirst() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		

		assertTrue(list.deleteFirst().compareTo("No") == 0);
	}
	@Test
	void testDeleteFirstException() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertThrows(NoSuchElementException.class,()->{list.deleteFirst();});
	}
	
	
	@Test
	void testDeleteFirstInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		
		// System.out.println(list.deleteFirst());
		assertTrue(list.deleteFirst().compareTo(3) == 0);
	}

	@Test
	void testDeleteMiddle() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");

		assertTrue(list.delete(1).compareTo("Bye") == 0);
	}
	
	@Test
	void testDeleteIndexException() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertThrows(IndexOutOfBoundsException.class,()->{list.delete(4);});
	}
	
	void testDeleteMiddleInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);

		assertTrue(list.delete(1).compareTo(2) == 0);
	}

	@Test
	void testIndexOf() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertEquals(2, list.indexOf("Hello"));
	}
	
	@Test
	void testIndexOfInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		assertEquals(2, list.indexOf(1));
	}

	@Test
	void testSize() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertEquals(3, list.size());
		list.deleteFirst();
		assertEquals(2, list.size());

	}

	@Test
	void testSizeOther() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		list.insert(3, "Hi");
		list.insert(2, "Boo");
		list.delete(1);
		assertEquals(4, list.size());
	}

	@Test
	void testIsEmpty() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		assertTrue(list.isEmpty());
	}

	@Test
	void testIsEmptyOther() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertFalse(list.isEmpty());
	}

	@Test
	void testClear() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertTrue(list.size() == 3);
		list.clear();
		assertTrue(list.size() == 0);
	}

	@Test
	void testToArray() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		String[] correct = new String[] { "No", "Bye", "Hello" };
		assertTrue(Arrays.equals(correct, list.toArray()));
	}
	
	@Test
	void testToArrayInt() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		Object[] correct = new Object[] { 3, 2, 1 };
		assertTrue(Arrays.equals(correct, list.toArray()));
	}

	@Test
	void testHasNext() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		Iterator<String> iter = list.iterator();
		assertTrue(iter.hasNext());
		iter.next();
		assertTrue(iter.hasNext());
	}

	/*@Test
	void testNext() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		Iterator<String> iter = list.iterator();
		assertEquals("No", iter.next());
		assertEquals("Bye", iter.next());
		assertEquals("Hello",iter.next());
		// System.out.print(Arrays.toString(list.toArray()));
	}
*/
	@Test
	void testIteratorRemove() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		Iterator<String> iter = list.iterator();
		String[] correct = new String[] {  };
		System.out.println(iter.next());
		iter.remove();
		System.out.println(iter.next());
		iter.remove();
		System.out.println(iter.next());
		iter.remove();
		System.out.print(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(correct, list.toArray()));
	}
	
	

}
