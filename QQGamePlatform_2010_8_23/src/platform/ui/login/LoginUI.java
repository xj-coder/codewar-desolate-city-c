package platform.ui.login;

/**
 * 登入界面
 * 
 *  @author DesolateCity
 */

import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import platform.tools.Tools;
import platform.ui.focustraversalpolicy.QFocusTraversalPolicy;
import platform.ui.widget.URLLabel;
import platform.ui.widget.WidgetFactory;

import com.sun.awt.AWTUtilities;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = -3745375316666171374L;

	private JLabel bg_up_label;
	private JLabel bg_center_label;
	private JLabel bg_down_label;
	private JLabel banner_label;
	private JLabel login_processbar_out_label;
	private JLabel login_processbar_in_label;
	private JLabel login_processbar_bg_label;
	private JLabel info_label;
	private JLabel account_label;
	private JLabel password_label;

	private JButton close_button;
	private JButton help_button;
	private JButton login_button;
	private JButton set_button;

	private URLLabel register_account_urllabel;
	private URLLabel get_back_password_urllabel;
	private URLLabel article_urllabel;

	private JComboBox account_input;
	private JPasswordField password_input;
	private JCheckBox memory_check;
	private JCheckBox hide_check;
	private JCheckBox agree_check;

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
		comps.add(getHide_check());
		comps.add(getAgree_check());
		qFocusTraversalPolicy = new QFocusTraversalPolicy(comps);
		setFocusTraversalPolicy(qFocusTraversalPolicy);
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

		getLayeredPane().add(getLogin_processbar_out_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getLogin_processbar_in_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getLogin_processbar_bg_label(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getInfo_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getAccount_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getPassword_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getAccount_input(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getMemory_check(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getHide_check(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getAgree_check(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getArticle_urllabel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getGet_back_password_urllabel(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getRegister_account_urllabel(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getBanner_label(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getSet_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getLogin_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getPassword_input(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getBg_up_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_down_label(), new Integer(Integer.MIN_VALUE));

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
							x = (getLogin_processbar_in_label().getX() + 1) % (LoginUIDefine.FRAME_WIDTH - getLogin_processbar_in_label().getWidth());
							y = getLogin_processbar_in_label().getY();
							getLogin_processbar_in_label().setLocation(x, y);
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
	public JLabel getBg_up_label() {
		if (bg_up_label == null) {
			bg_up_label = new JLabel(new ImageIcon(ImageFactory.getLoginBgUpImage().getScaledInstance(355, 130, Image.SCALE_DEFAULT)));
			bg_up_label.setBounds(0, 0, 355, 130);
		}
		return bg_up_label;
	}

	public JLabel getBg_center_label() {
		if (bg_center_label == null) {
			bg_center_label = new JLabel(new ImageIcon(ImageFactory.getLoginBgCenterImage().getScaledInstance(355, 40, Image.SCALE_DEFAULT)));
			bg_center_label.setBounds(0, 130, 355, 40);
		}
		return bg_center_label;
	}

	public JLabel getBg_down_label() {
		if (bg_down_label == null) {
			bg_down_label = new JLabel(new ImageIcon(ImageFactory.getLoginBgDownImage().getScaledInstance(355, 70, Image.SCALE_DEFAULT)));
			bg_down_label.setBounds(0, 170, 355, 70);
		}
		return bg_down_label;
	}

	public JLabel getBanner_label() {
		if (banner_label == null) {
			banner_label = new JLabel(new ImageIcon(ImageFactory.getLoginBannerImage().getScaledInstance(351, 70, Image.SCALE_DEFAULT)));
			banner_label.setName("banner_label");
			banner_label.setBounds(2, 25, 350, 70);
		}
		return banner_label;
	}

	public JLabel getLogin_processbar_in_label() {
		if (login_processbar_in_label == null) {
			login_processbar_in_label = new JLabel(new ImageIcon(ImageFactory.getLoginProcessbarInImage().getScaledInstance(75, 4, Image.SCALE_DEFAULT)));
			login_processbar_in_label.setBounds((int) Math.random() * (355 - 75), 95, 75, 4);
		}
		return login_processbar_in_label;
	}

	public JLabel getLogin_processbar_out_label() {
		if (login_processbar_out_label == null) {
			login_processbar_out_label = new JLabel(new ImageIcon(ImageFactory.getLoginProcessbarOutImage().getScaledInstance(355, 4, Image.SCALE_DEFAULT)));
			login_processbar_out_label.setBounds(0, 95, 355, 4);
		}
		return login_processbar_out_label;
	}

	public JLabel getLogin_processbar_bg_label() {
		if (login_processbar_bg_label == null) {
			login_processbar_bg_label = new JLabel(new ImageIcon(ImageFactory.getLoginProcessbarBgImage().getScaledInstance(355, 4, Image.SCALE_SMOOTH)));
			login_processbar_bg_label.setBounds(0, 95, 355, 4);
		}
		return login_processbar_bg_label;
	}

	public JLabel getInfo_label() {
		if (info_label == null) {
			info_label = new JLabel("请输入账号和密码∶");
			info_label.setBounds(20, 105, 120, 15);
			info_label.setFont(Define.DEFAULT_FONT);
		}
		return info_label;
	}

	public JLabel getAccount_label() {
		if (account_label == null) {
			account_label = new JLabel("账号∶");
			account_label.setFont(Define.DEFAULT_FONT);
			account_label.setFont(Define.DEFAULT_FONT);
			account_label.setBounds(20, 125, 40, 20);
		}
		return account_label;
	}

	public JLabel getPassword_label() {
		if (password_label == null) {
			password_label = new JLabel("密码∶");
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

	public JCheckBox getHide_check() {
		if (hide_check == null) {
			hide_check = WidgetFactory.createCheckBox("隐身登录");
			hide_check.setBounds(140, 180, 80, 20);
		}
		return hide_check;
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
	public URLLabel getRegister_account_urllabel() {
		if (register_account_urllabel == null) {
			register_account_urllabel = new URLLabel("申请账号");
			register_account_urllabel.setFont(Define.DEFAULT_FONT);
			register_account_urllabel.setForeground(LoginUIDefine.URLLABEL_FONT_COLOR);

			register_account_urllabel.setBounds(290, 125, 80, 20);
		}
		return register_account_urllabel;
	}

	public URLLabel getGet_back_password_urllabel() {
		if (get_back_password_urllabel == null) {
			get_back_password_urllabel = new URLLabel("忘了密码？");
			get_back_password_urllabel.setFont(Define.DEFAULT_FONT);
			get_back_password_urllabel.setForeground(LoginUIDefine.URLLABEL_FONT_COLOR);

			get_back_password_urllabel.setBounds(290, 152, 80, 20);
		}
		return get_back_password_urllabel;
	}

	public URLLabel getArticle_urllabel() {
		if (article_urllabel == null) {
			article_urllabel = new URLLabel("同意条款");
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
		new LoginUI().showMe();
	}
}
