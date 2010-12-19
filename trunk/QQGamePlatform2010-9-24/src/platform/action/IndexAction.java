package platform.action;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Vector;

import platform.bean.CategoryBean;
import platform.bean.GameBean;
import platform.define.PathDefine;
import platform.define.RunTimeDefine;
import platform.exception.XMLException;
import platform.tools.Tools;
import platform.ui.widget.bean.QTableTreeItem;
import platform.ui.widget.tabletree.QTableTree;
import platform.ui.widget.tabletree.QTableTreeModel;
import platform.xml.parse.XMLParse;

public class IndexAction {

	/**
	 * 从服务器载入游戏列表，并更新到树上
	 * 
	 * @param tree
	 */
	public void loadGameDirTree(final QTableTree tree) {
		QTableTreeModel tableTreeModel = null;
		if (tree.getModel() instanceof QTableTreeModel) {
			tableTreeModel = (QTableTreeModel) tree.getModel();
		}
		if (tableTreeModel == null) {
			return;
		}

		if (RunTimeDefine.isAlone) {// 如果是单机登入,读取单机配置文件
			try {
				Vector<HashMap<String, String>> gameList = XMLParse
						.getKeyValueXml(PathDefine.GAME_LIST_FILE_PATH);
				Vector<HashMap<String, String>> categoryList = XMLParse
						.getKeyValueXml(PathDefine.CATEGORY_LIST_FILE_PATH);

				// 添加分类
				for (int i = 0; i < categoryList.size(); i++) {
					CategoryBean categoryBean = new CategoryBean();
					Tools.mapToBean(categoryList.get(i), categoryBean);

					QTableTreeItem item = new QTableTreeItem(categoryBean, true, Integer
							.parseInt(categoryBean.getOrder()));

					if (categoryBean.getParent().equals("0")) {
						System.err.println("add root category" + item);
						tableTreeModel.addElement(item);
					} else {
						for (int j = 0; j < tableTreeModel.getSize(); j++) {
							QTableTreeItem _item = (QTableTreeItem) tableTreeModel.getElementAt(j);
							if (_item.getUserObject() instanceof CategoryBean) {
								addItem(_item, item, categoryBean.getParent());
							}
						}
					}
				}

				// 添加游戏
				for (int i = 0; i < gameList.size(); i++) {
					GameBean gameBean = new GameBean();
					Tools.mapToBean(gameList.get(i), gameBean);

					// 载入游戏图标
					String url = PathDefine.RES_GAME_MAIN_PATH + gameBean.getGid() + ".png";
					gameBean.setMainImage(Toolkit.getDefaultToolkit().getImage(url));

					QTableTreeItem item = new QTableTreeItem(gameBean, true, Integer
							.parseInt(gameBean.getOrder()));

					for (int j = 0; j < tableTreeModel.getSize(); j++) {
						QTableTreeItem _item = (QTableTreeItem) tableTreeModel.getElementAt(j);
						if (_item.getUserObject() instanceof CategoryBean) {
							CategoryBean categoryBean = (CategoryBean) _item.getUserObject();

							if (categoryBean.getCid().equals(gameBean.getCategory())) {
								_item.addQTableTreeItem(item);
							} else {
								addItem(_item, item, gameBean.getCategory());
							}
						}
					}
				}
			} catch (XMLException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		} else {

		}
		tree.updateUI();
	}

	private boolean addItem(QTableTreeItem f_item, QTableTreeItem t_item, String parent) {

		CategoryBean bean = (CategoryBean) f_item.getUserObject();
		if (bean.getCid().equals(parent)) {
			System.err.println("add " + t_item);
			f_item.addQTableTreeItem(t_item);
			return true;
		}

		for (int i = 0; i < f_item.getChildCount(); i++) {
			QTableTreeItem _item = f_item.getItemAt(i);
			if (_item.getUserObject() instanceof CategoryBean) {
				if (addItem(_item, t_item, parent)) {
					return true;
				}
			}
		}
		return false;
	}

}
