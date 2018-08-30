package simester2.practive.worksheet2_q1;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main_q1 {
	
	public static void main (String[] args){
		JFrame frame = new JFrame("Cephy's frame");
		
		setFrame(frame);
				
	}
	
	public static void setFrame (JFrame frame){
		frame.add(new JLabel("Your name"));
		frame.add(new JTextField(20));
		frame.add(new JLabel("Your address"));
		frame.add(new JTextField(20));
		frame.add(new JLabel ("Cellular"));
		frame.add(new JTextField (8));	
		frame.setSize(900, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10,20));
		frame.setResizable(false);
	}
	
	
}
