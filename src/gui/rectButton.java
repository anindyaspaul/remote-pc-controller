package gui;

import javax.swing.JButton;
import java.awt.geom.*;
import java.awt.*;

public class rectButton extends JButton {
	public rectButton(String lbl) {
		super(lbl);
		setPreferredSize(new Dimension(30, 30));
		setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics graph) {
		Color mycolor1 = new Color(0, 127, 255);
		Color mycolor2 = new Color(0, 38, 153);

		if (getModel().isArmed()) {
			graph.setColor(mycolor2);
		}

		else {
			graph.setColor(mycolor1);
		}
		// graph . fillOval ( 0 , 0 , getSize () . width - 1 , getSize () .
		// height - 1 ) ;
		graph.fillRect(0, 0, 500, 30);
		super.paintComponent(graph);
	}

}