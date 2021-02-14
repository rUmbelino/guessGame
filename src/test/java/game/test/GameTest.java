package game.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import game.Game;
import models.dataStructure.Node;
import models.game.Guess;
import models.message.FoodMessage;
import models.userInterface.mock.Mock;

public class GameTest {
	private FoodMessage foodMessage = new FoodMessage();
	private Guess cake = new Guess("bolo de chocolate", "feito de chocolate");
	private Guess lasagna = new Guess("lasanha", "massa");
	private Guess pizza = new Guess("pizza", "italiano");

	private Game buildMockGame(Map<String, Boolean> validateAwnsers) {
		Node<Guess> root = new Node<>(this.lasagna);
		Node<Guess> leftNode = new Node<>(this.cake);
		root.setLeft(leftNode);

		return new Game(this.foodMessage, new Mock(validateAwnsers), root);
	}

	private Game buildMockGame(Map<String, Boolean> validateAwnsers, Map<String, String> readAwnsers) {
		Node<Guess> root = new Node<>(this.lasagna);
		Node<Guess> leftNode = new Node<>(this.cake);
		root.setLeft(leftNode);

		return new Game(this.foodMessage, new Mock(validateAwnsers, readAwnsers), root);
	}

	@Test
	public void shouldHaveACorrectMockGameWithouInserting() {
		Map<String, Boolean> validateAwnsers = new HashMap<>();
		validateAwnsers.put(this.foodMessage.getHunch(this.lasagna), true);
		validateAwnsers.put(this.foodMessage.getGuess(this.lasagna), true);

		Game game = this.buildMockGame(validateAwnsers);

		game.start(false);

		Node<Guess> rootNode = game.getRoot();

		assertEquals(rootNode.getRight(), null);
		assertEquals(rootNode.getLeft().getLeft(), null);
		assertEquals(rootNode.getLeft().getRight(), null);
	}

	@Test
	public void shouldHaveACorrectMockGameInsertingInRight() {
		Map<String, Boolean> validateAwnsers = new HashMap<>();
		validateAwnsers.put(this.foodMessage.getHunch(this.lasagna), true);
		validateAwnsers.put(this.foodMessage.getGuess(this.lasagna), false);

		Map<String, String> readAwnsers = new HashMap<>();
		readAwnsers.put(this.foodMessage.getMissName(), this.pizza.getName());
		readAwnsers.put(this.foodMessage.getMissCharacteristic(this.pizza, this.lasagna),
				this.pizza.getCharachteristic());

		Game game = this.buildMockGame(validateAwnsers, readAwnsers);

		game.start(false);

		Node<Guess> rootNode = game.getRoot();

		Guess inserted =rootNode.getRight().getValue();
		
		assertEquals(inserted.getName(), this.pizza.getName());
		assertEquals(inserted.getCharachteristic(), this.pizza.getCharachteristic());
	}

	@Test
	public void shouldProperlyBuildConsoleGame() {
		Game game = Game.buildConsoleFoodGame();

		Node<Guess> rootNode = game.getRoot();

		assertNotNull(rootNode.getValue());
		assertNotNull(rootNode.getLeft());
		assertEquals(rootNode.getRight(), null);
	}

	@Test
	public void shouldProperlyBuildSwingGame() {
		Game game = Game.buildSwingFoodGame();

		Node<Guess> rootNode = game.getRoot();

		assertNotNull(rootNode.getValue());
		assertNotNull(rootNode.getLeft());
		assertEquals(rootNode.getRight(), null);
	}
}
