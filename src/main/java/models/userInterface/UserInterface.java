package models.userInterface;

public interface UserInterface {
	
	public abstract String read();
	
	public abstract void print(String message);

	public abstract boolean validate(String message);
	
}
