package c.city.desolate.codewar.code.ui.perspective;

/**
 * ∑øº‰Õ∏ ”Õº
 */
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import c.city.desolate.codewar.code.ui.view.PlayerListView;
import c.city.desolate.codewar.code.ui.view.ShowRoomView;

public class RoomPerspect implements IPerspectiveFactory {

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		// “˛≤ÿ±‡º≠«¯”Ú
		layout.setEditorAreaVisible(false);
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		layout.addView(ShowRoomView.ID, IPageLayout.LEFT, 0.2f, layout
				.getEditorArea());
		layout.addView(PlayerListView.ID, IPageLayout.RIGHT, 0.8f,
				ShowRoomView.ID);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
		System.currentTimeMillis();
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}
