package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_11 extends JPanel implements ActionListener {
	private JButton minimizeButton;
	private JButton exitButton;
	private JLabel text;

	public Panel_11() {

		Color color = new Color(137, 137, 137);
		setBackground(color);
		setSize(300, 50);

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		exitButton = new modifButton("<html><font size=3>X</font></html>");
		exitButton.addActionListener(this);
		gbc.insets = new Insets(0, 0, 0, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(exitButton, gbc);

		minimizeButton = new modifButton("<html><font size=3>-</font></html>");
		gbc.insets = new Insets(0, 0, 0, 5);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(minimizeButton, gbc);

		JLabel text = new JLabel("<html><font color = 'white'>Remote PC Controller</font></html>");
		gbc.insets = new Insets(0, 0, 0, 100);
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(text, gbc);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == exitButton) {
			System.exit(0);
		}
	}

}
