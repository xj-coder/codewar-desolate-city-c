package platform.ui.widget.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;

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
				calculateTabRectsWithScroll(tabPlacement, tabCount);
				setRec(2);// 设置间距
			}

			public void setRec(int rec) {
				for (int i = 0; i < rects.length; i++) {
					rects[i].x = rects[i].x + rec * i;
				}
			}

			private void calculateTabRectsWithScroll(int tabPlacement, int tabCount) {
				FontMetrics metrics = getFontMetrics();
				Dimension size = tabPane.getSize();
				Insets insets = tabPane.getInsets();
				Insets tabAreaInsets = getTabAreaInsets(tabPlacement);
				int fontHeight = metrics.getHeight();
				int selectedIndex = tabPane.getSelectedIndex();
				int tabRunOverlay;
				int i, j;
				int x, y;
				int returnAt;
				boolean verticalTabRuns = tabPlacement == LEFT || tabPlacement == RIGHT;
				// boolean leftToRight =
				// BasicGraphicsUtils.isLeftToRight(tabPane);

				//
				// Calculate bounds within which a tab run must fit
				//
				switch (tabPlacement) {
				case LEFT:
					maxTabWidth = calculateMaxTabWidth(tabPlacement);
					x = insets.left + tabAreaInsets.left;
					y = insets.top + tabAreaInsets.top;
					returnAt = size.height - (insets.bottom + tabAreaInsets.bottom);
					break;
				case RIGHT:
					maxTabWidth = calculateMaxTabWidth(tabPlacement);
					x = size.width - insets.right - tabAreaInsets.right - maxTabWidth;
					y = insets.top + tabAreaInsets.top;
					returnAt = size.height - (insets.bottom + tabAreaInsets.bottom);
					break;
				case BOTTOM:
					maxTabHeight = calculateMaxTabHeight(tabPlacement);
					x = insets.left + tabAreaInsets.left;
					y = size.height - insets.bottom - tabAreaInsets.bottom - maxTabHeight;
					returnAt = size.width - (insets.right + tabAreaInsets.right);
					break;
				case TOP:
				default:
					maxTabHeight = calculateMaxTabHeight(tabPlacement);
					x = insets.left + tabAreaInsets.left;
					y = insets.top + tabAreaInsets.top;
					returnAt = size.width - (insets.right + tabAreaInsets.right);
					break;
				}

				tabRunOverlay = getTabRunOverlay(tabPlacement);

				runCount = 0;
				selectedRun = -1;

				if (tabCount == 0) {
					return;
				}

				// Run through tabs and partition them into runs
				Rectangle rect;
				for (i = 0; i < tabCount; i++) {
					rect = rects[i];

					if (!verticalTabRuns) {
						// Tabs on TOP or BOTTOM....
						if (i > 0) {
							rect.x = rects[i - 1].x + rects[i - 1].width;
						} else {
							tabRuns[0] = 0;
							runCount = 1;
							maxTabWidth = 0;
							rect.x = x;
						}
						rect.width = calculateTabWidth(tabPlacement, i, metrics);
						maxTabWidth = Math.max(maxTabWidth, rect.width);

						// Never move a TAB down a run if it is in the first
						// column.
						// Even if there isn't enough room, moving it to a fresh
						// line won't help.
						if (rect.x != 2 + insets.left && rect.x + rect.width > returnAt) {
							if (runCount > tabRuns.length - 1) {
								expandTabRunsArray();
							}
							tabRuns[runCount] = i;
							runCount++;
							rect.x = x;
						}
						// Initialize y position in case there's just one run
						rect.y = y;
						rect.height = maxTabHeight/* - 2 */;

					} else {
						// Tabs on LEFT or RIGHT...
						if (i > 0) {
							rect.y = rects[i - 1].y + rects[i - 1].height;
						} else {
							tabRuns[0] = 0;
							runCount = 1;
							maxTabHeight = 0;
							rect.y = y;
						}
						rect.height = calculateTabHeight(tabPlacement, i, fontHeight);
						maxTabHeight = Math.max(maxTabHeight, rect.height);

						// Never move a TAB over a run if it is in the first
						// run.
						// Even if there isn't enough room, moving it to a fresh
						// column won't help.
						if (rect.y != 2 + insets.top && rect.y + rect.height > returnAt) {
							if (runCount > tabRuns.length - 1) {
								expandTabRunsArray();
							}
							tabRuns[runCount] = i;
							runCount++;
							rect.y = y;
						}
						// Initialize x position in case there's just one column
						rect.x = x;
						rect.width = maxTabWidth/* - 2 */;

					}
					if (i == selectedIndex) {
						selectedRun = runCount - 1;
					}
				}

				if (runCount > 1) {
					// Re-distribute tabs in case last run has leftover space
					normalizeTabRuns(tabPlacement, tabCount, verticalTabRuns ? y : x, returnAt);

					selectedRun = getRunForTab(tabCount, selectedIndex);

					// Rotate run array so that selected run is first
					if (shouldRotateTabRuns(tabPlacement)) {
						rotateTabRuns(tabPlacement, selectedRun);
					}
				}

				// Step through runs from back to front to calculate
				// tab y locations and to pad runs appropriately
				for (i = runCount - 1; i >= 0; i--) {
					int start = tabRuns[i];
					int next = tabRuns[i == runCount - 1 ? 0 : i + 1];
					int end = next != 0 ? next - 1 : tabCount - 1;
					if (!verticalTabRuns) {
						for (j = start; j <= end; j++) {
							rect = rects[j];
							rect.y = y;
							rect.x += getTabRunIndent(tabPlacement, i);
						}
						if (shouldPadTabRun(tabPlacement, i)) {
							padTabRun(tabPlacement, start, end, returnAt);
						}
						if (tabPlacement == BOTTOM) {
							y -= maxTabHeight - tabRunOverlay;
						} else {
							y += maxTabHeight - tabRunOverlay;
						}
					} else {
						for (j = start; j <= end; j++) {
							rect = rects[j];
							rect.x = x;
							rect.y += getTabRunIndent(tabPlacement, i);
						}
						if (shouldPadTabRun(tabPlacement, i)) {
							padTabRun(tabPlacement, start, end, returnAt);
						}
						if (tabPlacement == RIGHT) {
							x -= maxTabWidth - tabRunOverlay;
						} else {
							x += maxTabWidth - tabRunOverlay;
						}
					}
				}

				// Pad the selected tab so that it appears raised in front
				padSelectedTab(tabPlacement, selectedIndex);

				// if right to left and tab placement on the top or
				// the bottom, flip x positions and adjust by widths
				// if (!leftToRight && !verticalTabRuns) {
				// int rightMargin = size.width - (insets.right +
				// tabAreaInsets.right);
				// for (i = 0; i < tabCount; i++) {
				// rects[i].x = rightMargin - rects[i].x - rects[i].width;
				// }
				// }
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
