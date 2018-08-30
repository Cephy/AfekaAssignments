package hw3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class MainFrame extends JFrame {

	/*
	 * In the class the are: The main frame as the main class The main Panel
	 * that holds all the components as an inner class The control Frame and the
	 * control Panel as an inner class
	 * 
	 * I put everything in the same class to create order and make the
	 * mechanisms between the different class much simpler
	 * 
	 * I ignored the error regarding the "Serial version UID" because we never
	 * learned about it and i didn't want to change something i don't fully
	 * understand
	 */

	private final int FRAME_SIZE = 700; // main frame size
	private int x; // Location on the panel of x and y
	private int y;
	private int restoringSize; // Changing restoring dot size
	private boolean recording = true; // Flag for recording or restoring
	private ArrayList<Integer> listX = new ArrayList<Integer>(); // Array os x
																	// and y
																	// locations
	private ArrayList<Integer> listY = new ArrayList<Integer>();
	private MainPanel mainPanel = new MainPanel(); // main panel
	private Timer timer;
	private int xLocation; // location of x and y in the array
	private int yLocation;
	private ControlPanelFrame controlPanelFrame = new ControlPanelFrame();
	private Color color; // the lines color
	private Boolean cleanBoard = true; // A flag the checks when the main panel
										// need to be wiped
	private final String REC = "RECORDING";

	public MainFrame() {

		setSize(FRAME_SIZE, FRAME_SIZE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);
		add(mainPanel);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (!listX.isEmpty()) {
						cleanBoard = true;
						recording = false;
						controlPanelFrame.setVisible(true);
						try {
							timer.stop();
						} catch (NullPointerException ex) {

						}

					}
				}
			}
		});
	}

	/* Switch to Restoring Mode */
	public void restoring(int speed, int size) {
		controlPanelFrame.setVisible(false);
		restoringSize = size; // Set's line thickness
		xLocation = 0;
		yLocation = 0;
		recording = false; // Resets recording
		timer = new Timer(speed, mainPanel);
		timer.start();
	}

	class MainPanel extends JPanel implements ActionListener {

		private final int DEAFUALT_SIZE = 10; // Default drawing size
		private final int DEAFUALT_STRING_LOCATION = 10;

		public MainPanel() {
			/*
			 * Mouse-line painter, saves positions on X and Y location once
			 * mouse is dragged
			 */
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					if (recording) {
						x = (e.getX() - DEAFUALT_SIZE / 2);
						listX.add(x);
						y = (e.getY() - DEAFUALT_SIZE / 2);
						listY.add(y);
						repaint();
					}
				}
			});
		}

		public void paintComponent(Graphics g) {
			/* The component that draws the line */
			if (recording) {
				if (!cleanBoard) {
					g.setColor(Color.RED);
					g.drawString(REC, DEAFUALT_STRING_LOCATION, DEAFUALT_STRING_LOCATION);
					g.setColor(Color.BLACK);
					g.fillOval(x, y, DEAFUALT_SIZE, DEAFUALT_SIZE);

				}
			}

			/* The component that check's if the panel needs to be cleaned */
			if (cleanBoard) {
				super.paintComponent(g);
				cleanBoard = false;
			}
			/* The component that restores what you drew */
			if (!recording) {
				g.setColor(Color.BLACK);
				g.drawString("RESTORING", DEAFUALT_STRING_LOCATION, DEAFUALT_STRING_LOCATION);
				g.setColor(color);
				g.fillOval(x, y, restoringSize, restoringSize);

			}
		}

		@Override
		/*
		 * The component that gets the locations of the X and Y from the array
		 * and moves to next location
		 */
		public void actionPerformed(ActionEvent e) {
			if (xLocation != listX.size()) {
				x = listX.get(xLocation); // takes the location
				y = listY.get(yLocation);
				xLocation += 1; // moves 1 spot in the array
				yLocation += 1;
				repaint();
			}

			/*
			 * The component that clears the array in the end of the restoration
			 * and stops the timer
			 */
			if (xLocation == listX.size() - 1) {
				listY.clear();
				listX.clear();
				timer.stop();
				cleanBoard = true;
				recording = true;
				repaint();
			}
		}
	}

	class ControlPanelFrame extends JFrame {

		private ControlPanel controlPanel = new ControlPanel();
		private final int CP_FRAME_SIZE = 300;

		public ControlPanelFrame() {

			setSize(CP_FRAME_SIZE, CP_FRAME_SIZE);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setAlwaysOnTop(true);
			setVisible(false);
			setResizable(false);
			add(controlPanel);
		}

		class ControlPanel extends JPanel {

			private JPanel colorPanel = new JPanel();
			private JPanel colorThicknessSpeedPanel = new JPanel();
			private ButtonGroup colorGroup = new ButtonGroup();
			private JRadioButton black = new JRadioButton("Black", true);
			private JRadioButton red = new JRadioButton("Red", true);
			private JRadioButton blue = new JRadioButton("Blue", true);
			private JRadioButton green = new JRadioButton("Green", true);
			private JPanel thicknessPanel = new JPanel();
			private String[] thicknessComboBoxString = { "Default thickness", "Thick", "Thin" };
			private JComboBox thicknessComboBox = new JComboBox(thicknessComboBoxString);
			private final int SPEED_MENU = 3;
			private JSlider speedSlider = new JSlider(JSlider.HORIZONTAL);
			private JPanel speedPanel = new JPanel();
			private JPanel okButtonPanel = new JPanel();
			private JButton okButton = new JButton("OK");
			private final int SPEED1 = 10; // Slow speed
			private final int SPEED2 = 5; // Medium speed
			private final int SPEED3 = 1; // Fast speed (normal)
			private final int SIZE2 = 15; // Think thickness
			private final int SIZE3 = 5; // Thin thickness
			private final int SIZE1 = 10; // Default thickness

			public ControlPanel() {
				setLayout(new BorderLayout());

				setPanel();
			}

			public void setPanel() {
				colorThicknessSpeedPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));

				colorGroup.add(black);
				colorGroup.add(red);
				colorGroup.add(blue);
				colorGroup.add(green);

				black.setMnemonic('B');
				black.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						color = Color.BLACK;
					}

				});
				red.setMnemonic('R');
				red.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						color = Color.RED;
					}

				});
				blue.setMnemonic('B');
				blue.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						color = Color.BLUE;
					}

				});
				green.setMnemonic('G');
				green.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						color = Color.GREEN;
					}
				});
				colorPanel.setBorder(BorderFactory.createTitledBorder("Colors"));
				colorPanel.setLayout(new GridLayout(1, 4));
				colorPanel.add(black);
				colorPanel.add(red);
				colorPanel.add(blue);
				colorPanel.add(green);
				colorThicknessSpeedPanel.add(colorPanel);

				thicknessComboBox.setToolTipText("Please choose the thickness of the line");
				thicknessPanel.add(thicknessComboBox);
				colorThicknessSpeedPanel.add(thicknessPanel);

				speedSlider.setMaximum(SPEED_MENU);
				speedSlider.setMinimum(1);
				speedSlider.setPaintLabels(true);
				speedSlider.setPaintTicks(true);
				speedSlider.setMajorTickSpacing(1);
				speedPanel.setBorder(BorderFactory.createTitledBorder("Speed"));
				speedPanel.add(speedSlider);
				colorThicknessSpeedPanel.add(speedPanel);

				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int speed = sliderDecoder(speedSlider.getValue());
						int thickness = thicknessDecoder(thicknessComboBox.getSelectedIndex());
						restoring(speed, thickness);
					}
				});

				okButtonPanel.add(okButton, SwingConstants.CENTER);

				add(okButtonPanel, BorderLayout.SOUTH);
				add(colorThicknessSpeedPanel, BorderLayout.CENTER);
			}

			/*
			 * The component that determines the Speed from the user had entered
			 */
			public int sliderDecoder(int value) {
				switch (value) {
				case 0: {
					return SPEED1; // Slow
				}
				case 1: {
					return SPEED2; // Medium
				}
				case 2: {
					return SPEED3; // Fast
				}
				default: {
					return SPEED3; // Default-fast
				}
				}
			}

			/*
			 * The component that determines the thickness from the user had
			 * entered
			 */
			public int thicknessDecoder(int value) {
				switch (value) {
				case 0: {
					return SIZE1; // default thickness
				}
				case 1: {
					return SIZE2; // thick thickness
				}
				case 2: {
					return SIZE3; // thin thickness
				}
				default: {
					return SIZE1;
				}
				}
			}
		}
	}

}
