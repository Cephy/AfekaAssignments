package simester2.practive.worksheet6;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FrameQ6 extends JFrame{
	
	private BallFrame ballFrame = new BallFrame();
	private int changeX = 0;
	private int changeY = 10;
	
	public FrameQ6(){
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		add(ballFrame);		
	}
	
	class BallFrame extends JPanel{
		
		private final int size = 10;
		private int x = 0;
		private int y = 0;
		
		public BallFrame(){
			Timer timer = new Timer (500, new Movment());
			timer.start();
			setFocusable(true);
			addKeyListener(new KeyAdapter(){
				public void keyPressed (KeyEvent e){
					switch (e.getKeyCode()) {
			            case KeyEvent.VK_DOWN:{ 
			            	changeX = 0;
			            	changeY = 10; 
			            	break;
			            }
			            case KeyEvent.VK_UP:{ 
			            	changeX = 0;
			            	changeY = -10; 
			            	break;
			            }
			            case KeyEvent.VK_LEFT:{
			            	changeX = -10;
			            	changeY = 0; 
			            	break;
			            }
			            
			            case KeyEvent.VK_RIGHT:{ 
			            	changeX = 10;
			            	changeY = 0; 
			            	break;
			            }
		            }                         
				}
			});
		}
		
		@Override
		public void paintComponent (Graphics g){
			super.paintComponent(g);
			g.fillOval(x,y,size,size);
		}
		
		class Movment implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e){
				x+=changeX;
				y+=changeY;
				repaint();
			}
		}
	}
}
