package gui;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_41 extends JPanel {

	private static final long serialVersionUID = -8785433558915554769L;
	private JButton connectButton;

	public Panel_41() {
		setSize(300, 50);
		connectButton = new rectButton("<html><font color = 'white'>connect</font></html>");
		connectButton.setPreferredSize(new Dimension(300, 30));
		add(connectButton);
	}

	public JButton getConnectButton() {
		return connectButton;
	}
}
