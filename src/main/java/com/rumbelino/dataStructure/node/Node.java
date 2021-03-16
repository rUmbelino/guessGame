package com.rumbelino.dataStructure.node;

public class Node<E> {
	private E value;
	private Node<E> left;
	private Node<E> right;

	public Node(E value) {
		this.value = value;
		this.right = null;
		this.left = null;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}

}
