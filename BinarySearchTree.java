package binaryToMaxHeap;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
	BTNode<T> root,MaxHeapRoot;
	int size;
	ArrayList<T> arr = new ArrayList<T>();

	public BinarySearchTree() {
		root = MaxHeapRoot=null;
		size = 0;
	}

	public boolean isEmpty(BTNode<T> root) {
		return root == null;
	}

	public BTNode<T> addRecursive(BTNode<T> root, T key) {
		if (isEmpty(root)) {
			root = new BTNode<T>(key);
		} else {
			if (compareTwoValues(root.data, key)) {
				root.left = addRecursive(root.left, key);
			} else if (compareTwoValues(key, root.data)) {
				root.right = addRecursive(root.right, key);
			} else {
				return null;
			}
		}
		return root;
	}

	public void Add(BTNode<T> root, T key) {
		root = addRecursive(root, key);
	}

	public BTNode<T> deleteRecursive(BTNode<T> root, T key) {

		if (isEmpty(root)) {
			return null;
		}
		if (compareTwoValues(root.data, key)) {
			root.left = addRecursive(root.left, key);
		} else if (compareTwoValues(key, root.data)) {
			root.right = addRecursive(root.right, key);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.right != null) {
				root.data = FindingRightSmallest(root);
				root.right = deleteRecursive(root.right, root.data);
			} else {
				root.data = FindingLeftBiggest(root);
				root.left = deleteRecursive(root.left, root.data);
			}
		}
		return root;
	}
	
	  public void Delete(BTNode<T>root,T key) {
		  root=deleteRecursive(root,key);
	  }

	public void Inorder_Traversal(BTNode<T> root) {
		if (isEmpty(root)) {
			return;
		} else {
			Inorder_Traversal(root.left);
			arr.add((T) root.data);
			Inorder_Traversal(root.right);
		}
	}

	public BTNode Maxheap(BTNode<T> maxHeapRoot, T key) {
		if(isEmpty(maxHeapRoot)) {
			maxHeapRoot= new BTNode(key);
		}
		else {
			if(maxHeapRoot.left!=null) {
				maxHeapRoot.left=Maxheap(maxHeapRoot.left,key);
			}
			else if(maxHeapRoot.right!=null) {
				maxHeapRoot.right=Maxheap(maxHeapRoot.right,key);
			}
		}
		return maxHeapRoot;
	}
	
	public T FindingRightSmallest(BTNode<T> root) {
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		T object = (T) root;
		return object;
	}

	public T FindingLeftBiggest(BTNode<T> root) {
		root = root.left;
		while (root.right != null) {
			root = root.right;
		}
		T object = (T) root;
		return object;
	}

	public boolean compareTwoValues(T V1, T V2) {
		return V1.compareTo(V2) > 0;
	}
}
