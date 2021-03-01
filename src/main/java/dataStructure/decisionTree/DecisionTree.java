package dataStructure.decisionTree;

import dataStructure.node.Node;

public abstract class DecisionTree<T> {
	private Node<T> root;

	public DecisionTree(Node<T> root) {
		this.setRoot(root);
	}

	public abstract Direction assertDirection(T value);

	public abstract T generateUserValue(T lastValue);

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public void findNodeByAssertDirection() {
		this.findNode(this.root);
	}

	private Node<T> findNode(Node<T> node) {
		Direction direction = this.assertDirection(node.getValue());

		if (Direction.isStopDirection(direction)) {
			return node;
		}

		Node<T> nextNode = this.getNodeAtDirection(node, direction);

		if (nextNode == null) {
			this.addNode(node, direction);
			return null;
		}

		return this.findNode(nextNode);
	}

	private Node<T> getNodeAtDirection(Node<T> node, Direction direction) {
		if (Direction.isRightDirection(direction)) {
			return node.getRight();
		}

		return node.getLeft();
	}

	private void addNode(Node<T> lastNode, Direction lastDirection) {
		T userValue = this.generateUserValue(lastNode.getValue());

		Node<T> userNode = new Node<T>(userValue);
		this.setNodeAtDirection(lastNode, userNode, lastDirection);
	}

	private void setNodeAtDirection(Node<T> lastNode, Node<T> userNode, Direction direction) {
		if (Direction.isRightDirection(direction)) {
			lastNode.setRight(userNode);
		}

		lastNode.setLeft(userNode);

	}

}
