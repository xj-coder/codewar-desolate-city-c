package c.city.desolate.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import c.city.desolate.server.properties.ServerProperties;

public class Service extends Thread {
	private ServerSocket serverSocket = null;

	public Service(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		while (true) {
			Socket socket = null;
			try {
				// 接收客户连接,只要客户进行了连接,就会触发accept();从而建立连接
				socket = serverSocket.accept();
				new ServerThread(socket).run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		try {
			ServerSocket serverSocket = new ServerSocket(
					ServerProperties.CODE_COMMIT_PORT);
			new Service(serverSocket).run();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
