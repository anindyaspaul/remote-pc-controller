package controller;

import utilities.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

public class ControlSender implements Runnable, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

	Socket socket;
	JLabel imageLabel;
	ObjectOutputStream oos;

	public ControlSender(Socket socket, JLabel imageLabel) throws Exception {
		this.socket = socket;
		this.oos = new ObjectOutputStream(socket.getOutputStream());

		this.imageLabel = imageLabel;
		this.imageLabel.addMouseListener(this);
		this.imageLabel.addMouseMotionListener(this);
		this.imageLabel.addMouseWheelListener(this);
		this.imageLabel.addKeyListener(this);
		this.imageLabel.setFocusable(true);
	}

	@Override
	public void run() {
		while (true)
			;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GenericEvent event = new GenericEvent(GenericEvent.MOUSE_PRESSED, 0, e);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GenericEvent event = new GenericEvent(GenericEvent.MOUSE_RELEASED, 0, e);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		GenericEvent event = new GenericEvent(GenericEvent.MOUSE_MOVED, 0, e);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		GenericEvent event = new GenericEvent(GenericEvent.MOUSE_DRAGGED, 0, e);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println(e.getWheelRotation());
		GenericEvent event = new GenericEvent(GenericEvent.MOUSE_WHEEL, 0, e);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		GenericEvent event = new GenericEvent(GenericEvent.KEY_PRESSED, e.getKeyCode(), null);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		GenericEvent event = new GenericEvent(GenericEvent.KEY_RELEASED, e.getKeyCode(), null);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Do nothing
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Do nothing
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Do nothing
	}
}