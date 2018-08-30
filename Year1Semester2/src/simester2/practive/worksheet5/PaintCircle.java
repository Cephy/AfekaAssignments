package simester2.practive.worksheet5;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintCircle extends JPanel{
	
	public int startAngle = 30;
	public final int endAngle = 180;
	public PaintCircle() {	
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawOval(0, 0, getWidth(), getHeight());
		g.fillArc(0, 0, getWidth(), getHeight(), startAngle, endAngle);
	}
	
	public void jump (){
		startAngle+=30;
		repaint();
	}	
}
