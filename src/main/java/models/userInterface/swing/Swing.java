package models.userInterface.swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.userInterface.UserInterface;

public class Swing extends JFrame implements UserInterface {

	private static final long serialVersionUID = 3267901168160122404L;
	private final String GAME_NAME = "Jogo Gourmet";
	private final JFrame frame;

	public Swing() {
		this.frame = new JFrame();
	}

	@Override
	public String read(String message) {
		return JOptionPane.showInputDialog(message);
	}

	@Override
	public void print(String message) {
		JOptionPane.showConfirmDialog(this.frame, message, this.GAME_NAME, JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public boolean validate(String message) {

		Object[] options = { "Sim", "Não" };

		int input = JOptionPane.showOptionDialog(frame, message, GAME_NAME, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		return input == 0;
	}
}
