package models.game;

public class Guess {

	private String name;
	private String charachteristic;

	public Guess() {
	}

	public Guess(String name, String charachteristic) {
		this.name = name;
		this.charachteristic = charachteristic;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCharachteristic(String charachteristic) {
		this.charachteristic = charachteristic;
	}

	public String getName() {
		return this.name;
	}

	public String getCharachteristic() {
		return this.charachteristic;
	}

}
