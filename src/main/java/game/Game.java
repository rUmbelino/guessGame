package game;

import models.dataStructure.Node;
import models.game.Guess;
import models.message.FoodMessage;
import models.message.Message;
import models.userInterface.UserInterface;
import models.userInterface.console.Console;
import models.userInterface.swing.Swing;

public class Game extends GuessDecisionTree {
	private Node<Guess> root;

	public Game(Message message, UserInterface userInterface, Node<Guess> root) {
		super(message, userInterface);
		this.root = root;
	}

	public static Game buildConsoleFoodGame() {
		Guess cake = new Guess("bolo de chocolate", "feito de chocolate");
		Guess lasagna = new Guess("lasanha", "massa");

		Node<Guess> root = new Node<>(lasagna);
		Node<Guess> leftNode = new Node<>(cake);
		root.setLeft(leftNode);

		return new Game(new FoodMessage(), new Console(), root);
	}

	public static Game buildSwingFoodGame() {
		Guess cake = new Guess("bolo de chocolate", "feito de chocolate");
		Guess lasagna = new Guess("lasanha", "massa");

		Node<Guess> root = new Node<>(lasagna);
		Node<Guess> leftNode = new Node<>(cake);
		root.setLeft(leftNode);

		return new Game(new FoodMessage(), new Swing(), root);
	}

	public Node<Guess> getRoot() {
		return this.root;
	}

	public void start(boolean isInfinityGame) {
		do {
			this.userInterface.print(this.message.getGreeting());
			this.findGuess(this.root);
		} while (isInfinityGame);
	}

}
