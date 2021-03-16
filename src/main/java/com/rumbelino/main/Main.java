package com.rumbelino.main;

import com.rumbelino.game.Game;

public class Main {

	public static void main(String[] args) {
		Game game = Game.buildSwingFoodGame();
		game.start(true);

	}
}
