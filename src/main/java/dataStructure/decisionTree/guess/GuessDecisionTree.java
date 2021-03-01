package dataStructure.decisionTree.guess;

import dataStructure.decisionTree.DecisionTree;
import dataStructure.decisionTree.Direction;
import dataStructure.node.Node;
import models.game.Guess;

public abstract class GuessDecisionTree extends DecisionTree<Guess> {

	public GuessDecisionTree(Node<Guess> root) {
		super(root);
	}

	public abstract boolean validateHunchCharacteristic(Guess value);

	public abstract boolean validateHunchName(Guess value);

	public abstract void showWinMessage();

	public abstract String getUserGuessName();

	public abstract String getUserGuessCharacteristic(Guess lastGuess, Guess userGuess);

	public Direction assertDirection(Guess value) {
		if (!this.validateHunchCharacteristic(value)) {
			return Direction.LEFT;
		}

		if (this.validateHunchName(value)) {
			this.showWinMessage();
			return Direction.STOP;
		}

		return Direction.RIGHT;
	}

	public Guess generateUserValue(Guess lastGuess) {
		String name = this.getUserGuessName();
		Guess userGuess = new Guess();
		userGuess.setName(name);

		String characteristic = this.getUserGuessCharacteristic(lastGuess, userGuess);
		userGuess.setCharachteristic(characteristic);

		return userGuess;
	}

}
