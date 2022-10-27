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

	class TreeNode {
		private T val;
		private TreeNode leftChild;
		private TreeNode rightChild;
		

		TreeNode(T val) {
			this.val = val;
			leftChild = null;
			rightChild = null;

		}

	}

	private TreeNode root;
	private ArrayList<T> listTree;

	private int size;

	BinarySearchTree() {

		root = null;
		size = 0;
		listTree = new ArrayList<>();
	}

	@Override
	public boolean add(T item) {
		//if (this.contains(item))
			//return false;
		root = add(root, item);
		size++;
		return true;
	}

	private TreeNode add(TreeNode root, T item) {
		if (root == null)
			return new TreeNode(item);

		else if (item.compareTo(root.val) < 0)
			root.leftChild = add(root.leftChild, item);
		else if (item.compareTo(root.val) > 0)
			root.rightChild = add(root.rightChild, item);

		return root;
	}

	@Override
	public boolean addAll(Collection<? extends T> items) {
		for (T item : items) {
			add(item);
		}
		return true;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public boolean contains(T item) {
		if(this.root.val.compareTo(item) == 0)
			return true;
		return contains(root,item);
		
	}
	
	private boolean contains(TreeNode root, T item) {
		if (root == null)
			return false;
		else if(root.val.compareTo(item)==0)
			return true;
		else if (root.val.compareTo(item) > 0)
			return contains(root.leftChild,item);
		else
			return contains(root.rightChild,item);
	}

	@Override
	public boolean containsAll(Collection<? extends T> items) {
		
		for(T item:items) {
			if(this.contains(item)==false)
				return false;
	
		}
		return true;
	}

	@Override
	public T first() throws NoSuchElementException {
		if (root == null)
			throw new NoSuchElementException();
		else
			return first(root);
	}
	private T first(TreeNode root) {
		if(root.leftChild != null)
			return first(root.leftChild);
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
		if (root == null)
			throw new NoSuchElementException();
		else
			return last(root);
	}

	public T last(TreeNode root) {
		if (root.rightChild != null)
			return last(root.rightChild);
		else
			return root.val;

	}

	@Override
	public boolean remove(T item) {
		TreeNode out = remove(root,item);
		size--;
		if(out==null)
			return false;
		else
			return true;
		
	}
	
	private TreeNode remove(TreeNode root,T item) {
		if(root == null)
			return root;
		
		else if(root.val.compareTo(item) > 0) {
			root.leftChild = remove(root.leftChild,item);
		}else if(root.val.compareTo(item) < 0)
			root.rightChild = remove(root.rightChild,item);
		else {
			if(root.leftChild == null)
				return root.rightChild;
			else if(root.rightChild == null)
				return root.leftChild;
			root.val = first(root.rightChild);
		
		
			root.rightChild = remove(root.rightChild,root.val);
		}
		return root;
			
		
	}
	
	@Override
	public boolean removeAll(Collection<? extends T> items) {
		
		for(T item:items) {
			if (remove(item) == false)
				return false;
		}
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<T> toArrayList() {
		listTree = new ArrayList<>();
		return toArrayList(root);
	}

	public ArrayList<T> toArrayList(TreeNode head) {
		//ArrayList<T> sortedTreeList = new ArrayList<T>();
		
		if (head != null) {
			toArrayList(head.leftChild);
			//System.out.println(head.val);
			listTree.add(head.val);
			toArrayList(head.rightChild);
		}
			
		
			
			return listTree;
		
		
	}

}
