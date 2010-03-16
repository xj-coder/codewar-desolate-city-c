package c.city.desolate.codewar.code.ui.view;

/**
 * ´óÌüÊ×Ò³view
 */

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import c.city.desolate.codewar.code.main.Activator;

import com.swtdesigner.ResourceManager;

public class IndexShowView extends ViewPart {

	private Browser browser ;
	private Action refleshAction;
	public static final String ID = "c.city.desolate.codewar.code.ui.view.IndexShowView"; //$NON-NLS-1$

	/**
	 * Create contents of the view part
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.EMBEDDED);
		container.setLayout(new FillLayout());
		browser = new Browser(container, SWT.NONE);
		browser.setUrl("http://www.baidu.com");
		//
		
		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions
	 */
	private void createActions() {

		refleshAction = new Action("Reflesh") {
			public void run() {
				browser.refresh();
			}
		};
		refleshAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor(Activator.getDefault(), "icons/refresh_a.gif"));
		refleshAction.setToolTipText("Reflesh");

	}

	/**
	 * Initialize the toolbar
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
		
		toolbarManager.add(refleshAction);
	}

	/**
	 * Initialize the menu
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();

		menuManager.add(refleshAction);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
