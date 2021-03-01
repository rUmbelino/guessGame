package models.dataStructure.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dataStructure.node.Node;
import models.dataStructure.*;

public class NodeTest {

	@Test
	public void shouldGenerateStringNode() {
		Node<String> node = new Node<>("Rafael");

		assertEquals("Rafael", node.getValue());
		assertEquals(null, node.getLeft());
		assertEquals(null, node.getRight());
	}

	@Test
	public void shouldPoulateNodeWithSetters() {
		Node<String> node = new Node<>("Rafael");

		Node<String> leftNode = new Node<>("Josiel");
		Node<String> rightNode = new Node<>("Josiel");

		node.setLeft(leftNode);
		node.setRight(rightNode);

		assertEquals(leftNode, node.getLeft());
		assertEquals(rightNode, node.getRight());
	}
}
