package platform.adapter;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class UIMouseDragAdapter extends MouseAdapter {

	public final static int PULLING_NULL = 0;
	public final static int PULLING_LEFT = 1;
	public final static int PULLING_RIGHT = 2;
	public final static int PULLING_UP = 3;
	public final static int PULLING_DOWN = 4;
	public final static int PULLING_LEFT_UP = 5;
	public final static int PULLING_LEFT_DOWN = 6;
	public final static int PULLING_RIGHT_UP = 7;
	public final static int PULLING_RIGHT_DOWN = 8;

	private JFrame UI;

	private int pressX;
	private int pressY;

	private int currPullingState;

	public UIMouseDragAdapter(JFrame UI) {
		this.UI = UI;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressX = e.getX();
		pressY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (currPullingState == PULLING_NULL) {
			int _x = UI.getX() + e.getX() - pressX;
			int _y = UI.getY() + e.getY() - pressY;
			UI.setLocation(_x, _y);
		} else {
			int width = UI.getWidth();
			int height = UI.getHeight();
			int _offX = e.getX() - pressX;
			int _offY = e.getY() - pressY;
			int _width = 0;
			int _height = 0;

			switch (currPullingState) {
			case PULLING_LEFT:
				_width = width - _offX;
				if (_offX > 0 && _width <= UI.getMinimumSize().getWidth() || _offX < 0 && _width >= UI.getMaximumSize().getWidth()) {
					break;
				}
				UI.setBounds(UI.getX() + _offX, UI.getY(), _width, height);
				UI.validate();
				break;
			case PULLING_RIGHT:
				_width = width + _offX;
				if (_offX < 0 && _width <= UI.getMinimumSize().getWidth() || _offX > 0 && _width >= UI.getMaximumSize().getWidth()) {
					break;
				}
				UI.setSize(_width, height);
				UI.validate();
				pressX = e.getX();
				pressY = e.getY();
				break;
			case PULLING_UP:
				_height = height - _offY;
				if (_offY > 0 && _height <= UI.getMinimumSize().getHeight() || _offY < 0 && _height >= UI.getMaximumSize().getHeight()) {
					break;
				}
				UI.setBounds(UI.getX(), UI.getY() + _offY, width, _height);
				UI.validate();
				break;
			case PULLING_DOWN:
				_height = height + _offY;
				if (_offY < 0 && _height <= UI.getMinimumSize().getHeight() || _offY > 0 && _height >= UI.getMaximumSize().getHeight()) {
					break;
				}
				UI.setSize(width, _height);
				UI.validate();
				pressX = e.getX();
				pressY = e.getY();
				break;
			case PULLING_LEFT_UP:
				_height = height - _offY;
				_width = width - _offX;
				if (_offX > 0 && _width <= UI.getMinimumSize().getWidth() || _offX < 0 && _width >= UI.getMaximumSize().getWidth() || _offY > 0
						&& _height <= UI.getMinimumSize().getHeight() || _offY < 0 && _height >= UI.getMaximumSize().getHeight()) {
					break;
				}
				UI.setBounds(UI.getX() + _offX, UI.getY() + _offY, _width, _height);
				UI.validate();
				break;
			case PULLING_LEFT_DOWN:
				_height = height + _offY;
				_width = width - _offX;
				if (_offX > 0 && _width <= UI.getMinimumSize().getWidth() || _offX < 0 && _width >= UI.getMaximumSize().getWidth() || _offY < 0
						&& _height <= UI.getMinimumSize().getHeight() || _offY > 0 && _height >= UI.getMaximumSize().getHeight()) {
					break;
				}
				UI.setBounds(UI.getX() + _offX, UI.getY(), _width, _height);
				UI.validate();
				pressY = e.getY();
				break;
			case PULLING_RIGHT_DOWN:
				_height = height + _offY;
				_width = width + _offX;
				if (_offY < 0 && _height <= UI.getMinimumSize().getHeight() || _offY > 0 && _height >= UI.getMaximumSize().getHeight() || _offX < 0
						&& _width <= UI.getMinimumSize().getWidth() || _offX > 0 && _width >= UI.getMaximumSize().getWidth()) {
					break;
				}
				UI.setSize(_width, _height);
				UI.validate();
				pressX = e.getX();
				pressY = e.getY();
				break;
			case PULLING_RIGHT_UP:
				_height = height - _offY;
				_width = width + _offX;
				if (_offY > 0 && _height <= UI.getMinimumSize().getHeight() || _offY < 0 && _height >= UI.getMaximumSize().getHeight() || _offX < 0
						&& _width <= UI.getMinimumSize().getWidth() || _offX > 0 && _width >= UI.getMaximumSize().getWidth()) {
					break;
				}
				UI.setBounds(UI.getX(), UI.getY() + _offY, _width, _height);
				UI.validate();
				pressX = e.getX();
				break;
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		currPullingState = PULLING_NULL;
		UI.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		if (e.getX() < 5 && e.getY() < 5) {
			currPullingState = PULLING_LEFT_UP;
			UI.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
		} else if (e.getX() < 5 && e.getY() > UI.getHeight() - 5) {
			currPullingState = PULLING_LEFT_DOWN;
			UI.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
		} else if (e.getX() < 5 && e.getY() > 5 && e.getY() < UI.getHeight() - 5) {
			currPullingState = PULLING_LEFT;
			UI.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
		} else if (e.getX() > UI.getWidth() - 5 && e.getY() < 5) {
			currPullingState = PULLING_RIGHT_UP;
			UI.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
		} else if (e.getX() > UI.getWidth() - 5 && e.getY() > UI.getHeight() - 5) {
			currPullingState = PULLING_RIGHT_DOWN;
			UI.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
		} else if (e.getX() > UI.getWidth() - 5 && e.getY() > 5 && e.getY() < UI.getHeight() - 5) {
			currPullingState = PULLING_RIGHT;
			UI.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
		} else if (e.getX() > 5 && e.getX() < UI.getWidth() - 5 && e.getY() < 5) {
			currPullingState = PULLING_UP;
			UI.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
		} else if (e.getX() > 5 && e.getX() < UI.getWidth() - 5 && e.getY() > UI.getHeight() - 5) {
			currPullingState = PULLING_DOWN;
			UI.setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
		}
	}
}
