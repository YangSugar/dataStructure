package com.yang;

import java.util.Comparator;

import com.yang.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo  {
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;

	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		
	}

	public void add(E element) {
		elementNotNullCheck(element);
	
		if (root == null) {
			root = new Node<E>(element, null);
			size++;
			return;
		}

		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		
		while (node != null) {
			cmp = compareE(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else {
				node.element = element;
				return;
			}
		}
		
		//node就是父类
		Node<E> newNode = new Node<E>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		} 
		size++;
	}

	public void remove(E element) {
		
	}

	public boolean contains(E element) {
		return false;
	}
	
	public void preOrderTraversal() {
		find(root);
	}
	
	private void find(Node<E> node) {
		if (node == null) return;
		
		System.out.println(node.element);
		find(node.left);
		find(node.right);
	}

	
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	// 等于0，e1=e2, 大于0 e1>e2, 小于0，e1<e2 
	private int compareE(E e1, E e2) {
		if (comparator != null) {
			return this.comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
	}


	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object left(Object node) {
		return((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>)(node);
		String parentStr = "null";
		if (myNode.parent != null) {
			parentStr = myNode.parent.element.toString();
		}
		return myNode.element + "_" + parentStr;
	}
	
	
	
}
