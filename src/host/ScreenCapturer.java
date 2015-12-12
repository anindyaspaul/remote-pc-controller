package host;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ScreenCapturer {

	Robot robot;

	public ScreenCapturer() {
		try {
			robot = new Robot();
		} catch (Exception e) {
			System.out.println("Error in creating robot: " + e);
		}
	}

	BufferedImage capture() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenDimension);
		return robot.createScreenCapture(screenRectangle);
	}
}