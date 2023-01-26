package myJStuff;
import java.awt.Color;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	private static final long serialVersionUID = 1L;

	
	public MyLabel(String text,	Color color, int size){
		setText(text);
		setForeground(color);
		setFont(new MyFont(size));
	}

	
	public MyLabel(String text) {
		this(text, Colors.defaultTextColor, 25);
	}
	
	public MyLabel(String text, int size) {
		this(text, Colors.defaultTextColor, size);
	}
}
