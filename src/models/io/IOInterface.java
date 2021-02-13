package models.io;

public interface IOInterface {
	
	public abstract String read();
	
	public abstract void print(String message);

	public abstract boolean validate(String message);
	
}
