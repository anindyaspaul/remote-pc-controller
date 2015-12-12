package gui;

import javax.swing.JButton;
import java.awt.*;

public class modifButton extends JButton {

	private static final long serialVersionUID = -6154025927899599825L;

	public modifButton(String lbl) {
		super(lbl);
		setPreferredSize(new Dimension(30, 30));
		setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics graph) {
		if (getModel().isArmed()) {
			graph.setColor(Color.WHITE);
		}

		else {
			graph.setColor(getBackground());
		}
		graph.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		// graph . fillRect(10, 10, 20, 20);
		super.paintComponent(graph);
	}

}