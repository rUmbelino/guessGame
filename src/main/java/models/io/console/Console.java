package models.io.console;

import java.util.Scanner;

import models.userInterface.UserInterface;

public class Console implements UserInterface {

	@Override
	public void print(String message) {
		System.out.println(message);

	}

	@Override
	public String read() {
		Scanner scanner = new Scanner(System.in);
		String message = scanner.next();

		return message;
	}

	@Override
	public boolean validate(String message) {
		this.print(message);
		String result = this.read();
		
		return "S".equals(result);
	}

}
