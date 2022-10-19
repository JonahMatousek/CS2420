package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Test;



class SinglyLinkedListTest {

	@Test
	void testInsertFirst() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		String[] correct = new String[] {"Hello"};
		//System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(),correct));
	}
	
	@Test
	void testInsertFirstMultiple() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		String[] correct = new String[] {"No","Bye","Hello"};
		//System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(),correct));
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
		String[] correct = new String[] {"again","Nope","No","Surprise","Bye","Hello"};
		//System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(),correct));
	}
	
	@Test
	void testInsertEnd() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		list.insert(3, "Surprise");
		String[] correct = new String[] {"No","Bye","Hello","Surprise"};
		//System.out.println(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(list.toArray(),correct));
	}
	
	@Test
	void testGetFirst() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertTrue(list.getFirst().compareTo("No")==0);
	}
	
	@Test
	void testGetIndex() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		//System.out.println(list.get(1));
		assertTrue(list.get(2).compareTo("Hello")==0);
	}
	
	@Test
	void testDeleteFirst() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		list.deleteFirst();
		//System.out.println(list.deleteFirst());
		assertTrue(list.deleteFirst().compareTo("No")==0);
	}
	
	@Test
	void testDeleteMiddle() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		
		assertTrue(list.delete(1).compareTo("Bye")==0);
	}
	
	@Test
	void testIndexOf() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertEquals(2,list.indexOf("Hello"));
	}
	
	@Test
	void testSize() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		assertEquals(3,list.size());
		list.deleteFirst();
		assertEquals(2,list.size());
		
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
		assertEquals(4,list.size());
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
		assertTrue(list.size()==3);
		list.clear();
		assertTrue(list.size()==0);
	}
	
	@Test
	void testToArray() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		String[] correct = new String[] {"No","Bye","Hello"};
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
	
	@Test
	void testNext() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		Iterator<String> iter = list.iterator();
		assertEquals("No",iter.next());
		assertEquals("Bye",iter.next());
		//System.out.print(Arrays.toString(list.toArray()));
	}
	
	@Test
	void testIteratorRemove() {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.insertFirst("Hello");
		list.insertFirst("Bye");
		list.insertFirst("No");
		Iterator<String> iter = list.iterator();
		String[] correct = new String[] {"Bye","Hello"};
		iter.next();
		iter.remove();
		System.out.print(Arrays.toString(list.toArray()));
		assertTrue(Arrays.equals(correct, list.toArray()));
	}

}
