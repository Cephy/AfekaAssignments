package simester2.practive.Test.Thered;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;

public class Id999999999 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton jbtEnlarge = new JButton("+1");
	private JButton jbtShrink = new JButton("-1");
	private JButton jbtTimerOn = new JButton("Timer On/Off");
	private boolean timerOn = false;
	private int delay = 500;
	private Timer timer;
	private RegularPolygonPanel canvas = new RegularPolygonPanel();
	private String[] polygonScolors = { "Empty", "Red", "Green", "Black", "Blue", "Yellow" };
	private Color[] polygonOcolors = { Color.red, Color.green, Color.black, Color.blue, Color.yellow };
	private String[] polygonFrameScolors = { "Black", "Green", "Red", "Blue", "Yellow" };
	private Color[] polygonFrameOcolors = { Color.black, Color.green, Color.red, Color.blue, Color.yellow };
	private JComboBox jPolygonCbo;
	private JComboBox jPolygonFrameCbo;
	private TitledBorder polygonColorComboBox;
	private TitledBorder polygonFrameColorComboBox;

	public Id999999999(){
		timer = new Timer(delay , canvas);
		
		JPanel p1 = new JPanel(); // Use the panel to group buttons
		p1.add(jbtEnlarge);
		jbtEnlarge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setNumberOfSides((canvas.getNumberOfSides() + 1));

			}
		});
		p1.add(jbtShrink);
		jbtShrink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setNumberOfSides((canvas.getNumberOfSides() - 1));

			}
		});
		p1.add(jbtTimerOn);
		jbtTimerOn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning()){
					timer.stop();
				}
				else{
					timer.start();
				}
				
			}
		});
		jPolygonCbo = new JComboBox(polygonScolors);
		polygonColorComboBox = new TitledBorder("Poly Color");
		polygonFrameColorComboBox = new TitledBorder("Frame Color");
		JPanel p2 = new JPanel();
		p2.add(jPolygonCbo);
		p2.setBorder(polygonColorComboBox);
		JPanel p3 = new JPanel();
		p3.setBorder(polygonFrameColorComboBox);
		jPolygonFrameCbo = new JComboBox(polygonFrameScolors);
		p3.add(jPolygonFrameCbo);
		JPanel p4 = new JPanel();
		canvas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
					case KeyEvent.VK_UP:{				//Up
						canvas.setNumberOfSides((canvas.getNumberOfSides() + 1));
						break;
					}
					
					case KeyEvent.VK_DOWN:{				//Up
						canvas.setNumberOfSides((canvas.getNumberOfSides() - 1));
						break;
					}
				}
			}
		});
		
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1){
					canvas.setNumberOfSides((canvas.getNumberOfSides() + 1));
				}
		        
		        if (e.getButton() == MouseEvent.BUTTON3){
		        	canvas.setNumberOfSides((canvas.getNumberOfSides() - 1));
		        }
				
			}
		});	
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		add(canvas, BorderLayout.CENTER);
		add(p4, BorderLayout.SOUTH);
		setANDrequestFocus();

	}

	private void setANDrequestFocus() {
		canvas.setFocusable(true);
		canvas.requestFocusInWindow();
	}

	public static void main(String[] args) {
		JFrame frame = new Id999999999();
		frame.setTitle("Id999999999");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

	public class RegularPolygonPanel extends JPanel implements ActionListener {
		private static final long serialVersionUID = 1L;
		private int numberOfSides = 3;
		private boolean isFilled;
		private int enlargeORshrink;
		private int enlargeORshrinkRatio;
		private Color polygonColor = Color.red;
		private Color polygonFrameColor = Color.black;

		public RegularPolygonPanel() {
		}

		public void setFilled(boolean isFilled) {
			this.isFilled = isFilled;
		}

		public boolean isFilled() {
			return isFilled;
		}

		public RegularPolygonPanel(int numberOfSides) {
			setNumberOfSides(numberOfSides);
		}

		public int getNumberOfSides() {
			return numberOfSides;
		}

		public void setNumberOfSides(int numberOfSides) {
			if (numberOfSides <= 20 && numberOfSides >= 1) {
				this.numberOfSides = numberOfSides;
				repaint();
			}
		}

		public void setPolygonColor(Color polygonColor) {
			this.polygonColor = polygonColor;
		}

		public void setPolygonFrameColor(Color polygonFrameColor) {
			this.polygonFrameColor = polygonFrameColor;
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int xCenter = getWidth() / 2;
			int yCenter = getHeight() / 2;
			int radius = (int) (Math.min(getWidth(), getHeight()) * 0.4);
			double angle = 2 * Math.PI / getNumberOfSides();
			Polygon polygon = new Polygon();
			for (int i = 0; i < getNumberOfSides(); i++) {
				polygon.addPoint((int) (xCenter + radius * Math.cos(i * angle)),
						(int) (yCenter - radius * Math.sin(i * angle)));
			}
			g.setColor(polygonColor);
			if (isFilled())
				g.fillPolygon(polygon);
			g.setColor(polygonFrameColor);
			g.drawPolygon(polygon);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			enlargeORshrink = (int)(Math.random()*2);
			enlargeORshrinkRatio = (int)(Math.random()*5);
			if(enlargeORshrink==0){
				numberOfSides -=enlargeORshrinkRatio;
				repaint();
			}
			else{
				numberOfSides +=enlargeORshrinkRatio;
				repaint();
			}

		}
	}
}