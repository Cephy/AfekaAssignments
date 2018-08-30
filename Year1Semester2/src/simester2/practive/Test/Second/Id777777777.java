package simester2.practive.Test.Second;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Id777777777 extends JFrame {
	
	private Timer timer;
	final int STARTSPEED = 1000;
	private int speed = STARTSPEED;
	private FanPanel fanPanel = new FanPanel();
	private ButtonPanel buttonPanel = new ButtonPanel();

	public Id777777777() {
		setLayout(new BorderLayout());
		add(fanPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		timer = new Timer(speed , fanPanel);
	}
	
	public void setFocus() {
		setFocusable(true);
		requestFocusInWindow();
	}
	
	public static void main(String[] args) {
		Id777777777 frame = new Id777777777();
		frame.setTitle("Id777777777");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

	class ButtonPanel extends JPanel {
		
		private JButton jbtStart = new JButton("Start");
		private JButton jbtStop = new JButton("Stop");
		private JButton jbtFaster = new JButton("Faster");
		private JButton jbtSlower = new JButton("Slower");
		private String[] fanScolors = { "Red", "Green", "Black", "Blue", "Yellow" };
		private JComboBox fanColorComboBox = new JComboBox (fanScolors);
		private JComboBox frameColorComboBox = new JComboBox (fanScolors);
		
		public ButtonPanel(){
			setLayout(new FlowLayout(FlowLayout.CENTER));
			add(jbtStart);
			jbtStart.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					timer.start();
				}
			});
			add(jbtStop);
			jbtStop.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					timer.stop();
				}
			});
			add(jbtFaster);
			jbtFaster.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(timer.isRunning() && speed>200);{
						speed -=100; 
						timer.setDelay(speed);
					}
				}
			});
			add(jbtSlower);
			jbtSlower.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(timer.isRunning());{
						speed +=100; 
						timer.setDelay(speed);
					}
					
				}
			});
			
			fanColorComboBox.setBorder(BorderFactory.createTitledBorder("Fan Color"));
			add(fanColorComboBox);
			fanColorComboBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					fanPanel.setFanColor(fanPanel.colorDecode(fanColorComboBox.getSelectedIndex()));					
				}
			});
			
			frameColorComboBox.setBorder(BorderFactory.createTitledBorder("Frame Color"));
			add(frameColorComboBox);
			frameColorComboBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					fanPanel.setFanFrameColor(fanPanel.colorDecode(frameColorComboBox.getSelectedIndex()));
					
				}
			});
		}
	}
	

	class FanPanel extends JPanel implements ActionListener, MouseListener {

		private int xCenter, yCenter;
		private int fanRadius, bladeLength;
		private int angle = 100;
		private int direction = 1;
		Color fanColor = Color.red;
		Color fanFrameColor = Color.black;
		private Color[] fanOcolors = { Color.red, Color.green, Color.black, Color.blue, Color.yellow };
		
		public FanPanel(){
			setFocus();
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1){
						direction *=-1;
					}
			        
			        if (e.getButton() == MouseEvent.BUTTON3){
			        	direction *=-1;
			        }
					
				}
			});			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			fanRadius = (int) (Math.min(getSize().width, getSize().height) * 0.9 * 0.5);
			xCenter = (getSize().width) / 2;
			yCenter = (getSize().height) / 2;
			bladeLength = (int) (fanRadius * 0.9);
			angle = (angle + direction) % 360;
			g.setColor(fanFrameColor);
			g.drawOval(xCenter - fanRadius, yCenter - fanRadius, 2 * fanRadius, 2 * fanRadius);
			drawBlade(g, angle);
			drawBlade(g, angle + 90);
			drawBlade(g, angle + 180);
			drawBlade(g, angle + 270);
		}
		
		public Color colorDecode (int colorCode){
			return fanOcolors[colorCode];
		}
		
		public void setFanColor (Color fanColor){
			this.fanColor = fanColor;
			repaint();
		}
		
		public Color getFanColor (){
			return fanColor;
		}
		
		public void setFanFrameColor (Color fanFrameColor){
			this.fanFrameColor = fanFrameColor;
			repaint();
		}
		
		public Color getanFrameColor (){
			return fanFrameColor;
		}

		private void drawBlade(Graphics g, int angle) {
			g.setColor(fanColor);
			g.fillArc(xCenter - bladeLength, yCenter - bladeLength, 2 * bladeLength, 2 * bladeLength, angle, 30);
		}

		public void actionPerformed(ActionEvent actionEvent) {
			repaint();
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
