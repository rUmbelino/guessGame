package models.game.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.game.Guess;

public class GuessTest {
	@Test
	public void shouldCreateGuess() {
		Guess cake = new Guess();
		assertEquals(null, cake.getName());
		assertEquals(null, cake.getCharachteristic());
	}
	
	@Test
	public void shouldCreateAndPopulateGuess() {
		String name = "Cake";
		String charachteristic = "made of chocolate";
		Guess cake = new Guess(name, charachteristic);
		
		assertEquals(name, cake.getName());
		assertEquals(charachteristic, cake.getCharachteristic());
	}
	
	@Test
	public void shouldCreateAndLatePopulateGuess() {
		String name = "Cake";
		String charachteristic = "made of chocolate";
		
		Guess cake = new Guess();
		cake.setName(name);
		cake.setCharachteristic(charachteristic);
		
		assertEquals(name, cake.getName());
		assertEquals(charachteristic, cake.getCharachteristic());
	}

}
