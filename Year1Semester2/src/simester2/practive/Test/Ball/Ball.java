package simester2.practive.Test.Ball;

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ball extends JPanel {
	private int delay = 1; // Create a timer with delay 1000 ms

	private Timer timer = new Timer(delay, new TimerListener());
	private ArrayList<BallPoint> ballArray = new ArrayList<>();
	private int radius = 5; // Ball radius

	public Ball() {
		timer.start();
	}

	private class TimerListener implements ActionListener {
		/** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int location = 0; location < ballArray.size(); location++) {
			if (ballArray.get(location).getX() < radius)
				ballArray.get(location).setDx(Math.abs(ballArray.get(location).getDx())); // Check
																							// boundaries
			if (ballArray.get(location).getX() > getWidth() - radius) {
				ballArray.get(location).setDx(-Math.abs(ballArray.get(location).getDx()));
				ballArray.get(location).setColor(randomColor());
			}
			if (ballArray.get(location).getY() < radius)
				ballArray.get(location).setDy(Math.abs(ballArray.get(location).getDy()));
			if (ballArray.get(location).getY() > getHeight() - radius) {
				ballArray.get(location).setDy(-Math.abs(ballArray.get(location).getDy()));
				ballArray.get(location).setColor(randomColor());
			}
			ballArray.get(location).setX(ballArray.get(location).getX() + ballArray.get(location).getDx()); // Adjust
																											// ball
																											// position
			ballArray.get(location).setY(ballArray.get(location).getY() + ballArray.get(location).getDy());
			g.setColor(ballArray.get(location).getColor());
			g.fillOval(ballArray.get(location).getX() - radius, ballArray.get(location).getY() - radius, radius * 2,
					radius * 2);
		}
	}

	public void suspend() {
		timer.stop();
	} // Suspend timer

	public void resume() {
		timer.start();
	} // Resume timer

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}

	public void addBall() {
		ballArray.add(new BallPoint());
	}

	public void subBall() {
		ballArray.remove(ballArray.size() - 1);
	}

	public Color randomColor() {
		Color color = new Color(getThreeDigitNum(), getThreeDigitNum(), getThreeDigitNum());
		return color;
	}

	public static int getThreeDigitNum() {
		return (int) (Math.random() * 255);
	}

	public class BallPoint {
		private int x = 0;
		private int y = 0;
		private int dx = 2;
		private int dy = 2;
		private Color color = Color.RED;

		public BallPoint() {

		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getDx() {
			return dx;
		}

		public void setDx(int dx) {
			this.dx = dx;
		}

		public int getDy() {
			return dy;
		}

		public void setDy(int dy) {
			this.dy = dy;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public Color getColor() {
			return color;
		}
	}
}
