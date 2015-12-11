package driver;

import javax.swing.SwingUtilities;

import gui.*;

public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Frame frame = new Frame();
				CurrentFrame currentFrame = new CurrentFrame();
				currentFrame.frame.setVisible(true);
				ConnectingFrame connectingFrame = new ConnectingFrame();
				connectingFrame.frame.setVisible(true);
				DeniedFrame deniedFrame = new DeniedFrame();
				deniedFrame.frame.setVisible(true);
				IncomingFrame incomingFrame = new IncomingFrame();
				incomingFrame.frame.setVisible(true);
				OopsFrame oopsFrame = new OopsFrame();
				oopsFrame.frame.setVisible(true);
			}
		});
	}
}