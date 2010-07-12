package ram.dom;

import java.util.ArrayList;

public class MemoryTable {
	private static ArrayList<MemoryTableRecord> records = new ArrayList<MemoryTableRecord>();

	public static void addRecord(MemoryTableRecord record) {
		for (int i = 0; i < records.size(); i++) {
			if (records.get(i).getBegin() > record.getBegin()) {
				records.add(i, record);
			}
		}
		records.add(record);
	}

	public static void delRecord(int processId) {
		for (int i = 0; i < records.size(); i++) {
			if (records.get(i).getProcessId() > processId) {
				records.remove(i);
			}
		}
	}

	public static void delRecord(MemoryTableRecord record) {
		records.remove(record);
	}

	public static void modifyRecord(MemoryTableRecord record) {
		for (int i = 0; i < records.size(); i++) {
			if (records.get(i).getProcessId() > record.getProcessId()) {
				records.get(i).setBegin(record.getBegin());
				records.get(i).setSize(record.getSize());
			}
		}
	}

	public static int findMemoryBlock(int size) {
		for (int i = 0; i < records.size() - 1; i++) {
			if (records.get(i + 1).getBegin() - records.get(i).getBegin() + records.get(i).getSize() > size) {
				return records.get(i).getBegin() + records.get(i).getSize();
			}
		}
		return records.get(records.size() - 1).getBegin() + records.get(records.size() - 1).getSize();
	}
}
