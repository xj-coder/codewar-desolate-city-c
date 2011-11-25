package widget.ex.list;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import data.RoomData;

/**
 * 
 * @author JHS
 * 
 *         TODO 房间列表
 */
public class RoomList extends JList {

	private static final long serialVersionUID = 5178110678703652658L;

	private final List<RoomData> roomDatas;

	private DefaultListModel model;

	public RoomList(List<RoomData> roomDatas) {
		this.roomDatas = roomDatas;
	}

	@Override
	public ListModel getModel() {
		if (model == null) {
			model = new DefaultListModel();
			for (int i = 0; i < roomDatas.size(); i++) {
				model.addElement(roomDatas.get(i));
			}
		}
		return model;
	}
}

class RoomListHeadUI extends JPanel {

	private static final long serialVersionUID = -5800334170972494944L;

}

class RoomListItemUI extends JPanel {

	private static final long serialVersionUID = -7196674972677820978L;

}

class RoomListBottomUI extends JPanel {

	private static final long serialVersionUID = -640086963008538501L;

}
