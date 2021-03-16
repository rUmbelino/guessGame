package com.rumbelino.game;

import com.rumbelino.dataStructure.decisionTree.guess.GuessDecisionTree;
import com.rumbelino.dataStructure.node.Node;
import com.rumbelino.models.game.Guess;
import com.rumbelino.models.message.FoodMessage;
import com.rumbelino.models.message.Message;
import com.rumbelino.models.userInterface.UserInterface;
import com.rumbelino.models.userInterface.console.Console;
import com.rumbelino.models.userInterface.swing.Swing;

public class Game extends GuessDecisionTree {
	private Message message;
	private UserInterface userInterface;

	public Game(Message message, UserInterface userInterface, Node<Guess> root) {
		super(root);

		this.message = message;
		this.userInterface = userInterface;
	}

	public static Game buildConsoleFoodGame() {
		return new Game(new FoodMessage(), new Console(), Game.getDefaultRoot());
	}

	public static Game buildSwingFoodGame() {
		return new Game(new FoodMessage(), new Swing(), Game.getDefaultRoot());
	}

	private static Node<Guess> getDefaultRoot() {
		Guess cake = new Guess("bolo de chocolate", "feito de chocolate");
		Guess lasagna = new Guess("lasanha", "massa");

		Node<Guess> root = new Node<>(lasagna);
		Node<Guess> leftNode = new Node<>(cake);
		root.setLeft(leftNode);

		return root;
	}

	public void start(boolean isInfinityGame) {
		do {
			this.userInterface.print(this.message.getInstructions());
			this.findNodeByAssertDirection();
		} while (isInfinityGame);
	}

	@Override
	public boolean validateHunchCharacteristic(Guess value) {
		String message = this.message.getHunchCharacteristic(value);
		return this.userInterface.validate(message);
	}

	@Override
	public boolean validateHunchName(Guess value) {
		String message = this.message.getHunchName(value);
		return this.userInterface.validate(message);
	}

	@Override
	public void showWinMessage() {
		String message = this.message.getWinMessage();
		this.userInterface.print(message);
	}

	@Override
	public String getUserGuessName() {
		String message = this.message.getRegisterGuessName();
		String userGuessName = this.userInterface.read(message);
		return userGuessName;
	}

	@Override
	public String getUserGuessCharacteristic(Guess lastGuess, Guess userGuess) {
		String message = this.message.getRegisterGuessCharacteristic(lastGuess, userGuess);
		String userGuessCharacteristic = this.userInterface.read(message);
		return userGuessCharacteristic;
	}

}
