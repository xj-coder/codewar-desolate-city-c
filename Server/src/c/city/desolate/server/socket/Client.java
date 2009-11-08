package c.city.desolate.server.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

import c.city.desolate.server.properties.ServerProperties;

public class Client {
	private Socket s = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;

	// 开启客户端
	@SuppressWarnings("unchecked")
	public Map<String, Object> startClientService(Object obj) {
		Map<String, Object> result = null;
		try {

			s = new Socket(ServerProperties.CLIENT_ADDRESS,
					ServerProperties.CLIENT_PORT);
			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(obj);
			oos.flush();
			ois = new ObjectInputStream(s.getInputStream());
			result = (Map<String, Object>) ois.readObject();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 关闭与服务端的连接
			try {
				if (ois != null)
					ois.close();
				if (oos != null)
					oos.close();
				if (s != null)
					s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
