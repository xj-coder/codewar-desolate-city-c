package c.city.desolate.codewar.code.service.main;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class CommitClient {
	private Socket s = null;

	public byte[] startClientService(String command) {
		byte[] result = new byte[1024];
		byte[] temp1 = new byte[1024];
		byte[] temp2 = new byte[1024];
		try {
			s = new Socket(Properties.SERVER_ADDRESS,
					Properties.SERVER_PORT);
			s.getOutputStream().write(command.getBytes(Properties.ENCODING));
			s.getOutputStream().flush();
			
			//以1024为缓存区读取流中的数据
			int len = s.getInputStream().read(temp1);
			int dest;
			result = Arrays.copyOf(temp1, len);
			while(len == 1024){
				dest = result.length;
				len = s.getInputStream().read(temp2);
				result = new byte[result.length+len];
				result = Arrays.copyOf(temp1, result.length);
				System.arraycopy(temp2, 0, result, dest, len);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
