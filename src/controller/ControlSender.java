package controller;

import utilities.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

public class ControlSender implements Runnable, MouseListener, MouseMotionListener, KeyListener {

	Socket socket;
	JLabel imageLabel;
	ObjectOutputStream oos;

	public ControlSender(Socket socket, JLabel imageLabel) throws Exception {
		this.socket = socket;
		this.oos = new ObjectOutputStream(socket.getOutputStream());

		this.imageLabel = imageLabel;
		this.imageLabel.addMouseListener(this);
		this.imageLabel.addMouseMotionListener(this);
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
		System.out.println("Mouse Pressed " + e.getX() + " " + e.getY());

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
		System.out.println("Mouse Released " + e.getX() + " " + e.getY());

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
		System.out.println("Mouse moved " + e.getX() + " " + e.getY());
		
		GenericEvent event = new GenericEvent(GenericEvent.MOUSE_MOVED, 0, e);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Nothing to do
		// System.out.println("Mouse Clicked " + e.getX() + " " + e.getY());
		//
		// GenericEvent event = new GenericEvent(GenericEvent.MOUSE_CLICKED, e);
		// try {
		// oos.writeObject(event);
		// } catch (Exception e2) {
		// System.out.println(e2);
		// }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key pressed " + e.getKeyCode());

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
		System.out.println("Key released " + e.getKeyCode());

		GenericEvent event = new GenericEvent(GenericEvent.KEY_RELEASED, e.getKeyCode(), null);
		try {
			oos.writeObject(event);
			oos.flush();
		} catch (Exception e2) {
			System.out.println(e2);
		}
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// Do nothing
	}
}