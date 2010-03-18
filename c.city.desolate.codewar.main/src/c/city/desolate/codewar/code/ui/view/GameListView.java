package c.city.desolate.codewar.code.ui.view;

/**
 * 游戏列表view
 */
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.ViewPart;

import c.city.desolate.codewar.code.main.Activator;
import c.city.desolate.codewar.code.main.Param;
import c.city.desolate.codewar.code.service.action.HallAction;
import c.city.desolate.codewar.code.ui.bean.GameEO;
import c.city.desolate.codewar.code.ui.bean.GameTreeElement;
import c.city.desolate.codewar.code.ui.perspective.RoomPerspective;
import c.city.desolate.codewar.code.ui.provider.GameListLabelProvider;
import c.city.desolate.codewar.code.ui.provider.GameListTreeContentprovider;

import com.swtdesigner.ResourceManager;

public class GameListView extends ViewPart {

	private TreeViewer tree;// 游戏列表数据
	private Action refleshAction;
	public static final String ID = "c.city.desolate.codewar.code.ui.view.GameListView"; //$NON-NLS-1$

	/**
	 * Create contents of the view part
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.VERTICAL));

		tree = new TreeViewer(container, SWT.BORDER);
		tree.setContentProvider(new GameListTreeContentprovider());
		tree.setLabelProvider(new GameListLabelProvider());
		tree.setInput(HallAction.getGameList());
		tree.addSelectionChangedListener(new ISelectionChangedListener(){//单击事件

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				GameTreeElement element = getSelectionElement();
				if(element instanceof GameEO){
					IViewPart viewPart = getSite().getPage().findView(IndexShowView.ID);//获得indexShowView
					Assert.isNotNull(viewPart);//确保找到view
					IndexShowView view = (IndexShowView) viewPart;
					view.getBrowser().setUrl(((GameEO)element).getIndexUrl());
					view.getBrowser().refresh();
				}
			}
		});
		tree.addDoubleClickListener(new IDoubleClickListener(){

			@Override
			public void doubleClick(DoubleClickEvent event) {
				GameTreeElement element = getSelectionElement();
				if(element instanceof GameEO){
					GameEO gameEO = (GameEO) element;
					Param.game.setName(gameEO.getName());
					Param.game.setGID(gameEO.getGID());
				
					try {
						PlatformUI.getWorkbench()
							.showPerspective(RoomPerspective.ID,
									PlatformUI.getWorkbench().getActiveWorkbenchWindow());
					} catch (WorkbenchException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
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
				tree.setInput(HallAction.getGameList());
				tree.refresh();
			}
		};
		refleshAction.setImageDescriptor(ResourceManager.getPluginImageDescriptor(Activator.getDefault(), "icons/refresh_y.gif"));
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
	public GameTreeElement getSelectionElement(){
		IStructuredSelection selection = (IStructuredSelection) tree.getSelection();
		if(selection.size()!=1)
			return null;
		return (GameTreeElement) selection.getFirstElement();
	}
}
