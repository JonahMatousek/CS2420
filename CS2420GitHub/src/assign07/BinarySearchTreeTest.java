package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;



class BinarySearchTreeTest {

	@Test
	void testAddSimple() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		ArrayList<String> correct = new ArrayList<>();
		correct.add("Hello");

		//System.out.println(tree.toArrayList().toString());
		assertEquals(correct.toString(), tree.toArrayList().toString());
	}
	
	@Test
	void testAdd() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		ArrayList<String> correct = new ArrayList<>();
		correct.add("Apple");
		correct.add("Bye");
		correct.add("Hello");

		assertEquals(correct.toString(), tree.toArrayList().toString());
	}

	@Test
	void testAddAll() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		Collection<String> list = new ArrayList<String>();
		list.add("No");
		list.add("Hello");
		list.add("Bye");

		tree.addAll(list);

		ArrayList<String> correct = new ArrayList<>();
		correct.add("Bye");
		correct.add("Hello");
		correct.add("No");

		//System.out.println(tree.toArrayList().toString());
		assertEquals(correct.toString(), tree.toArrayList().toString());
	}
	
	@Test
	void testClear() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.clear();
		ArrayList<String> correct = new ArrayList<>();
		assertEquals(correct.toString(),tree.toArrayList().toString());
	}
	
	@Test
	void testContains() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.add("Yams");
		tree.add("Crabs");
		tree.add("Train");
		assertTrue(tree.contains("Yams"));
		
		assertFalse(tree.contains("Not Here"));
	}
	
	
	@Test
	void testContainsAll() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.add("Yams");
		tree.add("Crabs");
		tree.add("Train");
		tree.add("No");
		Collection<String> list = new ArrayList<String>();
		list.add("No");
		list.add("Hello");
		list.add("Bye");
		assertTrue(tree.containsAll(list));
		
		list.add("Not Here");
		assertFalse(tree.containsAll(list));
	}
	
	@Test
	void testFirst() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.add("Yams");
		tree.add("Crabs");
		tree.add("Train");
		tree.add("No");
		assertEquals("Apple",tree.first());
		
		BinarySearchTree<String> tree2 = new BinarySearchTree<>();
		assertThrows(NoSuchElementException.class,()-> tree2.first());
	}
	@Test
	void testLast() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.add("Yams");
		tree.add("Crabs");
		tree.add("Train");
		tree.add("No");
		assertEquals("Yams",tree.last());
		
		BinarySearchTree<String> tree2 = new BinarySearchTree<>();
		assertThrows(NoSuchElementException.class,()-> tree2.last());
	}
	
	@Test 
	void testIsEmpty() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		assertTrue(tree.isEmpty());
	}
	@Test 
	void testIsEmptyFalse() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		assertFalse(tree.isEmpty());
	}
	@Test 
	void testRemove() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.add("Yams");
		tree.add("Crabs");
		tree.add("Train");
		tree.add("No");
		tree.remove("No");
		ArrayList<String> correct= new ArrayList<>();
		correct.add("Apple");
		correct.add("Bye");
		correct.add("Crabs");
		correct.add("Hello");
		correct.add("Train");
		correct.add("Yams");
		
		
		assertEquals(correct.toString(),tree.toArrayList().toString());
		
		BinarySearchTree<String> tree2 = new BinarySearchTree<>();
		assertFalse(tree2.remove("Not Here"));
	}
	
	@Test
	void testRemoveAll() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.add("Yams");
		tree.add("Crabs");
		tree.add("Train");
		tree.add("No");
		Collection<String> list = new ArrayList<String>();
		list.add("Train");
		list.add("Apple");
		list.add("Hello");
		list.add("Yams");
		tree.removeAll(list);
		ArrayList<String> correct= new ArrayList<>();
		correct.add("Bye");
		correct.add("Crabs");
		correct.add("No");
		assertEquals(correct.toString(),tree.toArrayList().toString());
		
	}
	@Test
	void testSize() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.add("Yams");
		tree.add("Crabs");
		tree.add("Train");
		tree.add("No");
		
		
		
		assertEquals(7,tree.size());
	}
	
	@Test
	void testToArrayList() {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		tree.add("Hello");
		tree.add("Bye");
		tree.add("Apple");
		tree.add("Yams");
		tree.add("Crabs");
		tree.add("Train");
		
		ArrayList<String> correct= new ArrayList<>();
		correct.add("Apple");
		correct.add("Bye");
		correct.add("Crabs");
		correct.add("Hello");
		correct.add("Train");
		correct.add("Yams");
		assertEquals(correct.toString(),tree.toArrayList().toString());
		
	}

}
