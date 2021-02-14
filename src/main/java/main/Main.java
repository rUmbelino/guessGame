package main;

import game.Game;

public class Main {

	void test() {

	}

	public static void main(String[] args) {
		Game game = Game.buildSwingFoodGame();
		game.start(true);

	}
}
