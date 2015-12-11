package driver;

import javax.swing.SwingUtilities;

import gui.*;
import host.RequestReceiver;
import utilities.Constants;

public class Main {

	public static void main(String[] args) throws Exception {

		PasswordGenerator pass = new PasswordGenerator();
		String password = pass.password;

		// new Thread(new RequestReceiver(Constants.port, password)).start();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Frame frame = new Frame(password);
				// CurrentFrame currentFrame = new CurrentFrame();
				// currentFrame.frame.setVisible(true);
				// ConnectingFrame connectingFrame = new ConnectingFrame();
				// connectingFrame.frame.setVisible(true);
				// DeniedFrame deniedFrame = new DeniedFrame();
				// deniedFrame.frame.setVisible(true);
				// IncomingFrame incomingFrame = new IncomingFrame();
				// incomingFrame.frame.setVisible(true);
				// OopsFrame oopsFrame = new OopsFrame();
				// oopsFrame.frame.setVisible(true);
			}
		});
	}
}