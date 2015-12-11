package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Panel_31 extends JPanel {
	public JPasswordField passwordField;
	public JTextField ipField;

	public Panel_31(JTextField ipField, JPasswordField passwordField) {
		this.ipField = ipField;
		this.passwordField = passwordField;
		
		setBackground(Color.WHITE);
		setSize(300, 200);
		setBorder(BorderFactory.createLineBorder(Color.lightGray));

		JTextPane pane1 = new JTextPane();
		pane1.setContentType("text/html");
		String text = "<p><b><font color = '#007fff'>Control Remote PC</font></b></p><p>Please enter your partner's IP and password<br>"
				+ "in order to control the remote computer.</p>";
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

		Font font = new Font("Arial, Helvetica, sans-serif", Font.BOLD, 14);

		for (int i = 0; i < 3; i++)
			p1.addPoint((int) (120 + 15 * Math.cos(i * 2 * Math.PI / 3)),
					(int) (120 + 15 * Math.sin(i * 2 * Math.PI / 3)));
		g.setColor(myBlue1);
		g.fillPolygon(p1);
		g.fillRect(32, 107, 80, 25);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Partner's IP", 40, 125);
		g.setColor(myBlue2);
//		g.drawString("170.192.55.68", 160, 125);
//		ipField = new JTextField();
		ipField.setBounds(160, 100, 112, 30);
		add(ipField);

		for (int i = 0; i < 3; i++)
			p2.addPoint((int) (120 + 15 * Math.cos(i * 2 * Math.PI / 3)),
					(int) (148 + 15 * Math.sin(i * 2 * Math.PI / 3)));
		g.setColor(myBlue1);
		g.fillPolygon(p2);
		g.fillRect(32, 135, 80, 25);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Password", 40, 153);
//		passwordField = new JPasswordField("");
		passwordField.setBounds(160, 133, 112, 30);
		add(passwordField);
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getIpField() {
		return ipField;
	}

}
