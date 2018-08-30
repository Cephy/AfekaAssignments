package simester2.practive.SEFI_AZOULAY_HW2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SlotMachineFrame extends JFrame {

	public SlotMachineFrame(int w, int h) {

		setSize(w, h);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setLayout(new BorderLayout(5, 10));
		setVisible(true);

		JButton play = new JButton("Play");											//Play the game button
		SlotMachinePanel slotMachine = new SlotMachinePanel();						//Main Panel
		JLabel score = new JLabel("Ready to Play?!?!", (int) CENTER_ALIGNMENT);		// Score label
		add(slotMachine, BorderLayout.CENTER);
		add(play, BorderLayout.WEST);
		add(score, BorderLayout.SOUTH);

		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				slotMachine.play();
				if (slotMachine.getShapeAtIndex(0).equal(slotMachine.getShapeAtIndex(1))				//checks if all 3 shapes are the same 
						&& slotMachine.getShapeAtIndex(1).equal(slotMachine.getShapeAtIndex(2))) {
					score.setText("You Win!!!");
				} else {
					score.setText("You Lose!!!");
				}
			}
		});

	}
}
