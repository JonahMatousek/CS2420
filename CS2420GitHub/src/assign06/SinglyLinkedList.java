package assign06;

import java.util.Iterator;

import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

/**
 * @author Casey Parker and Jonah Matousek
 * @version October 19, 2022
 * 
 * @param <T> - the type of elements contained in the stack
 */

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

	/**
	 * Inserts an element at the beginning of the list. O(1) for a singly-linked
	 * list.
	 * 
	 * @param element - the element to add
	 */
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

	/**
	 * Inserts an element at a specific position in the list. O(N) for a
	 * singly-linked list.
	 * 
	 * @param index   - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index > size())
	 */
	@Override
	public void insert(int index, T element) throws IndexOutOfBoundsException {
		if (length < index || index < 0)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			this.insertFirst(element);
		LinkedNode newNode = new LinkedNode(element);
		LinkedNode temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.nextID;
		}
		newNode.nextID = temp.nextID;
		temp.nextID = newNode;

		length++;

	}

	/**
	 * Gets the first element in the list. O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public T getFirst() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		} else
			return head.val;
	}

	/**
	 * Gets the element at a specific position in the list. O(N) for a singly-linked
	 * list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
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

	/**
	 * Deletes and returns the first element from the list. O(1) for a singly-linked
	 * list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public T deleteFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException();
		}
		T out = head.val;

		head = head.nextID;
		length--;
		return out;
	}

	/**
	 * Deletes and returns the element at a specific position in the list. O(N) for
	 * a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		if (length <= index || index < 0)
			throw new IndexOutOfBoundsException();
		LinkedNode temp = head;

		T out = null;
		for (int i = 0; i < index; i++) {
			temp = temp.nextID;
			out = temp.val;
		}
		temp.nextID = temp;

		length--;
		return out;
	}

	/**
	 * Determines the index of the first occurrence of the specified element in the
	 * list, or -1 if this list does not contain the element. O(N) for a
	 * singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
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

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return length;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (length == 0)
			return true;
		else
			return false;
	}

	/**
	 * Removes all of the elements from this list. O(1) for a singly-linked list.
	 */
	@Override
	public void clear() {
		head = null;
		length = 0;

	}

	/**
	 * Generates an array containing all of the elements in this list in proper
	 * sequence (from first element to last element). O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
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

	/**
	 * @return an iterator over the elements in this list in proper sequence (from
	 *         first element to last element)
	 */
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
			if (lastNode != null)
				previousLastNode = lastNode;
			if (currentNode.nextID == null) {
				throw new NoSuchElementException();
			}
			T out = currentNode.val;
			lastNode = currentNode;
			currentNode = currentNode.nextID;

			return out;

		}

		public void remove() {

			if (lastNode == null || removeCalled == true) {
				throw new IllegalStateException();
			} else if (previousLastNode == null) {
				head = currentNode;

			} else {
				previousLastNode.nextID = currentNode;

			}
			removeCalled = true;
			length--;

		}

	}

}
