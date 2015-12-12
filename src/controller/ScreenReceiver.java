package controller;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ScreenReceiver implements Runnable, ComponentListener {

	Socket socket;
	JFrame frame;
	JLabel imageLabel;
	ImageIcon screenIcon;
	public int height;
	public int width;
	public boolean flag;

	public ScreenReceiver(Socket socket, JLabel imageLabel) {
		this.socket = socket;
		this.imageLabel = imageLabel;
		this.height = 500;
		this.width = 500;
		this.flag = false;
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

			while (true) {
				int sz = dis.readInt();
				byte[] imageData = new byte[sz];
				dis.readFully(imageData);
				ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
				BufferedImage screenShot = ImageIO.read(bais);
				double ow = screenShot.getWidth();
				double oh = screenShot.getHeight();
				double cw = height / oh * ow;
				Image screenShotResized;
				if (flag) {
					if (cw <= width)
						screenShotResized = screenShot.getScaledInstance(-1, height, Image.SCALE_SMOOTH);
					else
						screenShotResized = screenShot.getScaledInstance(width, -1, Image.SCALE_SMOOTH);
				} else {
					screenShotResized = screenShot;
				}
				screenIcon = new ImageIcon(screenShotResized);

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						imageLabel.setIcon(screenIcon);
						imageLabel.setBounds(0, 0, screenIcon.getIconWidth(), screenIcon.getIconHeight());
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
		frame.addComponentListener(this);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		JFrame fr = (JFrame) e.getComponent();
		height = fr.getContentPane().getHeight();
		width = fr.getContentPane().getWidth();
		this.flag = true;
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// Do nothing
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// Do nothing
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// Do nothing
	}
}