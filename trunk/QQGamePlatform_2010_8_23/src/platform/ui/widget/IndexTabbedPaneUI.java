package platform.ui.widget;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

import platform.tools.ImageFactory;

public class IndexTabbedPaneUI extends BasicTabbedPaneUI {

	public IndexTabbedPaneUI() {
	}

	/**
	 * 画tab背景图
	 */
	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement,
			int tabIndex, int x, int y, int w, int h, boolean isSelected) {
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
			g.drawImage(bg_image, x - 3, 3, tabPane);
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
					rects[i].y = rects[i].y + 3;
				}
			}

		};

	}// 设置Layout

	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex,
			int x, int y, int w, int h, boolean isSelected) {
	}

	@Override
	protected void paintContentBorder(Graphics g, int tabPlacement,
			int selectedIndex) {
		int width = tabPane.getWidth();
		int height = tabPane.getHeight();
		Insets insets = tabPane.getInsets();
		Insets tabAreaInsets = getTabAreaInsets(tabPlacement);

		int x = insets.left;
		int y = insets.top;
		int w = width - insets.right - insets.left;
		int h = height - insets.top - insets.bottom;

		switch (tabPlacement) {
		case TOP:
			y += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
			y -= tabAreaInsets.bottom;
			h -= insets.top;
		}

		g.setColor(Color.white);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));

		g2d.drawLine(x, y + 2, w, y + 2);
		g2d.drawLine(x, y + 2, x, h);
		g2d.drawLine(x, h - 2, w, h - 2);
		g2d.drawLine(w - 2, y + 2, w - 2, h);
		g2d.setStroke(new BasicStroke(1.0f));
	}
}
