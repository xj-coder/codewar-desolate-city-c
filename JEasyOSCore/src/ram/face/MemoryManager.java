package ram.face;

import java.io.IOException;
import java.nio.MappedByteBuffer;

import ram.action.MemoryAction;
import ram.dom.MemoryTable;
import ram.dom.MemoryTableRecord;

/**
 * 内存管理
 * 
 * @author JHS
 * 
 */
public class MemoryManager {
	public static String RAM_TEMP_FILE = "randomAccess.ram";

	public static int RAM_INIT_SIZE = 1024 * 1024 * 32;

	/**
	 * 计算起始位置,并记录到MemoryTable中;<BR>
	 * 在计算出来的位置上创建指定大小的内存块
	 * 
	 * @param size
	 * @return
	 * @throws IOException
	 */
	public static MappedByteBuffer createMemoryBlock(int processId, int size) throws IOException {
		int begin = MemoryTable.findMemoryBlock(size);
		if (begin + size > RAM_INIT_SIZE * 2 / 3) {
			collateMemory();
			begin = MemoryTable.findMemoryBlock(size);
			if (begin + size > RAM_INIT_SIZE) {
				collateMemory();
				begin = MemoryTable.findMemoryBlock(size);
				if (begin + size > RAM_INIT_SIZE) {
					// 内存溢出
				}
			}
		}
		MappedByteBuffer buffer = MemoryAction.createMemoryBlock(begin, size);

		MemoryTable.addRecord(new MemoryTableRecord(processId, begin, size, buffer));

		return buffer;
	}

	/**
	 * 整理内存
	 */
	public static void collateMemory() {

	}
}
