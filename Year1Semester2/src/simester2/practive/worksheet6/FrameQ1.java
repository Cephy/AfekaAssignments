package simester2.practive.worksheet6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class FrameQ1 extends JFrame {

	private JLabel label = new JLabel("", SwingConstants.CENTER);
	private JPanel panel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JLabel emptyLabel = new JLabel();
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");

	public FrameQ1() {
		setSize(360, 300);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

		panel.setLayout(new BorderLayout(5, 10));
		label.setVisible(true);
		panel.add(label, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
		button1.addActionListener(new Button());
		button2.addActionListener(new Button());
		button3.addActionListener(new Button());
		JLabel emptyLabel2 = new JLabel();
		buttonPanel.setLayout(new GridLayout(1, 5));
		buttonPanel.add(emptyLabel);
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(emptyLabel2);
		add(buttonPanel, BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeiconified(WindowEvent e) {
				label.setText("WELCOME!");
			
			}
		});
	}

	class Button implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// label.setText(e.getActionCommand());

			if (e.getSource() == button1) {
				label.setText("1");
			}
			if (e.getSource() == button2) {
				label.setText("2");
			}
			if (e.getSource() == button3) {
				label.setText("3");
			}
		}
	}
}
