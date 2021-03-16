package models.message.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.rumbelino.models.game.Guess;
import com.rumbelino.models.message.FoodMessage;

public class FoodMessageTest {

	@Test
	public void shouldHaveProperGreeting() {
		FoodMessage foodMessage = new FoodMessage();
		String greeting = "Pense em um prato que gosta";

		assertEquals(greeting, foodMessage.getInstructions());
	}

	@Test
	public void shouldHaveProperHunch() {
		FoodMessage foodMessage = new FoodMessage();
		Guess bolo = new Guess("bolo", "chocolate");
		String hunch = String.format("O prato que pensou é %s?", bolo.getCharachteristic());

		assertEquals(hunch, foodMessage.getHunchCharacteristic(bolo));
	}
	
	@Test
	public void shouldHaveProperGuess() {
		FoodMessage foodMessage = new FoodMessage();
		Guess bolo = new Guess("bolo", "chocolate");
		String guess = String.format("O prato que pensou é %s?", bolo.getName());
		
		assertEquals(guess, foodMessage.getHunchName(bolo));
	}
	
	@Test
	public void shouldHaveProperHit() {
		FoodMessage foodMessage = new FoodMessage();
		String hit = "Acertei denovo";
		
		assertEquals(hit, foodMessage.getWinMessage());
	}
	
	@Test
	public void shouldHaveProperMissName() {
		FoodMessage foodMessage = new FoodMessage();
		String missName = "Qual o prato que pensou?";
		
		assertEquals(missName, foodMessage.getRegisterGuessName());
	}
	
	@Test
	public void shouldHaveProperMissCharacteristic() {
		FoodMessage foodMessage = new FoodMessage();
		Guess bolo = new Guess("bolo", "chocolate");
		Guess banana = new Guess("banana", "fruta");
		
		String characteristic = "banana é ____ mas bolo não.";
		
		assertEquals(characteristic, foodMessage.getRegisterGuessCharacteristic(bolo, banana));
	}
}
