package game.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

	private Game buildMockGame(Map<String, Boolean> validateAwnsers) {
		Node<Guess> root = new Node<>(this.lasagna);
		Node<Guess> leftNode = new Node<>(this.cake);
		root.setLeft(leftNode);

		return new Game(this.foodMessage, new Mock(validateAwnsers), root);
	}

	@Test
	public void shouldHaveACorrectMockGameWithouInserting() {
		Map<String, Boolean> validateAwnsers = new HashMap<>();
		validateAwnsers.put(this.foodMessage.getHunch(this.lasagna), true);
		validateAwnsers.put(this.foodMessage.getGuess(this.lasagna), true);

		Game game = this.buildMockGame(validateAwnsers);

		game.start(false);

		Node<Guess> rootNode = game.getRoot();

		assertNotNull(rootNode.getValue());
		assertNotNull(rootNode.getLeft());
		assertEquals(rootNode.getRight(), null);
	}

	@Test
	public void shouldHaveACorrectMockGameInsertingInRight() {
		Map<String, Boolean> awnsers = new HashMap<>();

		awnsers.put(this.foodMessage.getHunch(this.lasagna), false);
		awnsers.put(this.foodMessage.getHunch(this.cake), false);

		Game game = this.buildMockGame(awnsers);

		game.start(false);

		Node<Guess> rootNode = game.getRoot();

		assertNull(rootNode.getRight());
		assertNotNull(rootNode.getValue());
		assertNotNull(rootNode.getLeft());
		assertNotNull(rootNode.getLeft().getLeft());
	}

	@Test
	public void shouldProperlyBuildConsoleGame() {
		Game game = Game.buildConsoleFoodGame();

		Node<Guess> rootNode = game.getRoot();

		assertNotNull(rootNode.getValue());
		assertNotNull(rootNode.getLeft());
		assertEquals(rootNode.getRight(), null);
	}
}
