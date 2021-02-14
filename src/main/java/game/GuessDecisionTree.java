package game;

import models.dataStructure.Node;
import models.game.Guess;
import models.message.Message;
import models.userInterface.UserInterface;

public abstract class GuessDecisionTree {
	
	protected Message message;
	protected UserInterface userInterface;

	public GuessDecisionTree(Message message, UserInterface userInterface) {
		this.message = message;
		this.userInterface = userInterface;
	}

	public void findGuess(Node<Guess> currentNode) {
		this.userInterface.print(this.message.getGreeting());

		Guess guess = currentNode.getValue();

		String hunchMessage = this.message.getHunch(guess);
		Boolean isCorrectHunch = this.userInterface.validate(hunchMessage);

		if (!isCorrectHunch) {
			this.validateStopCondition(currentNode, isCorrectHunch);
			return;
		}

		String guessMessage = this.message.getGuess(guess);
		Boolean hasDiscovered = this.userInterface.validate(guessMessage);

		if (hasDiscovered) {
			this.showSuccessMessage();
		} else {
			this.validateStopCondition(currentNode, isCorrectHunch);
		}
	}

	private void validateStopCondition(Node<Guess> node, Boolean isCorrectHunch) {
		try {
			Node<Guess> nextNode = isCorrectHunch ? node.getRight() : node.getLeft();
			this.findGuess(nextNode);
		} catch (Exception e) {
			Node<Guess> userNode = this.askAwnser(node);

			if (isCorrectHunch) {
				node.setRight(userNode);
			} else {
				node.setLeft(userNode);
			}
		}

	}

	private Node<Guess> askAwnser(Node<Guess> node) {
		Guess userGuess = new Guess();

		String name = this.userInterface.read(this.message.getMissName());
		userGuess.setName(name);

		String missCharachteristic = this.message.getMissCharacteristic(userGuess, node.getValue());
		String characteristic = this.userInterface.read(missCharachteristic);
		userGuess.setCharachteristic(characteristic);

		Node<Guess> userNode = new Node<>(userGuess);

		return userNode;
	}

	private void showSuccessMessage() {
		String successMessage = this.message.getHit();
		this.userInterface.print(successMessage);
	}
}
