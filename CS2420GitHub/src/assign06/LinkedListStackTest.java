package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;


import org.junit.jupiter.api.Test;

/**
 * @author Casey Parker and Jonah Matousek
 * @version October 19, 2022
 */

class LinkedListStackTest {

	@Test
	void testClear() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		stack.push("Hello");
		stack.push("Bye");
		stack.clear();
		assertEquals(stack.size(), 0);
	}

	@Test
	void testIsEmpty() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		stack.push("hello");
		stack.clear();
		assertTrue(stack.isEmpty());
	}

	@Test
	void testPeek() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		stack.push("hello");
		stack.push("Bye");
		assertEquals("Bye", stack.peek());
	}

	@Test
	void testPush() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		stack.push("Hello");
		stack.push("Bye");
		//System.out.println(Arrays.toString(stack.toArray()));
		String[] correct = new String[] { "Bye", "Hello" };
		assertTrue(Arrays.equals(stack.toArray(), correct));
	}

	@Test
	void testPop() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		stack.push("Hello");
		stack.push("Bye");
		String correct = stack.pop();
		assertEquals(correct, "Bye");
		String[] arr = new String[] {"Hello"};
		assertTrue(Arrays.equals(arr, stack.toArray()));
		//System.out.println(Arrays.toString(stack.toArray()));
	}

	@Test
	void testSize() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		stack.push("Hello");
		stack.push("Bye");
		assertEquals(2, stack.size());
	}
	
	@Test
	void testPeekExecption() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		assertThrows(NoSuchElementException.class,()-> stack.peek());
	}
	
	@Test
	void testPopExecption() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		assertThrows(NoSuchElementException.class,()-> stack.pop());
	}

}
