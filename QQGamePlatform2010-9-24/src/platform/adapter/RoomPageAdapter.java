package platform.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import platform.ui.index.page.RoomPage;
import platform.ui.index.page.RoomPageParams;

public class RoomPageAdapter implements ActionListener {

	private RoomPage page;

	public RoomPageAdapter(RoomPage page) {
		this.page = page;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(RoomPageParams.ACTION_CLOSE)) {
			page.getIndexUI().getTabbedPane().closeGameRoomTab(page);
		}
	}
}
