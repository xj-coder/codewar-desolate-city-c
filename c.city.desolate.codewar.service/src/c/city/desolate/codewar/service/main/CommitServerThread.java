package c.city.desolate.codewar.service.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;



/**
 * @author jhs
 * @see 本类继承Thread类进行多线程响应
 * 
 */
public class CommitServerThread extends Thread {

	private Socket clientSocket = null;
	private CommitKnockProtocol ckp = null;
	private OutputStream os = null;
	private InputStream is = null;

	public CommitServerThread() {
		super("CommitServerThread");
	}

	public CommitServerThread(Socket clentSocket) {
		super("CommitServerThread");
		this.clientSocket = clentSocket;
	}
	
	public CommitServerThread(Socket clentSocket,CommitKnockProtocol ckp ) {
		super("CommitServerThread");
		this.clientSocket = clentSocket;
		this.ckp = ckp;
	}

	public Socket getClentSocket() {
		return clientSocket;
	}

	public void setClentSocket(Socket clentSocket) {
		this.clientSocket = clentSocket;
	}

	public CommitKnockProtocol getKkpf() {
		return ckp;
	}

	public void setKkpf(CommitKnockProtocol kkpf) {
		this.ckp = kkpf;
	}

	// 运行线程
	public void run() {
		try {
			os = clientSocket.getOutputStream();
			is = clientSocket.getInputStream();
			// 接受客户端信息
			byte[] data = new byte[256];
			is.read(data);
System.out.println("客户端请求协议ID:" + new String(data,Properties.ENCODING));
			InetAddress ia = clientSocket.getInetAddress();
System.out.println("客户端ip:" + ia.getHostAddress());
			// 处理请求
			byte[] result = null;
			result = ckp.commint(data);
			// 向客户端发信息
			ckp.sendMessage(os, result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("关闭客户与服务端的连接");
				this.os.close();
				this.is.close();
				this.clientSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
