package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * @author Casey Parker
 *
 * @param <Type>
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> {


private TreeNode root;
private int height;
private int size;
	
	BinarySearchTree(){
		
		root = null;
		height = 0;
		size = 0;
	}
	
	class TreeNode {
		private T val;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private BinarySearchTree subTree;
		private int depth;
		
		TreeNode(T val){
			this.val = val;
			leftChild = null;
			rightChild = null;
			subTree = null;
			depth = 0;
		}
	}
	@Override
	public boolean add(T item) {
		if(root == null)
			root.val = item;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		root = null;
		
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T first() throws NoSuchElementException {
		if(root == null)
			throw new NoSuchElementException();
		else
			return root.val;
	}

	@Override
	public boolean isEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}

	@Override
	public T last() throws NoSuchElementException {
		
		return null;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public ArrayList<T> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
