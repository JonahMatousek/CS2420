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
		return stack.get(stack.size());
	}

	@Override
	public T pop() throws NoSuchElementException {
		if(stack.size()==0)
			throw new NoSuchElementException();
		T out = stack.get(stack.size());
		stack.delete(stack.size());
		return out;
	}

	@Override
	public void push(T element) {
		stack.insert(stack.size(), element);
		
	}

	@Override
	public int size() {
		
		return stack.size();
		
	}

}
