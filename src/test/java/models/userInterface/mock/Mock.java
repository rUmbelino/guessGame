package models.userInterface.mock;

import java.util.Map;

import models.userInterface.UserInterface;

public class Mock implements UserInterface {
	Map<String, Boolean> validateAwnsers;

	public Mock(Map<String, Boolean> validateAwnsers) {
		this.validateAwnsers = validateAwnsers;
	}

	@Override
	public String read() {
		return null;
	}

	@Override
	public void print(String message) {
		System.out.println(message);
	}

	@Override
	public boolean validate(String message) {
		return this.validateAwnsers.get(message);
	}

}
