package assign06;

import java.util.NoSuchElementException;

/**
 * @author Casey Parker and Jonah Matousek
 * @version October 19, 2022
 * 
 * @param <T> - the type of elements contained in the stack
 */
public class LinkedListStack<T> implements Stack<T> {
	private SinglyLinkedList<T> stack;

	LinkedListStack() {
		stack = new SinglyLinkedList<>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	@Override
	public void clear() {
		stack.clear();
	}

	/**
	 * @return true if the stack contains no elements; false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();

	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public T peek() throws NoSuchElementException {
		if (stack.size() == 0)
			throw new NoSuchElementException();
		return stack.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public T pop() throws NoSuchElementException {
		if (stack.size() == 0)
			throw new NoSuchElementException();
		T out = stack.getFirst();
		stack.deleteFirst();
		return out;
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(T element) {
		stack.insertFirst(element);

	}

	/**
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {

		return stack.size();

	}

	/**
	 * @return the list as an object array
	 */
	public Object[] toArray() {
		return stack.toArray();
	}

}
