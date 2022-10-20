package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListStackTest {

	@Test
	void testClear() {
		LinkedListStack<String> stack = new LinkedListStack<>();
		stack.push("Hello");
		stack.push("Bye");
		stack.clear();
		assertEquals(stack.size(),0);
	}

}
