package controller;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ScreenReceiver implements Runnable {

	Socket socket;
	JFrame frame;
	JLabel imageLabel;
	ImageIcon screenIcon;

	public ScreenReceiver(Socket socket, JLabel imageLabel) {
		this.socket = socket;
		this.imageLabel = imageLabel;
	}

	@Override
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					createWindow();
				}
			});
			
			while(true) {
				int sz = dis.readInt();
				byte[] imageData = new byte[sz];
				dis.readFully(imageData);
				ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
				BufferedImage screenShot = ImageIO.read(bais);
				screenIcon = new ImageIcon(screenShot);
				
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						imageLabel.setIcon(screenIcon);
						imageLabel.setBounds(0, 0,
							screenIcon.getIconWidth(), screenIcon.getIconHeight());
						imageLabel.requestFocus();
					}
				});
				
				
			}	
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	void createWindow() {
		JFrame frame = new JFrame("Control Screen");
		frame.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		
		frame.getContentPane().add(imageLabel);
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}