package c.city.desolate.codewar.code.ui.view;
/**
 * ������ʾview
 */
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.ViewPart;

import c.city.desolate.codewar.code.main.Activator;
import c.city.desolate.codewar.code.main.Param;
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
		Composite container = new Composite(parent, SWT.NONE);
		setPartName("Room-"+Param.game.getName());
		//
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
					getSite().getPage().close();//�رյ�ǰ͸��ͼ
					PlatformUI.getWorkbench()
					.showPerspective(HallPerspective.ID,
							PlatformUI.getWorkbench().getActiveWorkbenchWindow());//�򿪴���͸��ͼ
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
