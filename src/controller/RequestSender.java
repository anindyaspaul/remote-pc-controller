package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import gui.ConnectingFrame;
import gui.DeniedFrame;
import gui.OopsFrame;
import utilities.Constants;

public class RequestSender implements Runnable {

	int port;
	String host;
	JLabel imageLabel;
	String password;
	ConnectingFrame connectingFrame;

	public RequestSender(String host, int port, String password) {
		this.host = host;
		this.port = port;
		this.imageLabel = new JLabel();
		this.password = password;
		this.connectingFrame = new ConnectingFrame();
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket(host, port);
			if (allowed(socket)) {
				new Thread(new ScreenReceiver(socket, imageLabel)).start();
				new Thread(new ControlSender(socket, imageLabel)).start();
			}
		} catch (Exception e) {
			showOops();
		}
	}

	boolean allowed(Socket socket) throws Exception {
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		dos.writeUTF(password);
		showConnecting();
		int ret = dis.readInt();
		hideConnecting();
		if (ret == Constants.denied)
			showDenied();
		else if (ret == Constants.allowed)
			return true;
		else
			showOops();
		return false;
	}

	void showOops() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				OopsFrame oopsFrame = new OopsFrame();
				oopsFrame.frame.setVisible(true);
			}
		});
	}

	void showConnecting() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				connectingFrame.frame.setVisible(true);
			}
		});
	}

	void hideConnecting() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				connectingFrame.frame.setVisible(false);
			}
		});
	}

	void showDenied() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				DeniedFrame deniedFrame = new DeniedFrame();
				deniedFrame.frame.setVisible(true);
			}
		});
	}
}