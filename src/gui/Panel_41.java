package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_41 extends JPanel {
	private JButton connectButton;

	public Panel_41() {
		Color color = new Color(137, 137, 137);
		setSize(300, 50);
		connectButton = new rectButton("<html><font color = 'white'>connect</font></html>");
		connectButton.setPreferredSize(new Dimension(300, 30));
		add(connectButton);
	}

	public JButton getConnectButton() {
		return connectButton;
	}
}
