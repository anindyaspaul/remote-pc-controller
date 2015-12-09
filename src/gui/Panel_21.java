package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.net.InetAddress;
import static java.net.InetAddress.getLocalHost;
import java.net.UnknownHostException;
import java.text.AttributedCharacterIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Panel_21 extends JPanel {

	public Panel_21() {
		setBackground(Color.WHITE);
		setSize(300, 200);
		setBorder(BorderFactory.createLineBorder(Color.lightGray));

		JTextPane pane1 = new JTextPane();
		pane1.setContentType("text/html");
		String text = "<p><b><font color = '#007fff'>Allow Remote Control</font></b></p><p>Please tell your partner the following IP and<br>"
				+ "password if your would like to allow remote<br>" + "control.</p>";
		pane1.setText(text);
		pane1.setEditable(false);
		add(pane1);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Polygon p1 = new Polygon();
		Polygon p2 = new Polygon();

		Color myBlue1 = new Color(0, 127, 255);
		Color myBlue2 = new Color(0, 38, 153);

		String YourIP = " 127.127.127.127 "; // host IP
		String YourPass = "ABCD"; // host Password

		Font font = new Font("Arial, Helvetica, sans-serif", Font.BOLD, 14);

		for (int i = 0; i < 3; i++)
			p1.addPoint((int) (120 + 15 * Math.cos(i * 2 * Math.PI / 3)),
					(int) (140 + 15 * Math.sin(i * 2 * Math.PI / 3)));
		g.setColor(myBlue1);
		g.fillPolygon(p1);
		g.fillRect(32, 127, 80, 25);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Your IP", 40, 145);
		g.setColor(myBlue2);
		g.drawString(YourIP, 160, 145);

		for (int i = 0; i < 3; i++)
			p2.addPoint((int) (120 + 15 * Math.cos(i * 2 * Math.PI / 3)),
					(int) (168 + 15 * Math.sin(i * 2 * Math.PI / 3)));
		g.setColor(myBlue1);
		g.fillPolygon(p2);
		g.fillRect(32, 155, 80, 25);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Password", 40, 173);
		g.setColor(myBlue2);
		g.drawString(YourPass, 160, 173);

	}

}
