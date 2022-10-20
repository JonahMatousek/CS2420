package assign06;

import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Stack<T>{
	private SinglyLinkedList<T> stack;
	
	LinkedListStack(){
		stack = new SinglyLinkedList<>();
	}

	@Override
	public void clear() {
		stack.clear();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
		
	}

	@Override
	public T peek() throws NoSuchElementException {
		if(stack.size()==0)
			throw new NoSuchElementException();
		return stack.getFirst();
	}

	@Override
	public T pop() throws NoSuchElementException {
		if(stack.size()==0)
			throw new NoSuchElementException();
		T out = stack.getFirst();
		stack.deleteFirst();
		return out;
	}

	@Override
	public void push(T element) {
		stack.insertFirst(element);
		
	}

	@Override
	public int size() {
		
		return stack.size();
		
	}
	public Object[] toArray() {
		return stack.toArray();
	}

}
