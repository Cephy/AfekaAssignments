package simester2.practive.worksheet5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CreatFrameQ3 extends JFrame{
	
	public CreatFrameQ3(){
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setVisible(true);
		
		PaintCircle tmp = new PaintCircle();
		add(tmp);
		JButton goButton = new JButton("Go");
		goButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				tmp.jump();
			}
		});
		add(goButton);
		
	}
	
}
