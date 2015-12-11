package host;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import gui.CurrentFrame;
import gui.IncomingFrame;
import sun.text.normalizer.ICUBinary.Authenticate;
import utilities.Constants;

public class RequestReceiver implements Runnable, ActionListener {

	ServerSocket serverSocket;
	String password;
	IncomingFrame incomingFrame;
	CurrentFrame currentFrame;
	JButton btnAllowed;
	JButton btnDenied;
	JButton btnDiscon;
	Socket socket;

	public RequestReceiver(int port, String password) throws Exception {
		serverSocket = new ServerSocket(port);
		this.password = password;
		this.btnAllowed = new JButton("Allow");
		this.btnAllowed.addActionListener(this);
		this.btnDenied = new JButton("Denied");
		this.btnDenied.addActionListener(this);
		this.btnDiscon = new JButton("Disconnect");
		this.btnDiscon.addActionListener(this);
		this.incomingFrame = new IncomingFrame(btnAllowed, btnDenied);
		this.currentFrame = new CurrentFrame(btnDiscon);
	}

	@Override
	public void run() {
		while (true) {
			try {
				socket = serverSocket.accept();
				authenticate();
				// new Thread(new ScreenSender(socket)).start();
				// new Thread(new ControlReceiver(socket)).start();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	void authenticate() throws Exception {
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

		String ret = dis.readUTF();
		if (ret.compareTo(password) == 0) {
			showIncoming();
		} else {
			dos.writeInt(Constants.mismatch);
		}
	}

	void showIncoming() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				incomingFrame.reqIP.setText(socket.getRemoteSocketAddress().toString());
				incomingFrame.frame.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			if (e.getSource() == btnAllowed) {
				dos.writeInt(Constants.allowed);
				new Thread(new ScreenSender(socket)).start();
				new Thread(new ControlReceiver(socket)).start();
				showCurrent();
			} else if (e.getSource() == btnDenied) {
				dos.writeInt(Constants.denied);
			} else if (e.getSource() == btnDiscon) {
				currentFrame.frame.setVisible(false);
				socket.close();
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		incomingFrame.frame.setVisible(false);
	}

	void showCurrent() {
		currentFrame.curIP.setText(socket.getRemoteSocketAddress().toString());
		currentFrame.frame.setVisible(true);
	}
}