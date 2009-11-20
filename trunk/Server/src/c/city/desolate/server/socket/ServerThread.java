package c.city.desolate.server.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.dom4j.DocumentException;

import c.city.desolate.server.protocol.CommitProtocol;
import c.city.desolate.server.xml.bean.C2SProtocolXML;
import c.city.desolate.server.xml.parse.C2SProtocolXMLParse;

/**
 * 
 * @author Desolate.City.C
 * 
 */
public class ServerThread extends Thread {

	private Socket clientSocket = null;
	private OutputStream os = null;
	private InputStream is = null;

	public ServerThread() {
		super("CommitServerThread");
	}

	public ServerThread(Socket clentSocket) {
		super("CommitServerThread");
		this.clientSocket = clentSocket;
	}

	public Socket getClentSocket() {
		return clientSocket;
	}

	public void setClentSocket(Socket clentSocket) {
		this.clientSocket = clentSocket;
	}

	// 运行线程
	@Override
	public void run() {
		try {
			os = clientSocket.getOutputStream();
			is = clientSocket.getInputStream();
			byte[] result = null;

			// 接受客户端信息
			System.out.println("客户端请求协议ID： ");
			InetAddress ia = clientSocket.getInetAddress();
			System.out.println("客户端ip:" + ia.getHostAddress());
			// 处理请求

			C2SProtocolXML protocolXML = null;
			try {
				protocolXML = C2SProtocolXMLParse.getC2SProtocolXML(is);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			result = CommitProtocol.commitProtocol(protocolXML);
			// 向客户端发送
			os.write(result);
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
