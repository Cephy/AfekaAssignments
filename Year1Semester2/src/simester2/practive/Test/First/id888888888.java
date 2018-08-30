package simester2.practive.Test.First;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import java.awt.*;
import java.awt.event.*;


public class id888888888 extends JFrame {
	private int delay = 1000;
	private int direction = 1;
	private int timeMovingDirection = 0;
	private Timer timer;
	private int locationChange = 1;
	private ConstantMovment cm = new ConstantMovment();
	private BallCanvas ballCanvas = new BallCanvas();
	private ButtonsCanvas buttonCanvas = new ButtonsCanvas();
	boolean timerOn = true;


	public id888888888() {
		setLayout(new BorderLayout());
		add(ballCanvas, BorderLayout.CENTER);
		add(buttonCanvas, BorderLayout.SOUTH);
		timer = new Timer(delay, cm);
		timer.start();
		setFocus();
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
					case KeyEvent.VK_HOME:{				//UpLeft
						ballCanvas.moveUpLeft();
						setFocus();
						break;
					}
					case KeyEvent.VK_UP:{				//Up
						ballCanvas.moveUp();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_PAGE_UP:{			//UpRight 
						ballCanvas.moveUpRight();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_LEFT:{			//Left 
						ballCanvas.moveLeft();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_ENTER:{			//Center  
						ballCanvas.center();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_RIGHT:{			//Right   
						ballCanvas.moveRight();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_END:{			//DownLeft    
						ballCanvas.moveDownLeft();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_DOWN:{			//Down     
						ballCanvas.moveDown();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_PAGE_DOWN:{			//DownRight      
						ballCanvas.moveDownRight();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_F1:{			//EnLarge       
						ballCanvas.EnLarge();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_F12:{			//Shrink        
						ballCanvas.Shrink();
						setFocus();
						break;
					}
					
					case KeyEvent.VK_1:{			//Faster         
						if(delay>0){
							delay-=100;
							timer.setDelay(delay);
						}
						
						break;
					}
					
					case KeyEvent.VK_0:{			//Slower         
						if(delay<5000){
							delay+=100;
							timer.setDelay(delay);
						}
						if(delay>5000){
							delay = 1000;
							timer.setDelay(delay);
						}
						setFocus();
						break;
					}
					
				}
			}
		});
	}
	
	public BallCanvas getBallCanvas(){
		return ballCanvas;
	}

	public void setFocus() {
		setFocusable(true);
		requestFocusInWindow();
	}
	
	class ConstantMovment implements ActionListener{
		
		private int timerCounter = 0 ;
		private final int GO_RIGHT = 0;
		private final int GO_DOWN = 1;
		private final int GO_LEFT = 2;
		private final int GO_UP = 3;
		
		public ConstantMovment(){
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(timerCounter%4){
				case GO_RIGHT:{
					ballCanvas.moveRight();
					timerCounter += locationChange;
					break;
				}
				case GO_DOWN:{
					ballCanvas.moveDown();
					timerCounter += locationChange;
					break;
				}
				case GO_LEFT:{
					ballCanvas.moveLeft();
					timerCounter += locationChange;
					break;
				}
				case GO_UP:{
					ballCanvas.moveUp();
					timerCounter += locationChange;
					break;
				}
			}			
		}		
	}

	class ButtonsCanvas extends JPanel {
		
		private JButton jbtUpLeft = new JButton("UpLeft");
		private JButton jbtUp = new JButton("Up");
		private JButton jbtUpRight = new JButton("UpRight");
		private JButton jbtLeft = new JButton("Left");
		private JButton jbtCenter = new JButton("Center");
		private JButton jbtRight = new JButton("Right");
		private JButton jbtDownLeft = new JButton("DownLeft");
		private JButton jbtDown = new JButton("Down");
		private JButton jbtDownRight = new JButton("DownRight");
		private JButton jbtEnlarge = new JButton("EnLarge");
		private JButton jbtShrink = new JButton("Shrink");
		private JButton jbtTimerOn = new JButton("Timer On/Off");
		private JButton jbtFaster = new JButton("Faster");
		private JButton jbtSlower = new JButton("Slower");
		private JButton jbtDirection = new JButton("Change Direction");
		private String[] colorComboBoxString = { "Red", "Green", "Black", "Blue", "Yellow" };
		private JComboBox colorComboBox = new JComboBox(colorComboBoxString);

		public ButtonsCanvas() {
			setLayout(new GridLayout(4, 4, 1, 1));
			add(jbtUpLeft);
			jbtUpLeft.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.moveUpLeft();
				}
			});
			add(jbtUp);
			jbtUp.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.moveUp();
				}
			});
			add(jbtUpRight);
			jbtUpRight.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.moveUpRight();
				}
			});
			add(jbtLeft);
			jbtLeft.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.moveLeft();
				}
			});
			add(jbtCenter);
			jbtCenter.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.center();
				}
			});
			add(jbtRight);
			jbtRight.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.moveRight();
				}
			});
			add(jbtDownLeft);
			jbtDownLeft.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.moveDownLeft();
				}
			});
			add(jbtDown);
			jbtDown.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.moveDown();
				}
			});
			add(jbtDownRight);
			jbtDownRight.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.moveDownRight();
				}
			});
			add(jbtEnlarge);
			jbtEnlarge.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.EnLarge();
				}
			});
			add(jbtShrink);
			jbtShrink.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.Shrink();
				}
			});
			add(jbtTimerOn);
			jbtTimerOn.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(timerOn){
						timer.stop();
						timerOn = false;
					}
					else{
						timer.start();
						timerOn = true;
					}
				}
			});
			add(jbtFaster);
			jbtFaster.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(delay>0){
						delay-=100;
						timer.setDelay(delay);
					}
				}
			});
			add(jbtSlower);
			jbtSlower.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(delay<5000){
						delay+=100;
						timer.setDelay(delay);
					}
					if(delay>5000){
						delay = 1000;
						timer.setDelay(delay);
					}
				}
			});
			add(jbtDirection);
			jbtDirection.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					locationChange *= -1;
				}
			});
			add(colorComboBox);
			colorComboBox.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ballCanvas.setBallColor(ballCanvas.colorDecode(colorComboBox.getSelectedIndex()));
				}
			});
		}
		
		
	}

	public static void main(String[] args) {
		JFrame frame = new id888888888();
		frame.setTitle("MoedB");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

	class BallCanvas extends JPanel {
		private int x = 100;
		private int y = 100;
		private int delta = 5;
		private int radius = 25;

		Color ballColor = Color.red;
		
		public BallCanvas(){
			addMouseListener(new MouseInputAdapter() {
				public void mousePressed (MouseEvent e) {
					
					}
			});
		}

		public void setBallColor(Color ballColor) {
			this.ballColor = ballColor;
			repaint();
		}
		
		public Color getColor() {
			return ballColor;
		}
		
		public void setColor(Color ballColor){
			this.ballColor = ballColor;
		}
				
		public void center() {
			x = getWidth() / 2;
			y = getHeight() / 2;
			repaint();
		}

		public void moveLeft() {
			if (x > 0)
				x -= delta;
			repaint();
		}

		public void moveRight() {
			if (x < getWidth())
				x += delta;
			repaint();
		}

		public void moveUp() {
			if (y > 0)
				y -= delta;
			repaint();
		}

		public void moveDown() {
			if (y < getHeight())
				y += delta;
			repaint();
		}

		public void moveDownLeft() {
			moveDown();
			moveLeft();
		}

		public void moveDownRight() {
			moveDown();
			moveRight();
		}

		public void moveUpLeft() {
			moveUp();
			moveLeft();
		}

		public void moveUpRight() {
			moveUp();
			moveRight();
		}

		public void EnLarge(){
			if(delta<500){
				delta += 5;
			}
		}
		
		public void Shrink(){
			if(delta<500){
				delta -= 5;
			}
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(ballColor);
			g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
		}
		
		public Color colorDecode(int colorCode){
			final int RED = 0;
			final int GREEN = 1;
			final int BLACK = 2;
			final int BLUE = 3;
			final int YELLOW = 4;
			
			switch(colorCode){
				case RED:{
					return Color.RED;
				}
				case GREEN:{
					return Color.GREEN;
				}
				case BLACK:{
					return Color.BLACK;
				}
				case BLUE:{
					return Color.BLUE;
				}
				case YELLOW:{
					return Color.YELLOW;
				}
				default:{
					return Color.RED;
				}
				
			}
		}
		
	}
}
