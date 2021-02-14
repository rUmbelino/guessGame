package models.message;

import models.game.Guess;

public class FoodMessage implements Message{

	@Override
	public String getGreeting() {
		return "Pense em um prato que gosta";
	}

	@Override
	public String getHunch(Guess item) {
		return  String.format("O prato que pensou � %s?", item.getCharachteristic());
	}
	
	@Override
	public String getGuess(Guess item) {
		return  String.format("O prato que pensou � %s?", item.getName());
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
		return String.format("%s � ____ mas %s n�o.", itemA.getName(), itemB.getName());
	}

	@Override
	public String getPlayAgain() {
		return "Jogar novamente?";
	}


}
