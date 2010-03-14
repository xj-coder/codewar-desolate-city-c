package c.city.desolate.codewar.code.ui.perspective;

/**
 * ´óÌüÍ¸ÊÓÍ¼
 */
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import c.city.desolate.codewar.code.ui.view.GameListView;
import c.city.desolate.codewar.code.ui.view.IndexShowView;

public class HallPerspective implements IPerspectiveFactory {
	public static final String ID = "c.city.desolate.codewar.code.perspective.hall";

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		// String editorArea = layout.getEditorArea();
		// Òþ²Ø±à¼­ÇøÓò
		layout.setEditorAreaVisible(false);
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		layout.addView(GameListView.ID, IPageLayout.LEFT, 0.5f, layout
				.getEditorArea());
		layout.addView(IndexShowView.ID, IPageLayout.RIGHT, 0.2f,
				GameListView.ID);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
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
