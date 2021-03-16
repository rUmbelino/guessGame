package com.rumbelino.models.userInterface.swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.rumbelino.models.userInterface.UserInterface;

public class Swing extends JFrame implements UserInterface {

	private static final long serialVersionUID = 3267901168160122404L;
	private final String GAME_NAME = "Jogo Gourmet";
	private final JFrame frame;

	public Swing() {
		this.frame = new JFrame();
	}

	@Override
	public String read(String message) {
		String input = JOptionPane.showInputDialog(message);
		int userInputCode = input == null ? -1 : 1;
		validateCloseEvent(userInputCode);
		return input;
	}

	@Override
	public void print(String message) {
		int input = JOptionPane.showConfirmDialog(this.frame, message, this.GAME_NAME, JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		validateCloseEvent(input);
	}

	@Override
	public boolean validate(String message) {

		Object[] options = { "Sim", "Não" };

		int input = JOptionPane.showOptionDialog(frame, message, GAME_NAME, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		validateCloseEvent(input);
		return input == 0;
	}

	private void validateCloseEvent(int input) {
		if (input == -1) {
			System.exit(0);
		}
	}
}
