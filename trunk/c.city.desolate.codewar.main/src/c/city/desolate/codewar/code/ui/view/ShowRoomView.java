package c.city.desolate.codewar.code.ui.view;
/**
 * 房间显示view
 */
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.ViewPart;

import c.city.desolate.codewar.code.bean.RoomData;
import c.city.desolate.codewar.code.main.Activator;
import c.city.desolate.codewar.code.main.Param;
import c.city.desolate.codewar.code.service.action.RoomAction;
import c.city.desolate.codewar.code.ui.perspective.HallPerspective;

import com.swtdesigner.ResourceManager;

public class ShowRoomView extends ViewPart {

	public static final String ID = "c.city.desolate.codewar.code.ui.view.ShowRoomView"; //$NON-NLS-1$
	private Action backHall;
	/**
	 * Create contents of the view part
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		String roomName = Param.game.getName();
		String roomGID = Param.game.getGID();
		
		Composite container = new Composite(parent, SWT.NONE);
		setPartName("Room-"+roomName);

		RoomData roomData = RoomAction.getRoomData(roomGID);
		
		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions
	 */
	private void createActions() {
		backHall = new Action("BackHall") {
			public void run() {
				try {
					getSite().getPage().close();//关闭当前透视图
					PlatformUI.getWorkbench()
					.showPerspective(HallPerspective.ID,
							PlatformUI.getWorkbench().getActiveWorkbenchWindow());//打开大厅透视图
				} catch (WorkbenchException e) {
					e.printStackTrace();
				}
			}
		};
		backHall.setImageDescriptor(ResourceManager.getPluginImageDescriptor(Activator.getDefault(), "icons/backhall_y.gif"));
		backHall.setToolTipText("BackHall");
	}

	/**
	 * Initialize the toolbar
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
		
		toolbarManager.add(backHall);
	}

	/**
	 * Initialize the menu
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
		
		menuManager.add(backHall);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
