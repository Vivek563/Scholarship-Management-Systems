package myJStuff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;


public abstract class MyPanel {

	protected ActionListener packageListener;
	
	protected JPanel contentPane = new JPanel();
	protected JPanel north;
	protected JPanel south;
	protected JPanel west;
	protected JPanel east;
	protected JPanel center;

	
	protected final static String location = "src/resources/";
	
	
	// Height and width of the screen
	
	protected static final int width = 1000;
	protected static final int height = 600;
	
	protected EmptyBorder emptyBorder = new EmptyBorder(150, 5, 5, 5);
	
	public MyPanel(){
		setTheme();
		
		contentPane.setBorder(emptyBorder);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.setName("MyPanel --- Rename your Panel");
		north = new JPanel();
		
		contentPane.add(north, BorderLayout.NORTH);
		north.setLayout(new MigLayout("", "[grow,center]", "[]"));
		
		west = new JPanel();
		contentPane.add(west, BorderLayout.WEST);
		
		east = new JPanel();
		contentPane.add(east, BorderLayout.EAST);
		
		center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new MigLayout("", "[grow]", "[]"));
		
		
		south = new JPanel();
		contentPane.add(south, BorderLayout.SOUTH);
		south.setLayout(new MigLayout("", "[][grow]", "[]"));
		
		setBackgroundColor(Colors.GRADENT_COLOR);
	}
	
	

	protected void setBackgroundColor(Color color){
		north.setBackground(color.decode("#FED54A"));
		south.setBackground(color);
		east.setBackground(color);
		west.setBackground(color);
		center.setBackground(color);
		contentPane.setBackground(color);
	}
	
	protected void setTheme(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		   System.out.println("Nimbus theme is not found.");
		   e.printStackTrace();
		}
	}
	
	public JPanel getContentPane(){
		return contentPane;
	}
}