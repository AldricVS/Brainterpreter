package avs.brainterpreter.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainWindow extends JFrame{

	JTextArea programTextArea = new JTextArea(2, 2);
	JLabel outputTextField = new JLabel();
	JButton launchButton = new JButton("Launch program");
	
	public MainWindow() {
		super("Brainterpreter");
		init();
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void init() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(programTextArea, BorderLayout.NORTH);
		panel.add(launchButton, BorderLayout.CENTER);		
		panel.add(outputTextField, BorderLayout.SOUTH);
		this.getContentPane().add(panel);
	}
	
}
