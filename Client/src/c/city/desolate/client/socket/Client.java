package c.city.desolate.client.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import c.city.desolate.client.manage.SocketManage;

public class Client {
	private Socket s = null;
	private InputStream is = null;
	private OutputStream os = null;

	// 开启客户端
	public byte[] startClientService(byte[] b) {
		byte[] result = null;
		try {

			s = SocketManage.getClient();
			os = s.getOutputStream();
			os.write(b);
			os.flush();
			is = s.getInputStream();
			is.read(result);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭与服务端的连接
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
				if (s != null)
					s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
