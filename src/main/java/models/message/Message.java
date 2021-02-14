package models.message;

import models.game.Guess;

public interface Message {

	public abstract String getGreeting();

	public abstract String getHunch(Guess item);
	
	public abstract String getGuess(Guess item);

	public abstract String getHit();

	public abstract String getMissName();

	public abstract String getMissCharacteristic(Guess itemA, Guess itemB);
}
