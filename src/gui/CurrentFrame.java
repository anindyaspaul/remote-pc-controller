package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CurrentFrame {

	public JFrame frame;
	public JLabel curIP;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CurrentFrame window = new CurrentFrame();
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
	public CurrentFrame(JButton btnNewButton) {
		initialize(btnNewButton);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JButton btnNewButton) {
		frame = new JFrame("Running Session");
		frame.setBounds(100, 100, 438, 180);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel.setBounds(10, 11, 414, 100);
		frame.getContentPane().add(panel);
		
		JLabel label1 = new JLabel();
		label1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label1.setForeground(new Color(0, 102, 255));
		label1.setText("Current Session");
		label1.setBounds(0, 0, 200, 50);
		panel.add(label1);
		
//		for (int i = 0; i < 60; i++) {
//		    panel.add(new JLabel(" 		"));
//		}
		
		JLabel label3 = new JLabel();
		Image icon = new ImageIcon(this.getClass().getResource("/current IP.jpg")).getImage();
		label3.setIcon(new ImageIcon(icon));
		panel.add(label3);
		
		curIP = new JLabel();
		curIP.setForeground(new Color(0, 0, 139));
		curIP.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(curIP);
		
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0x3d, 0x8a, 0xf7));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(10, 117, 414, 53);
		btnNewButton.setFocusPainted(false);
		frame.getContentPane().add(btnNewButton);
		
	}

}
