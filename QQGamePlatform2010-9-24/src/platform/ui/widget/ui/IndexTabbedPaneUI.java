package platform.ui.widget.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

import platform.tools.ImageFactory;

public class IndexTabbedPaneUI extends BasicTabbedPaneUI {

	private Color borderColor;

	public IndexTabbedPaneUI() {
		super();
	}

	/**
	 * 画tab背景图
	 */
	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		Image bg_image = null;
		if (isSelected) {
			bg_image = ImageFactory.getIndexTabBackgroundPressed(w, h);
		} else {
			if (tabIndex == getRolloverTab()) {
				bg_image = ImageFactory.getIndexTabBackgroundRollover(w, h);
			} else {
				bg_image = ImageFactory.getIndexTabBackground(w, h);
			}
		}

		switch (tabPlacement) {
		case TOP:
			g.drawImage(bg_image, x, 0, null);// 草
		}

	}

	@Override
	protected LayoutManager createLayoutManager() {
		return new BasicTabbedPaneUI.TabbedPaneLayout() {
			@Override
			protected void calculateTabRects(int tabPlacement, int tabCount) {
				super.calculateTabRects(tabPlacement, tabCount);
				setRec(1);// 设置间距

			}

			public void setRec(int rec) {
				for (int i = 0; i < rects.length; i++) {
					rects[i].x = rects[i].x + rec * i;
				}
			}

		};

	}// 设置Layout

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

}
