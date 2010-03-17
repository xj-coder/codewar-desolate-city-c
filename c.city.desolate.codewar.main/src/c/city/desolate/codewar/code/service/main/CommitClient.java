package c.city.desolate.codewar.code.service.main;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class CommitClient {
	private Socket s = null;

	public byte[] startClientService(String command) {
		byte[] result = new byte[1024];
		try {
			s = new Socket(Properties.SERVER_ADDRESS,
					Properties.SERVER_PORT);
			s.getOutputStream().write(command.getBytes(Properties.ENCODING));
			s.getOutputStream().flush();
			
			int len = s.getInputStream().read(result);
			while(len != -1){
				byte[] temp = new byte[1024];
				len = s.getInputStream().read(temp);
				if(len == -1){
					result = Arrays.copyOf(temp,result.length+1024);
					
				}
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
