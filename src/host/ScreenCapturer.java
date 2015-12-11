package host;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ScreenCapturer {

	Robot robot;

	public ScreenCapturer() throws Exception {
		robot = new Robot();
	}

	BufferedImage capture() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenDimension);
		return robot.createScreenCapture(screenRectangle);
	}
}