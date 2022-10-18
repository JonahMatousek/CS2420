package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List<T>{
	
	private LinkedNode head;
	private int length;
	
	public SinglyLinkedList() {
		this.head = null;
		length = 0;
	}
	
	class LinkedNode{
		
		private T val;
		private LinkedNode nextID;
		LinkedNode(){
			val = null;
			nextID = null;
		}
		
	}
	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(int index,T  element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T deleteFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
