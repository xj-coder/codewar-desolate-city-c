package c.city.desolate.codewar.code.main;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	public static final String HALL_PERSPECTIVE_ID = "c.city.desolate.codewar.code.perspective.hall";
	public static final String GAME_PERSPECTIVE_ID = "c.city.desolate.codewar.code.perspective.game";

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	@Override
	public String getInitialWindowPerspectiveId() {
		return HALL_PERSPECTIVE_ID;
	}

	@Override
	public void postStartup() {
		super.postStartup();
		// IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
		// .getActiveWorkbenchWindow();
		// 设置同时显示多个透视图标
		// PerspectiveBarManager barManager = ((WorkbenchWindow)
		// activeWorkbenchWindow)
		// .getPerspectiveBar();
		// if (barManager != null) {
		// IPerspectiveDescriptor gamePerspective = WorkbenchPlugin
		// .getDefault().getPerspectiveRegistry()
		// .findPerspectiveWithId(GAME_PERSPECTIVE_ID);
		// PerspectiveBarContributionItem gameItem = new
		// PerspectiveBarContributionItem(
		// gamePerspective, activeWorkbenchWindow.getActivePage());
		// IPerspectiveDescriptor hallPerspective = WorkbenchPlugin
		// .getDefault().getPerspectiveRegistry()
		// .findPerspectiveWithId(HALL_PERSPECTIVE_ID);
		// PerspectiveBarContributionItem hallItem = new
		// PerspectiveBarContributionItem(
		// hallPerspective, activeWorkbenchWindow.getActivePage());
		// barManager.addItem(hallItem);
		// barManager.addItem(gameItem);
		// }
	}
}
