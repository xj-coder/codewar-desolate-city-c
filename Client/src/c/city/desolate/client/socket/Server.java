package c.city.desolate.client.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;

	public void service(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("服务器启动");
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				new ServerThread(socket).run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
