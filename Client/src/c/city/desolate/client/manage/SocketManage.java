package c.city.desolate.client.manage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import c.city.desolate.client.properties.ClientProperties;

public class SocketManage {
	private static Socket Client = null;
	private static ServerSocket server = null;

	public static Socket getClient() throws UnknownHostException, IOException {
		if (null == Client)
			Client = new Socket(ClientProperties.SERVER_ADDRESS,
					ClientProperties.SERVER_PORT);
		return Client;
	}

	public static ServerSocket getServer() throws IOException {
		if (null == server)
			server = new ServerSocket(ClientProperties.CLIENT_PORT);
		return server;
	}
}
