package models.message;

import models.game.Guess;

public class FoodMessage implements Message{

	@Override
	public String getInstructions() {
		return "Pense em um prato que gosta";
	}

	@Override
	public String getHunchCharacteristic(Guess item) {
		return  String.format("O prato que pensou é %s?", item.getCharachteristic());
	}
	
	@Override
	public String getHunchName(Guess item) {
		return  String.format("O prato que pensou é %s?", item.getName());
	}

	@Override
	public String getWinMessage() {
		return "Acertei denovo";
	}

	@Override
	public String getRegisterGuessName() {
		return "Qual o prato que pensou?";
	}

	@Override
	public String getRegisterGuessCharacteristic(Guess lastGuess, Guess userGuess) {
		return String.format("%s é ____ mas %s não.", userGuess.getName(), lastGuess.getName());
	}

}
