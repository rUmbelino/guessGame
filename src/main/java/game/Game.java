package game;

import models.dataStructure.Node;
import models.game.Guess;
import models.message.FoodMessage;
import models.message.Message;
import models.userInterface.UserInterface;
import models.userInterface.console.Console;

public class Game {
	private Message message;
	private Node<Guess> root;
	private UserInterface userInterface;

	public Game(Message message, UserInterface userInterface, Node<Guess> root) {
		this.root = root;
		this.message = message;
		this.userInterface = userInterface;
	}

	public static Game buildConsoleFoodGame() {
		Guess cake = new Guess("bolo de chocolate", "feito de chocolate");
		Guess lasagna = new Guess("lasanha", "massa");

		Node<Guess> root = new Node<>(lasagna);
		Node<Guess> leftNode = new Node<>(cake);
		root.setLeft(leftNode);

		return new Game(new FoodMessage(), new Console(), root);
	}

	public Node<Guess> getRoot() {
		return this.root;
	}

	public void start(Boolean isInfinity) {
		do {
			this.userInterface.print(this.message.getGreeting());

			this.findGuess(this.root);
		} while (isInfinity);
	}

	private void findGuess(Node<Guess> currentNode) {
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
			Node<Guess> nextNode = isCorrectHunch ? node.getLeft() : node.getRight();
			this.findGuess(nextNode);
		} catch (Exception e) {
			Node<Guess> userNode = this.askAwnser(node);

			if (isCorrectHunch) {
				node.setLeft(userNode);
			} else {
				node.setRight(userNode);
			}
		}

	}

	private Node<Guess> askAwnser(Node<Guess> node) {
		Guess userGuess = new Guess();

		this.userInterface.print(this.message.getMissName());
		String name = this.userInterface.read();
		userGuess.setName(name);

		this.userInterface.print(this.message.getMissCharacteristic(userGuess, node.getValue()));
		String characteristic = this.userInterface.read();
		userGuess.setCharachteristic(characteristic);

		Node<Guess> userNode = new Node<>(userGuess);

		return userNode;
	}

	private void showSuccessMessage() {
		String successMessage = this.message.getHit();
		this.userInterface.print(successMessage);
	}

}
