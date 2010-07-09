package ram.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryAction {
	private static RandomAccessFile RAFile;;
	private static FileChannel fc;

	static {
		try {
			RAFile = new RandomAccessFile(new File("randomAccess.ram"), "rws");
			fc = RAFile.getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在指定位置创建指定大小的内存块
	 * 
	 * @param size
	 * @return
	 * @throws IOException
	 */
	public static MappedByteBuffer createMemoryBlock(int begin, int size) throws IOException {
		MappedByteBuffer mapBuf;
		mapBuf = fc.map(FileChannel.MapMode.READ_WRITE, begin, size);
		return mapBuf;
	}
}
