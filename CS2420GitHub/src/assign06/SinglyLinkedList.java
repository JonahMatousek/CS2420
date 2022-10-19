package assign06;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List<T> {

	private LinkedNode head;
	private int length;

	public SinglyLinkedList() {
		this.head = null;
		length = 0;
	}

	class LinkedNode {

		private T val;
		private LinkedNode nextID;

		LinkedNode(T val) {
			this.val = val;
			nextID = null;
		}

	}

	@Override
	public void insertFirst(T element) {
		LinkedNode newNode = new LinkedNode(element);

		if (this.head == null) {
			head = newNode;
		} else {

			if (head != null) {
				newNode.nextID = head;
				head = newNode;

			}

		}

		length++;

	}

	@Override
	public void insert(int index, T element) throws IndexOutOfBoundsException {
		if (length < index || index < 0)
			throw new IndexOutOfBoundsException();
		LinkedNode newNode = new LinkedNode(element);
		LinkedNode temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.nextID;
		}
		newNode.nextID = temp.nextID;
		temp.nextID = newNode;

		length++;

	}

	@Override
	public T getFirst() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		} else
			return head.val;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (length < index || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		LinkedNode temp = head;
		T out = null;

		for (int i = 0; i < index; i++) {

			temp = temp.nextID;
			out = temp.val;
		}

		return out;

	}

	@Override
	public T deleteFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException();
		}
		T out = head.val;

		head.nextID = head;
		length--;
		return out;
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		if (length <= index || index < 0)
			throw new IndexOutOfBoundsException();
		LinkedNode temp = head;
		
		T out = null;
		for(int i=0;i<index;i++) {
			temp = temp.nextID;
			out = temp.val;
		}
		temp.nextID = temp;
		
		length--;
		return out;
	}

	@Override
	public int indexOf(T element) {
		LinkedNode temp = head;
		int index = 0;
		while (temp.val != element) {
			
			temp = temp.nextID;
			index++;
			
		}
		if (temp.val == element)
			return index;
		
		
		return -1;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		if (length == 0)
			return true;
		else
			return false;
	}

	@Override
	public void clear() {
		head = null;
		length = 0;

	}

	@Override
	public Object[] toArray() {
		Object[] listArray = new Object[length];
		LinkedNode temp = head;
		int index = 0;
		while (temp != null && index < length) {
			listArray[index] = temp.val;
			temp = temp.nextID;
			index++;
		}
		return listArray;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	public class ListIterator implements Iterator<T> {

		LinkedNode currentNode;
		LinkedNode lastNode;
		LinkedNode previousLastNode;
		boolean removeCalled;

		public ListIterator() {
			currentNode = head;
			lastNode = null;
			previousLastNode = null;
			removeCalled = false;
			
		}

		public boolean hasNext() {
			if (currentNode.nextID == null)
				return false;
			else
				return true;
		}

		public T next() {
			if(lastNode != null)
				previousLastNode = lastNode;
			if (currentNode.nextID == null) {
				throw new NoSuchElementException();
			}
			T out = currentNode.val;
			lastNode = currentNode;
			currentNode = currentNode.nextID;
			
			
			return out;

		}

		public void remove()  {
			
			if (lastNode == null || removeCalled == true) {
				throw new IllegalStateException();
			}
			else if(previousLastNode == null) {
				head = currentNode;
				
			}else {
				previousLastNode.nextID = currentNode;
			
			}
			removeCalled = true;
			length--;
			
			
			
			
		}

	}

}
