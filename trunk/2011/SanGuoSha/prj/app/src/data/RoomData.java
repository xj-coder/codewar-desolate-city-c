package data;

import java.util.ArrayList;

import bean.Player;

public class RoomData {
	private String name;// ��������
	private ModelData model;// ģʽ
	private boolean isChat;// �Ƿ���������
	private ArrayList<ExPackData> exPacks;// ��չ��
	private long waitTime;// ����ʱ��
	private int maxNum;// �������
	private int currNum;// ��ǰ����
	private int state;// ״̬
	private Player creator;// ������

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ModelData getModel() {
		return model;
	}

	public void setModel(ModelData model) {
		this.model = model;
	}

	public boolean isChat() {
		return isChat;
	}

	public void setChat(boolean isChat) {
		this.isChat = isChat;
	}

	public ArrayList<ExPackData> getExPacks() {
		return exPacks;
	}

	public void setExPacks(ArrayList<ExPackData> exPacks) {
		this.exPacks = exPacks;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public int getCurrNum() {
		return currNum;
	}

	public void setCurrNum(int currNum) {
		this.currNum = currNum;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Player getCreator() {
		return creator;
	}

	public void setCreator(Player creator) {
		this.creator = creator;
	}

}
