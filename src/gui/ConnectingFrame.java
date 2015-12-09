package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ConnectingFrame {

	public JFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ConnectingFrame window = new ConnectingFrame();
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
	public ConnectingFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Connecting...");
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 457, 148);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JPanel panel = new JPanel();
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel.setBounds(10, 11, 421, 87);
		frame.getContentPane().add(panel);
		
		JLabel label1 = new JLabel();
		label1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label1.setForeground(new Color(0, 102, 255));
		label1.setText("  Connecting... ");
		label1.setBounds(0, 0, 200, 50);
		panel.add(label1);
		
		
		for (int i = 0; i < 20; i++) {
		    panel.add(new JLabel(" 		"));
		}
		
		JLabel label2 = new JLabel();
		label2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label2.setForeground(new Color(0, 0, 0));
		label2.setText("   Please wait while we try to connect.");
		label2.setBounds(0, 0, 200, 50);
		panel.add(label2);
	}

}
