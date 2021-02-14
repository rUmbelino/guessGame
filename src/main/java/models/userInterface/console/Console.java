package models.userInterface.console;

import java.util.Scanner;

import models.userInterface.UserInterface;

public class Console implements UserInterface {

	@Override
	public void print(String message) {
		System.out.println(message);

	}

	@Override
	public String read(String message) {
		this.print(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public boolean validate(String message) {
		String result = this.read(message);

		return "S".equals(result);
	}

}
