package dataStructure.decisionTree;

import dataStructure.node.Node;

public class FindNodeException extends Exception {

	private static final long serialVersionUID = -3776417844450344141L;
	private Node<Object> lastNode;
	private Direction lastDirection;

	public FindNodeException(String message, Node<Object> lastNode, Direction lastDirection) {
		super(message);

		this.lastNode = lastNode;
		this.lastDirection = lastDirection;
	}

	public Node<Object> getLastNode() {
		return lastNode;
	}

	public Direction getLastDirection() {
		return lastDirection;
	}
}