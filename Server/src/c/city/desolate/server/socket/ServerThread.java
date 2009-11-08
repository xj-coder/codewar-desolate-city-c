package c.city.desolate.server.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 
 * @author Desolate.City.C
 * 
 */
public class ServerThread extends Thread {

	private Socket clentSocket = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;

	public ServerThread() {
		super("CommitServerThread");
	}

	public ServerThread(Socket clentSocket) {
		super("CommitServerThread");
		this.clentSocket = clentSocket;
	}

	public Socket getClentSocket() {
		return clentSocket;
	}

	public void setClentSocket(Socket clentSocket) {
		this.clentSocket = clentSocket;
	}

	// 运行线程
	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(clentSocket.getOutputStream());
			ois = new ObjectInputStream(clentSocket.getInputStream());
			// 接受客户端信息
			Object obj = ois.readObject();
			System.out.println("客户端请求协议ID： " + obj);
			InetAddress ia = clentSocket.getInetAddress();
			System.out.println("客户端ip:" + ia.getHostAddress());
			// 处理请求
			// 向客户端发送
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("关闭客户与服务端的连接");
				this.oos.close();
				this.ois.close();
				this.clentSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
