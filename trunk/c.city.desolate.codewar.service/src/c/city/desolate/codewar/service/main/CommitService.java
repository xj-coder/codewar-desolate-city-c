package c.city.desolate.codewar.service.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CommitService {
    private ServerSocket serverSocket;
    private CommitKnockProtocol ckp;
    
    public void service() {
	try {
	    serverSocket = new ServerSocket(Properties.SERVICE_PORT);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
System.out.println("服务器启动");
	while (true) {
	    Socket socket = null;
	    try {
		// 接收客户连接,只要客户进行了连接,就会触发accept();从而建立连接
		socket = serverSocket.accept();
		ckp = new CommitKnockProtocol();
		new CommitServerThread(socket,ckp).run();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public static void main(String[] args) throws IOException {
	new CommitService().service();
    }
}
