package data;

import java.util.ArrayList;

import bean.Player;

public class RoomData {
	private String name;// 房间名字
	private ModelData model;// 模式
	private boolean isChat;// 是否允许聊天
	private ArrayList<ExPackData> exPacks;// 扩展包
	private long waitTime;// 出手时间
	private int maxNum;// 最大人数
	private int currNum;// 当前人数
	private int state;// 状态
	private Player creator;// 创建者

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
