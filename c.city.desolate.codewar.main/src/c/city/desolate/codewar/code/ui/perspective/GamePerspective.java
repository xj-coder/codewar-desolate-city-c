package c.city.desolate.codewar.code.ui.perspective;

/**
 * ”Œœ∑Õ∏ ”Õº
 */
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import c.city.desolate.codewar.code.ui.view.CodeEditorView;
import c.city.desolate.codewar.code.ui.view.ConsoleView;
import c.city.desolate.codewar.code.ui.view.FileExplorerView;
import c.city.desolate.codewar.code.ui.view.PlayGameView;

public class GamePerspective implements IPerspectiveFactory {
	public static final String ID = "c.city.desolate.codewar.code.perspective.game";

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		// “˛≤ÿ±‡º≠«¯”Ú
		layout.setEditorAreaVisible(false);
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		layout.addView(PlayGameView.ID, IPageLayout.LEFT, 0.4f, layout
				.getEditorArea());
		layout.addView(CodeEditorView.ID, IPageLayout.RIGHT, 0.45f,
				PlayGameView.ID);
		layout.addView(FileExplorerView.ID, IPageLayout.RIGHT, 0.8f,
				CodeEditorView.ID);
		layout.addView(ConsoleView.ID, IPageLayout.BOTTOM, 0.8f,
				CodeEditorView.ID);
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
