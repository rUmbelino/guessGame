package models.message;

import models.game.Guess;

public class FoodMessage implements Message{

	@Override
	public String getGreeting() {
		return "Pense em um prato que gosta";
	}

	@Override
	public String getHunch(Guess item) {
		return  String.format("O prato que pensou é %s?", item.getCharachteristic());
	}
	
	@Override
	public String getGuess(Guess item) {
		return  String.format("O prato que pensou é %s?", item.getName());
	}

	@Override
	public String getHit() {
		return "Acertei denovo";
	}

	@Override
	public String getMissName() {
		return "Qual o prato que pensou?";
	}

	@Override
	public String getMissCharacteristic(Guess itemA, Guess itemB) {
		return String.format("%s é ____ mas %s não.", itemA.getName(), itemB.getName());
	}


}
