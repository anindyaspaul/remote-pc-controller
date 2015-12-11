package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class OopsFrame{

	public JFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OopsFrame window = new OopsFrame();
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
	public OopsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Error");
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 440, 112);
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
		label1.setText("Oops!");
		label1.setBounds(0, 0, 200, 50);
		label1.setIconTextGap(50);
		panel.add(label1);
		
		
		
		JLabel label2 = new JLabel();
		label2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label2.setForeground(new Color(0, 0, 0));
		label2.setText("The IP and Password you entered did not match.");
		label2.setBounds(0, 0, 200, 50);
		panel.add(label2);
//		JLabel label1 = new JLabel();
//	    label1.setText("testing");
//	    label1.setBounds(0, 0, 200, 50);
//	    JLabel label2 = new JLabel();
//	    label2.setText("<html><h1>header1 text</h1></html>");
//	    label2.setBounds(0, 20, 200, 50);
		
	}
}
