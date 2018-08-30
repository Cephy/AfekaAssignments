package simester2.practive.worksheet2_q1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main_q4 {

	public static void main(String[] args){
		JFrame frame = new JFrame("Calculator");
		JPanel numbersPanel = new JPanel(new GridLayout(4,3));
		setNumbersPanel(numbersPanel);
		JPanel actionsPanel = new JPanel (new GridLayout(4,2)); 
		setActionsButtons(actionsPanel);
		JPanel imageLabel = new JPanel();
		setLabel(imageLabel);
		
		frame.getContentPane().add(imageLabel, BorderLayout.NORTH);
		frame.getContentPane().add(actionsPanel,BorderLayout.WEST);
		frame.getContentPane().add(numbersPanel, BorderLayout.EAST);
		
		
		setFrame(frame);
	}
	
	public static void setFrame (JFrame frame){
		frame.setSize(250,250);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
	}
	
	public static void setNumbersPanel (JPanel numbersPanel){
		final int NUMBER_OF_COLUMNS = 3;
		final int NUMBER_OF_ROWS = 3;
		int firstButton = 7;
		for(int row=0 ; row<NUMBER_OF_ROWS ; row++ ){
			for(int column=0 ; column<NUMBER_OF_COLUMNS ; column++){
				numbersPanel.add(new JButton("" + firstButton));
				firstButton++;
			}
			firstButton-=5;
		}
		numbersPanel.add(new JButton("0"));
		numbersPanel.add(new JButton(""));
		numbersPanel.add(new JButton(""));
	}
	
	public static void setActionsButtons (JPanel actionsButtons){
		String[] str = {"%","+/-","X",":","+","-"};
		
		for(int i=0 ; i<str.length ; i++){
			actionsButtons.add(new JButton(str[0]));
		}
		actionsButtons.add(new JButton(""));
		JButton equal = new JButton("=");
		equal.setBorder(new LineBorder(Color.BLUE));
		actionsButtons.add(equal);
	}
	
	public static void setLabel (JPanel imageLabel){
		imageLabel.setBackground(Color.WHITE);
		JLabel label = new JLabel(new ImageIcon("image/correct.jpg"));
		label.setVisible(true);
		label.setOpaque(true);
		imageLabel.add(label);
		imageLabel.setPreferredSize(new Dimension(5,50));
	}
	
	
	
}
