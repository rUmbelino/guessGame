package models.userInterface.mock;

import java.util.Map;

import models.userInterface.UserInterface;

public class Mock implements UserInterface {
	Map<String, Boolean> validateAwnsers;
	Map<String, String> readAwnsers;

	public Mock(Map<String, Boolean> validateAwnsers) {
		this.validateAwnsers = validateAwnsers;
	}

	public Mock(Map<String, Boolean> validateAwnsers, Map<String, String> readAwnsers) {
		this.readAwnsers = readAwnsers;
		this.validateAwnsers = validateAwnsers;
	}

	@Override
	public String read(String message) {
		return this.readAwnsers.get(message);
	}

	@Override
	public void print(String message) {
	}

	@Override
	public boolean validate(String message) {
		return this.validateAwnsers.get(message);
	}

}
