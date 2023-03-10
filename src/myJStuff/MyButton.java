package myJStuff;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class MyButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	public MyButton(String text){
		setText(text);
		setForeground(Colors.defaultButtonTextColor);
		setBackground(Colors.defaultButtonBackgroundColor);
		setFont(new MyFont(Size.defaultBtnFontSize));
		setBorder(new EmptyBorder(4,4,4,4));
		setPreferredSize(new Dimension(Size.defaultBtnWidth,Size.defaultBtnHeight));
	}
	
	public MyButton(String text, int size){
		setText(text);
		setForeground(Colors.defaultButtonTextColor);
		setBackground(Colors.defaultButtonBackgroundColor);
		setFont(new MyFont(size));
		setBorder(new EmptyBorder(4,4,4,4));
		setPreferredSize(new Dimension(Size.defaultBtnWidth,Size.defaultBtnHeight));
	}
	
	public MyButton(String text, int fontSize, int width){
		setText(text);
		setForeground(Colors.defaultButtonTextColor);
		setBackground(Colors.defaultButtonBackgroundColor);
		setFont(new MyFont(fontSize));
		setBorder(new EmptyBorder(4,4,4,4));
		setPreferredSize(new Dimension(width,Size.defaultBtnHeight));
	}
	
	public MyButton(String text, Color foreground, Color background, int i){
		setText(text);
		setForeground(foreground);
		setBackground(background);
		setFont(new MyFont(i));
		setBorder(new EmptyBorder(4,4,4,4));
		setPreferredSize(new Dimension(Size.defaultBtnWidth,Size.defaultBtnHeight));
	}

}