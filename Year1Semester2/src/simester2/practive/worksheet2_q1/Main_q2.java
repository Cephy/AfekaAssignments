package simester2.practive.worksheet2_q1;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_q2 {

	
	public static void main (String[] args){
		
		JFrame frame = new JFrame ();
		setButtons(frame);
	}
	
	public static void setButtons (JFrame frame){
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JLabel l1 = new JLabel();
		l1.setBackground(Color.RED);
		l1.setOpaque(true);
		JLabel l2 = new JLabel();
		l2.setBackground(Color.GREEN);
		l2.setOpaque(true);
		JLabel l3 = new JLabel();
		l3.setBackground(Color.YELLOW);
		l3.setOpaque(true);
		JLabel l4 = new JLabel();
		l4.setBackground(Color.BLUE);
		l4.setOpaque(true);
		
		frame.add(b1);
		frame.add(l1);
		frame.add(b2);
		frame.add(l2);
		frame.add(l3);
		frame.add(b3);
		frame.add(l4);
		frame.add(b4);
		
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setLayout(new GridLayout(2,4, 5,5));
		frame.setResizable(false);
		
	}
}
