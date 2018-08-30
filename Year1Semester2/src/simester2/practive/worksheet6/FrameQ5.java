package simester2.practive.worksheet6;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class FrameQ5 extends JFrame{
	
	private MainPanel mainPanel = new MainPanel();
	
	public FrameQ5 (){
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);
		add(mainPanel);
	}
	
	static class MainPanel extends JPanel{
		
		private final int size = 10;
		private int x;
		private int y;
		private boolean flag = false;
		
		public MainPanel(){
			  addMouseMotionListener(new MouseMotionAdapter() {
				  @Override
				  public void mouseDragged(MouseEvent e){
					  x=(e.getX() - size/2);
					  y=(e.getY() - size/2);
					  flag = true;
					  repaint();
				  }
			  });
		}
		
		public void paintComponent (Graphics g){
			if(flag){
				g.setColor(Color.RED);
				g.fillOval(x, y, size, size);
			}
		}
	}
}
