package ram.face;

import java.io.IOException;
import java.nio.MappedByteBuffer;

import ram.action.MemoryAction;
import ram.dom.MemoryTable;
import ram.dom.MemoryTableRecord;

/**
 * �ڴ����
 * 
 * @author JHS
 * 
 */
public class MemoryManager {
	public static String RAM_TEMP_FILE = "randomAccess.ram";

	public static int RAM_INIT_SIZE = 1024 * 1024 * 32;

	/**
	 * ������ʼλ��,����¼��MemoryTable��;<BR>
	 * �ڼ��������λ���ϴ���ָ����С���ڴ��
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
					// �ڴ����
				}
			}
		}
		MappedByteBuffer buffer = MemoryAction.createMemoryBlock(begin, size);

		MemoryTable.addRecord(new MemoryTableRecord(processId, begin, size, buffer));

		return buffer;
	}

	/**
	 * �����ڴ�
	 */
	public static void collateMemory() {

	}
}
