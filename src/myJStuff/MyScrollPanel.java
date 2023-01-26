package myJStuff;

import javax.swing.JScrollPane;

public class MyScrollPanel extends MyPanel{

	protected JScrollPane scrollPane;
	
	public MyScrollPanel() {
		addScrollToCenter();
	}
	
	protected void addScrollToCenter() {
		JScrollPane scroller = new JScrollPane(center);
		scroller.getViewport().getView().setBackground(Colors.defaultBackgroundColor);
	    contentPane.add(scroller);
	}

}
