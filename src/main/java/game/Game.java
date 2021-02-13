package game;

import java.util.Iterator;
import java.util.LinkedList;

import models.game.Guess;
import models.io.console.Console;
import models.message.FoodMessage;
import models.message.Message;
import models.userInterface.UserInterface;

public class Game {
	private Message message;
	private UserInterface io;
	private LinkedList<Guess> list;

	public Game(Message message, UserInterface output, LinkedList<Guess> list) {
		this.message = message;
		this.io = output;
		this.list = list;
	}

	public static Game buildSysoutFoodGame() {
		LinkedList<Guess> list = new LinkedList<Guess>();
		list.add(new Guess("bolo de chocolate", "feito de chocolate"));
		list.add(new Guess("lasanha", "massa"));

		return new Game(new FoodMessage(), new Console(), list);
	}

	public void start() {
		try {
			while (true) {
				this.io.print(this.message.getGreeting());

				Boolean isRegistered = this.hasItemRegistered();
				if (!isRegistered) {
					this.askAwnser();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean hasItemRegistered() {
		Iterator<Guess> iterator = this.list.iterator();

		Boolean hasDiscovered = false;
		while (iterator.hasNext()) {
			Guess currentItem = iterator.next();
			String hunchMessage = this.message.getHunch(currentItem);
			Boolean isCorrectHunch = this.io.validate(hunchMessage);

			if (!isCorrectHunch) {
				continue;
			}

			String guessMessage = this.message.getGuess(currentItem);
			hasDiscovered = this.io.validate(guessMessage);

			if (hasDiscovered) {
				this.io.print(this.message.getHit());
				break;
			}
		}

		return hasDiscovered;
	}

	public void askAwnser() {
		Guess itemA = this.list.getLast();
		Guess itemB = new Guess();

		this.io.print(this.message.getMissName());
		String name = this.io.read();
		itemB.setName(name);

		this.io.print(this.message.getMissCharacteristic(itemA, itemB));
		String characteristic = this.io.read();

		Guess userGuess = new Guess(name, characteristic);
		this.list.add(userGuess);
	}

}
