package models.message;

import models.game.Guess;

public interface Message {

	public abstract String getInstructions();

	public abstract String getHunchCharacteristic(Guess item);
	
	public abstract String getHunchName(Guess item);

	public abstract String getWinMessage();

	public abstract String getRegisterGuessName();

	public abstract String getRegisterGuessCharacteristic(Guess itemA, Guess itemB);
}
