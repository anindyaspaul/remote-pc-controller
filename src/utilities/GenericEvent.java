package utilities;
import java.awt.event.InputEvent;
import java.io.Serializable;

public class GenericEvent implements Serializable {
	
	private static final long serialVersionUID = 5176768959091412456L;
	
	public static final int MOUSE_PRESSED	= 0;
	public static final int MOUSE_RELEASED	= 1;
	public static final int MOUSE_CLICKED	= 2;
	public static final int MOUSE_MOVED		= 3;
	public static final int MOUSE_DRAGGED	= 4;
	public static final int MOUSE_WHEEL		= 5;
	public static final int KEY_PRESSED		= 9;
	public static final int KEY_RELEASED	= 10;
	
	int value;
	int keyvalue;
	InputEvent event;
	
	public GenericEvent(int value, int keyvalue, InputEvent event) {
		this.value = value;
		this.keyvalue = keyvalue;
		this.event = event;
	}

	public int getValue() {
		return value;
	}
	
	public int getKeyValue() {
		return keyvalue;
	}

	public InputEvent getEvent() {
		return event;
	}
}
