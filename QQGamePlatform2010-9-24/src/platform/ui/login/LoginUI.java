package platform.ui.login;

/**
 * 登入界面
 * 
 *  @author DesolateCity
 */

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import org.eclipse.swt.extension.hook.Hook;

import platform.adapter.LoginButtonActionAdapter;
import platform.adapter.LoginKeyBoardHookAdapter;
import platform.adapter.UIMouseDragAdapter;
import platform.define.Define;
import platform.define.LoginUIDefine;
import platform.tools.ImageFactory;
import platform.tools.LookAndFeel;
import platform.tools.Tools;
import platform.ui.focustraversalpolicy.QFocusTraversalPolicy;
import platform.ui.widget.ImageLabel;
import platform.ui.widget.ImagePanel;
import platform.ui.widget.URLLabelUI;
import platform.ui.widget.factory.WidgetFactory;

import com.sun.awt.AWTUtilities;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = -3745375316666171374L;

	private ImagePanel bg_up_image_panel;
	private ImagePanel bg_center_image_panel;
	private ImagePanel bg_down_image_panel;
	private ImagePanel banner_image_panel;
	private ImagePanel login_processbar_out_image_panel;
	private ImagePanel login_processbar_in_image_panel;
	private ImagePanel login_processbar_bg_image_panel;

	private ImageLabel info_label;
	private ImageLabel account_label;
	private ImageLabel password_label;

	private JButton close_button;// 关闭按钮
	private JButton help_button;// 帮助按钮
	private JButton login_button;// 登入按钮
	private JButton set_button;// 设置按钮

	private URLLabelUI register_account_urllabel;// 注册链接
	private URLLabelUI get_back_password_urllabel;// 找回密码链接
	private URLLabelUI article_urllabel;// 条款链接

	private JComboBox account_input;// 用户名输入框
	private JPasswordField password_input;// 密码输入框
	private JCheckBox memory_check;// 记住账户号选择框
	private JCheckBox alone_check;// 单机登入选择框
	private JCheckBox agree_check;// 同意条款选择框

	private final LoginKeyBoardHookAdapter keyActionAdapter = new LoginKeyBoardHookAdapter(this);
	private final UIMouseDragAdapter mouseAdapter = new UIMouseDragAdapter(this);
	private final LoginButtonActionAdapter actionAdapter = new LoginButtonActionAdapter(this);

	private final QFocusTraversalPolicy qFocusTraversalPolicy;

	private boolean isLoginProcessStart = false;

	public LoginUI() {
		initComponents();

		// 注册键盘钩子
		registerKeyBoardHook();

		// 设置Tab顺序
		Vector<Component> comps = new Vector<Component>();
		comps.add(getAccount_input().getComponent(1));
		comps.add(getPassword_input());
		comps.add(getMemory_check());
		comps.add(getAlone_check());
		comps.add(getAgree_check());
		qFocusTraversalPolicy = new QFocusTraversalPolicy(comps);
		setFocusTraversalPolicy(qFocusTraversalPolicy);
	}

	// #begin【双缓冲技术】
	@Override
	public void paint(Graphics g) {
		System.out.println("paint LoginUI");
		super.paint(g);
	}

	public void registerKeyBoardHook() {
		Hook.KEYBOARD.addListener(keyActionAdapter);

		if (!Hook.KEYBOARD.isInstalled()) {
			Hook.KEYBOARD.install();
		}
	}

	public void unRegisterKeyBoardHook() {
		Hook.KEYBOARD.removeListener(keyActionAdapter);
	}

	private void initComponents() {
		setResizable(false);
		setSize(LoginUIDefine.FRAME_WIDTH, LoginUIDefine.FRAME_HEIGHT);
		setLocation(Tools.getScreenSize().width / 2 - getWidth() / 2, (int) (Tools.getScreenSize().getHeight() / 2 - getHeight() / 2));

		getLayeredPane().add(getHelp_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getClose_button(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getLogin_processbar_out_image_panel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getLogin_processbar_in_image_panel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getLogin_processbar_bg_image_panel(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getInfo_image_panel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getAccount_image_panel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getPassword_image_panel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getAccount_input(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getMemory_check(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getAlone_check(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getAgree_check(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getArticle_urllabel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getGet_back_password_urllabel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getRegister_account_urllabel(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getBanner_image_panel(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getSet_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getLogin_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getPassword_input(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getBg_up_image_panel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_center_image_panel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_down_image_panel(), new Integer(Integer.MIN_VALUE));

		((JPanel) getContentPane()).setOpaque(false);

		setUndecorated(true);
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}

	public void showMe() {
		setVisible(true);

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				AWTUtilities.setWindowShape(LoginUI.this, new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 8, 8));
				// AWTUtilities.setWindowOpacity(LoginUI.this, 0.93f);
			}
		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int x;
					int y;
					while (true) {
						if (isLoginProcessStart) {
							Thread.sleep(8);
							x = (getLogin_processbar_in_image_panel().getX() + 1) % (LoginUIDefine.FRAME_WIDTH - getLogin_processbar_in_image_panel().getWidth());
							y = getLogin_processbar_in_image_panel().getY();
							getLogin_processbar_in_image_panel().setLocation(x, y);
						} else {
							Thread.sleep(15);
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	// label
	public ImagePanel getBg_up_image_panel() {
		if (bg_up_image_panel == null) {
			bg_up_image_panel = new ImagePanel(ImageFactory.getLoginBgUpImage().getScaledInstance(355, 130, Image.SCALE_DEFAULT));
			bg_up_image_panel.setBounds(0, 0, 355, 130);
		}
		return bg_up_image_panel;
	}

	public ImagePanel getBg_center_image_panel() {
		if (bg_center_image_panel == null) {
			bg_center_image_panel = new ImagePanel(ImageFactory.getLoginBgCenterImage().getScaledInstance(355, 40, Image.SCALE_DEFAULT));
			bg_center_image_panel.setBounds(0, 130, 355, 40);
		}
		return bg_center_image_panel;
	}

	public ImagePanel getBg_down_image_panel() {
		if (bg_down_image_panel == null) {
			bg_down_image_panel = new ImagePanel(ImageFactory.getLoginBgDownImage().getScaledInstance(355, 70, Image.SCALE_DEFAULT));
			bg_down_image_panel.setBounds(0, 170, 355, 70);
		}
		return bg_down_image_panel;
	}

	public ImagePanel getBanner_image_panel() {
		if (banner_image_panel == null) {
			banner_image_panel = new ImagePanel(ImageFactory.getLoginBannerImage().getScaledInstance(351, 70, Image.SCALE_DEFAULT));
			banner_image_panel.setName("banner_image_panel");
			banner_image_panel.setBounds(2, 25, 350, 70);
		}
		return banner_image_panel;
	}

	public ImagePanel getLogin_processbar_in_image_panel() {
		if (login_processbar_in_image_panel == null) {
			login_processbar_in_image_panel = new ImagePanel(ImageFactory.getLoginProcessbarInImage().getScaledInstance(75, 4, Image.SCALE_DEFAULT));
			login_processbar_in_image_panel.setBounds((int) Math.random() * (355 - 75), 95, 75, 4);
		}
		return login_processbar_in_image_panel;
	}

	public ImagePanel getLogin_processbar_out_image_panel() {
		if (login_processbar_out_image_panel == null) {
			login_processbar_out_image_panel = new ImagePanel(ImageFactory.getLoginProcessbarOutImage().getScaledInstance(355, 4, Image.SCALE_DEFAULT));
			login_processbar_out_image_panel.setBounds(0, 95, 355, 4);
		}
		return login_processbar_out_image_panel;
	}

	public ImagePanel getLogin_processbar_bg_image_panel() {
		if (login_processbar_bg_image_panel == null) {
			login_processbar_bg_image_panel = new ImagePanel(ImageFactory.getLoginProcessbarBgImage().getScaledInstance(355, 4, Image.SCALE_SMOOTH));
			login_processbar_bg_image_panel.setBounds(0, 95, 355, 4);
		}
		return login_processbar_bg_image_panel;
	}

	public ImageLabel getInfo_image_panel() {
		if (info_label == null) {
			info_label = new ImageLabel("请输入账号和密码∶");
			info_label.setBounds(20, 105, 120, 15);
			info_label.setFont(Define.DEFAULT_FONT);
		}
		return info_label;
	}

	public ImageLabel getAccount_image_panel() {
		if (account_label == null) {
			account_label = new ImageLabel("账号∶");
			account_label.setFont(Define.DEFAULT_FONT);
			account_label.setFont(Define.DEFAULT_FONT);
			account_label.setBounds(20, 125, 40, 20);
		}
		return account_label;
	}

	public ImageLabel getPassword_image_panel() {
		if (password_label == null) {
			password_label = new ImageLabel("密码∶");
			password_label.setFont(Define.DEFAULT_FONT);
			password_label.setBounds(20, 152, 40, 20);
		}
		return password_label;
	}

	// button
	public JButton getClose_button() {
		if (close_button == null) {
			close_button = WidgetFactory.createLoginCloseButton(40, 22, "", LoginParams.ACTION_CLOSE, actionAdapter);
			close_button.setBounds(300, 1, 40, 22);
		}
		return close_button;
	}

	public JButton getHelp_button() {
		if (help_button == null) {
			help_button = WidgetFactory.createHelpButton(21, 22, "", LoginParams.ACTION_HELP, actionAdapter);
			help_button.setBounds(275, 0, 21, 22);
		}
		return help_button;
	}

	public JButton getLogin_button() {
		if (login_button == null) {
			login_button = WidgetFactory.createLoginButton(80, 25, LoginParams.NAME_LOGIN, LoginParams.ACTION_LOGIN, actionAdapter);
			login_button.setBounds(270, 208, 80, 25);
		}
		return login_button;
	}

	public JButton getSet_button() {
		if (set_button == null) {
			set_button = WidgetFactory.createButton(80, 25, LoginParams.NAME_SETTING, LoginParams.ACTION_SETTING, actionAdapter);
			set_button.setBounds(20, 208, 80, 25);
		}
		return set_button;
	}

	// input
	public JComboBox getAccount_input() {
		if (account_input == null) {
			account_input = new JComboBox();
			account_input.setEditable(true);

			account_input.setUI(new BasicComboBoxUI() {
				@Override
				public void addEditor() {
					super.addEditor();
				}

				@Override
				protected JButton createArrowButton() {
					return WidgetFactory.createLoginAccountInputButton(16, 16, "", "", null);
				}

				@Override
				protected ComboPopup createPopup() {
					ComboPopup comboPopup = new BasicComboPopup(comboBox) {
						private static final long serialVersionUID = 1821775763677238192L;

						@Override
						protected Rectangle computePopupBounds(int px, int py, int pw, int ph) {
							Rectangle rectangle = super.computePopupBounds(px, py, pw, ph);
							if (rectangle.height < 100) {
								rectangle.height = 100;
							}
							return rectangle;
						}
					};
					return comboPopup;
				}

				@Override
				protected FocusListener createFocusListener() {
					return new FocusListener() {

						@Override
						public void focusLost(FocusEvent e) {
						}

						@Override
						public void focusGained(FocusEvent e) {
							account_input.getEditor().selectAll();
						}
					};
				}
			});
			account_input.setFont(Define.DEFAULT_FONT);
			account_input.setBorder(new LineBorder(LoginUIDefine.INPUT_BORDER_LINE_COLOR));

			account_input.setBounds(60, 125, 220, 20);
		}
		return account_input;
	}

	public JPasswordField getPassword_input() {
		if (password_input == null) {
			password_input = new JPasswordField();
			password_input.setEchoChar('*');
			password_input.setFont(Define.DEFAULT_FONT);
			password_input.setBorder(new LineBorder(LoginUIDefine.INPUT_BORDER_LINE_COLOR));

			password_input.setBounds(60, 152, 220, 20);
		}
		return password_input;
	}

	// check box
	public JCheckBox getMemory_check() {
		if (memory_check == null) {
			memory_check = WidgetFactory.createCheckBox("记住密码");
			memory_check.setBounds(50, 180, 80, 20);
		}
		return memory_check;
	}

	public JCheckBox getAlone_check() {
		if (alone_check == null) {
			alone_check = WidgetFactory.createCheckBox("单机登录");
			alone_check.setBounds(140, 180, 80, 20);
		}
		return alone_check;
	}

	public JCheckBox getAgree_check() {
		if (agree_check == null) {
			agree_check = WidgetFactory.createCheckBox("");
			agree_check.setBounds(220, 180, 20, 20);
			agree_check.setSelected(true);
		}
		return agree_check;
	}

	// urlLabel
	public URLLabelUI getRegister_account_urllabel() {
		if (register_account_urllabel == null) {
			register_account_urllabel = new URLLabelUI("申请账号");
			register_account_urllabel.setFont(Define.DEFAULT_FONT);
			register_account_urllabel.setForeground(LoginUIDefine.URLLABEL_FONT_COLOR);

			register_account_urllabel.setBounds(290, 125, 80, 20);
		}
		return register_account_urllabel;
	}

	public URLLabelUI getGet_back_password_urllabel() {
		if (get_back_password_urllabel == null) {
			get_back_password_urllabel = new URLLabelUI("忘了密码？");
			get_back_password_urllabel.setFont(Define.DEFAULT_FONT);
			get_back_password_urllabel.setForeground(LoginUIDefine.URLLABEL_FONT_COLOR);

			get_back_password_urllabel.setBounds(290, 152, 80, 20);
		}
		return get_back_password_urllabel;
	}

	public URLLabelUI getArticle_urllabel() {
		if (article_urllabel == null) {
			article_urllabel = new URLLabelUI("同意条款");
			article_urllabel.setForeground(LoginUIDefine.URLLABEL_FONT_COLOR);

			article_urllabel.setBounds(241, 180, 60, 20);

			// test
			try {
				article_urllabel.setUrl(new URL("http://www.baidu.com"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return article_urllabel;
	}

	// getter and setter
	public void setLoginProcessStart(boolean isLoginProcessStart) {
		this.isLoginProcessStart = isLoginProcessStart;
	}

	public boolean isLoginProcessStart() {
		return isLoginProcessStart;
	}

	// test main
	public static void main(String[] args) {
		LookAndFeel.installDefaultLookAndFeel();

		new LoginUI().showMe();
	}
}
