package host;

import utilities.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;

import gui.CurrentFrame;

public class ScreenSender implements Runnable {

	Socket socket;
	ScreenCapturer screenCapturer;
	CurrentFrame currentFrame;

	public ScreenSender(Socket socket, CurrentFrame currentFrame) {
		this.socket = socket;
		this.screenCapturer = new ScreenCapturer();
		this.currentFrame = currentFrame;
	}

	@Override
	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			while (true) {
				BufferedImage screenShot = screenCapturer.capture();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(screenShot, Constants.imageType, baos);
				byte[] imageData = baos.toByteArray();
				dos.writeInt(imageData.length);
				dos.write(imageData);
				Thread.sleep(40);
			}	
		} catch (Exception e) {
			System.out.println("Error in screen sender: " + e);
			currentFrame.frame.setVisible(false);
		}
	}
}