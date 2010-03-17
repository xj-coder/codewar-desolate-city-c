package c.city.desolate.codewar.code.service.action;
import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		InputStream
		byte[] a = new byte[]{1,2,3,4,5,6};
		byte[] b = Arrays.copyOf(a,20);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}
}
