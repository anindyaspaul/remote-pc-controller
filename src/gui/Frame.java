package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.RequestSender;
import utilities.Constants;

public class Frame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -1254328551738199832L;
	// private final Panel_11 b1panel ;
	private final Panel_21 panel1;
	private final Panel_31 panel2;
	private final Panel_41 b2panel;
	
	private JTextField ipField;
	private JPasswordField passwordField;

	public Frame(String password) {
		super("Remote PC Controller");
		setLayout(new GridBagLayout());
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		// setUndecorated ( true ) ;
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.lightGray)); // frame
																								// border
		GridBagConstraints gbc = new GridBagConstraints(); // we have a ( 4 , 1
															// ) grid
		gbc.fill = GridBagConstraints.BOTH;

		// gbc . gridx = 0 ;
		// gbc . gridy = 0 ;
		// gbc . ipady = 0 ;
		// b1panel = new Panel_11 () ;
		// add ( b1panel , gbc ) ; // add panel in (1,1) point of grid which
		// contain minimize , exit button and text

		gbc.insets = new Insets(10, 10, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 80;
		gbc.ipadx = 10;
		panel1 = new Panel_21(password);
		add(panel1, gbc); // add panel in (2,1) point of grid which contain text
							// , your ip and your password

		gbc.insets = new Insets(10, 10, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipady = 80;
		ipField = new JTextField();
		passwordField = new JPasswordField("");
		panel2 = new Panel_31(ipField, passwordField);
//		ipField = panel2.getIpField();
//		passwordField = panel2.getPasswordField();
		add(panel2, gbc); // add panel in (3,1) point of grid which contain text
							// , your friends ip and password

		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipady = 0;
		b2panel = new Panel_41();
		b2panel.getConnectButton().addActionListener(this);
		add(b2panel, gbc);// add panel in (3,1) point of grid which contain
							// connect button

		pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("deprecation")
		String password = passwordField.getText();
		String ip = ipField.getText();
		System.out.println(password);
		System.out.println(ip);
		new Thread(new RequestSender(ip, Constants.port, password)).start();
	}
}
