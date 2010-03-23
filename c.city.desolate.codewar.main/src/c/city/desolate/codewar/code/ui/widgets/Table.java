package c.city.desolate.codewar.code.ui.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class Table extends Composite{
	private int seat;//×ùÎ»Êý
	private Image tableImage;//×À×ÓÍ¼Æ¬
	private Image seatImage;//ÒÎ×ÓÍ¼Æ¬

	public Table(Composite parent, int style) {
		super(parent, style);
	}
	
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public Image getTableImage() {
		return tableImage;
	}
	public void setTableImage(Image tableImage) {
		this.tableImage = tableImage;
	}
	public Image getSeatImage() {
		return seatImage;
	}
	public void setSeatImage(Image seatImage) {
		this.seatImage = seatImage;
	}
	public void show(){
		Button table = new Button(this.getParent(),SWT.NULL);
		
		table.setBackgroundImage(tableImage);
		
	}
	
}
