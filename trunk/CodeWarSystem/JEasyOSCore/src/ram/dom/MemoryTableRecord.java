package ram.dom;

import java.nio.MappedByteBuffer;

public class MemoryTableRecord {
	private int processId;
	private int begin;
	private int size;
	private MappedByteBuffer buffer;

	public MemoryTableRecord(int processId, int begin, int size, MappedByteBuffer buffer) {
		super();
		this.processId = processId;
		this.begin = begin;
		this.size = size;
		this.buffer = buffer;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public MappedByteBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(MappedByteBuffer buffer) {
		this.buffer = buffer;
	}

}