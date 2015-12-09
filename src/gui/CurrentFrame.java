package gui;

import java.awt.Color;
import java.awt.EventQueue;
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
	public CurrentFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Running Session");
		frame.setBounds(100, 100, 451, 277);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel.setBounds(10, 11, 414, 153);
		frame.getContentPane().add(panel);
		
		JLabel label1 = new JLabel();
		label1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label1.setForeground(new Color(0, 102, 255));
		label1.setText("  Current Session");
		label1.setBounds(0, 0, 200, 50);
		panel.add(label1);
		
		for (int i = 0; i < 60; i++) {
		    panel.add(new JLabel(" 		"));
		}
		
		JLabel label3 = new JLabel();
		Image icon = new ImageIcon(this.getClass().getResource("/current IP.jpg")).getImage();
		label3.setIcon(new ImageIcon(icon));
		panel.add(label3);
		
		JLabel label4 = new JLabel("connector's ip address string");
		label4.setForeground(new Color(0, 0, 139));
		label4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(label4);
		
		JButton btnNewButton = new JButton("Disconnect");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(10, 179, 414, 53);
		frame.getContentPane().add(btnNewButton);
		
	}

}
