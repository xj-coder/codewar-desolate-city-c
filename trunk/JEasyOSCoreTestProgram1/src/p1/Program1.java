package p1;

import java.io.InputStream;
import java.io.OutputStream;

import program.base.Program;

public class Program1 extends Program {

	public Program1() {
	}

	@Override
	public void main(String[] args) {
		System.out.println(STATE_STOPDOWN);
	}

	@Override
	public OutputStream getErrorStream() {
		return System.err;
	}

	@Override
	public InputStream getInputStream() {
		return System.in;
	}

	@Override
	public OutputStream getOutputStream() {
		return System.out;
	}

}
