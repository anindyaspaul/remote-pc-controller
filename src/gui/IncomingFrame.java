package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;

public class IncomingFrame {

	public JFrame frame;
	public JLabel reqIP;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IncomingFrame window = new IncomingFrame();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public IncomingFrame(JButton btnNewButton, JButton btnNewButton_1) {
		initialize(btnNewButton, btnNewButton_1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JButton btnNewButton, JButton btnNewButton_1) {
		frame = new JFrame("Incoming Request");
		frame.setBounds(100, 100, 450, 258);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel.setBounds(10, 11, 412, 132);
		frame.getContentPane().add(panel);
		
		JLabel label1 = new JLabel();
		label1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label1.setForeground(new Color(0x3d, 0x8a, 0xf7));
		label1.setText("Incoming Request");
		label1.setBounds(0, 0, 200, 50);
		label1.setIconTextGap(50);
		panel.add(label1);
				
		JLabel label2 = new JLabel();
		label2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label2.setForeground(new Color(0, 0, 0));
		label2.setText("Someone wants to control your PC remotely.");
		label2.setBounds(0, 0, 200, 50);
		panel.add(label2);
		
		
		JLabel label3 = new JLabel();
		Image icon = new ImageIcon(this.getClass().getResource("/arrow requesters IP.jpg")).getImage();
		label3.setIcon(new ImageIcon(icon));
		panel.add(label3);
		
		reqIP = new JLabel();
		reqIP.setForeground(new Color(0, 0, 139));
		reqIP.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(reqIP);
		
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0x3d, 0x8a, 0xf7));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(10, 155, 204, 53);
		btnNewButton.setFocusPainted(false);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(0x3d, 0x8a, 0xf7));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBounds(220, 155, 202, 53);
		btnNewButton_1.setFocusPainted(false);
		frame.getContentPane().add(btnNewButton_1);
	}
}