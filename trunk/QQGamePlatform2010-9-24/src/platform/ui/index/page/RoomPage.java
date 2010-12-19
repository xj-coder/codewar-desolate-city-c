package platform.ui.index.page;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import platform.adapter.RoomPageAdapter;
import platform.bean.GameBean;
import platform.tools.ImageFactory;
import platform.tools.ImageTools;
import platform.ui.index.IndexUI;
import platform.ui.widget.BoxButton;
import platform.ui.widget.ImageLabel;
import platform.ui.widget.factory.WidgetFactory;

public class RoomPage extends Page {

	private static final long serialVersionUID = 8955162093186808818L;

	private JPanel tool_panel;// 工具栏
	private JPanel centerPanel;// 中心面板

	private JTextField room_info;// 房间信息显示区

	private ImageLabel room_info_label;

	private JButton copy_button;// 复制按钮
	private JButton quick_join_button;// 快速加入按钮
	private BoxButton opera_button;// 更多操作按钮
	private JButton close_button;// 关闭按钮

	private ImageLabel spliter_label;// 分割线

	private IndexUI indexUI;

	private GameBean gameBean;

	private RoomPageAdapter adapter = new RoomPageAdapter(this);

	public RoomPage(IndexUI indexUI, GameBean gameBean) {
		super();
		this.indexUI = indexUI;
		this.gameBean = gameBean;

		initUI();
	}

	private void initUI() {
		setLayout(null);

		add(getTool_panel());
		add(getCenterPanel());
	}

	// #begin【双缓冲技术】
	@Override
	public void paint(Graphics g) {
		System.out.println("paint RoomIndex");
		update(g);
	}

	@Override
	public void update(Graphics g) {
		Image screen = ImageTools.createImage(getWidth(), getHeight(), true);// 双缓冲
		Graphics graphics = screen.getGraphics();

		resetAllComponents();

		super.paint(graphics);

		g.drawImage(screen, 0, 0, null);// 最后个参数一定要用null，这样可以防止drawImage调用update方法
		g.dispose();
	}// #end【双缓冲技术】

	/**
	 * 作用:重新排列所有相对位置的元素 <BR>
	 * 
	 * 调用情况:当整个窗体发生大小变化时
	 */
	public void resetAllComponents() {
		resetTool_panel();
		resetCenterPanel();

		resetRoom_info();
		resetCopy_button();
		resetClose_button();
		resetSpliter_label();
		resetOpera_button();
	}

	public GameBean getGameBean() {
		return gameBean;
	}

	public JPanel getTool_panel() {
		if (tool_panel == null) {
			tool_panel = new JPanel();
			tool_panel.setLayout(null);

			tool_panel.add(getRoom_info_label());
			tool_panel.add(getRoom_info());
			tool_panel.add(getCopy_button());
			tool_panel.add(getOpera_button());
			tool_panel.add(getSpliter_label());
			tool_panel.add(getClose_button());

			resetTool_panel();
		}
		return tool_panel;
	}

	public void resetTool_panel() {
		getTool_panel().setBounds(0, 0, getWidth(), 30);
	}

	public JPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new JPanel();
			centerPanel.setBackground(Color.blue);

			resetCenterPanel();
		}
		return centerPanel;
	}

	public void resetCenterPanel() {
		getCenterPanel().setBounds(0, getTool_panel().getHeight(), getWidth(),
				getHeight() - getTool_panel().getHeight());
	}

	public ImageLabel getRoom_info_label() {
		if (room_info_label == null) {
			room_info_label = new ImageLabel(new ImageIcon(ImageFactory.getRoomPageInfoIcon()
					.getScaledInstance(3, 5, Image.SCALE_DEFAULT)));

			room_info_label.setBounds(5, 14, 5, 5);
		}
		return room_info_label;
	}

	public JTextField getRoom_info() {
		if (room_info == null) {
			room_info = new JTextField(gameBean.getShow_name());

			room_info.setBorder(null);
			room_info.setEditable(false);

			room_info.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {

				}

				@Override
				public void focusGained(FocusEvent e) {
					getRoom_info().selectAll();
				}
			});

			resetRoom_info();
		}
		return room_info;
	}

	public void resetRoom_info() {
		Graphics2D g2 = (Graphics2D) getRoom_info().getGraphics();

		if (g2 != null) {
			FontMetrics metrics = g2.getFontMetrics();
			int stringWidth = metrics.stringWidth(getRoom_info().getText());
			room_info.setBounds(12, 5, stringWidth, 22);
		}
	}

	public JButton getCopy_button() {
		if (copy_button == null) {
			copy_button = WidgetFactory.createRoomPageCopyButton(16, 16, "",
					RoomPageParams.ACTION_COPY, adapter);

			resetCopy_button();
		}
		return copy_button;
	}

	public void resetCopy_button() {
		copy_button.setBounds(getRoom_info().getX() + getRoom_info().getWidth() + 5, 8, 16, 16);
	}

	public BoxButton getOpera_button() {
		if (opera_button == null) {
			opera_button = new BoxButton(getQuick_join_button());

			resetOpera_button();
		}
		return opera_button;
	}

	public void resetOpera_button() {
		getOpera_button().setBounds(getSpliter_label().getX() - 120, 4, 98 + 16, 25);
	}

	public JButton getQuick_join_button() {
		if (quick_join_button == null) {
			quick_join_button = WidgetFactory.createRoomPageQuickJoinButton(98, 25, "",
					RoomPageParams.ACTION_COPY, adapter);
		}
		return quick_join_button;
	}

	public ImageLabel getSpliter_label() {
		if (spliter_label == null) {
			spliter_label = new ImageLabel(new ImageIcon(ImageFactory.getRoomPageSpliterImage()
					.getScaledInstance(1, 18, Image.SCALE_DEFAULT)));

			resetSpliter_label();
		}
		return spliter_label;
	}

	public void resetSpliter_label() {
		getSpliter_label().setBounds(getClose_button().getX() - 2 - 8, 8, 5, 20);
	}

	public JButton getClose_button() {
		if (close_button == null) {
			close_button = WidgetFactory.createRoomPageCloseButton(16, 16, "",
					RoomPageParams.ACTION_CLOSE, adapter);

			resetClose_button();
		}
		return close_button;
	}

	public void resetClose_button() {
		getClose_button().setBounds(getTool_panel().getWidth() - 16 - 8, 8, 16, 16);
	}

	public IndexUI getIndexUI() {
		return indexUI;
	}

	@Override
	public String getTitle() {
		return gameBean.getShow_name();
	}

	@Override
	public Image getTitleImage() {
		return gameBean.getMainImage();
	}

}