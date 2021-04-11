package avs.brainterpreter.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import avs.brainterpreter.engine.interpreter.BrainParser;

import javax.swing.JScrollPane;

public class MainWindow extends JFrame{
	private static final Dimension WINDOW_DIMENSION = new Dimension(640, 480);
	
	private static final Dimension PROGRAM_DIMENSION = new Dimension(WINDOW_DIMENSION.width, WINDOW_DIMENSION.height / 2);
	private static final Dimension BUTTON_DIMENSION = new Dimension(WINDOW_DIMENSION.width, WINDOW_DIMENSION.height / 4);
	private static final Dimension OUTPUT_DIMENSION = new Dimension(WINDOW_DIMENSION.width, WINDOW_DIMENSION.height / 4);
	
	JButton launchButton = new JButton("Launch program");
	private final JTextArea programTextArea = new JTextArea(5, 10);
	private final JLabel outputTextField = new JLabel("", SwingUtilities.CENTER);
	private final JScrollPane scrollPane = new JScrollPane(programTextArea);
	
	public MainWindow() {
		super("Brainterpreter");
		setPreferredSize(WINDOW_DIMENSION);
		setMinimumSize(WINDOW_DIMENSION);
		setResizable(false);
		initLayout();
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void initLayout() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		initProgramArea();
		
		outputTextField.setPreferredSize(OUTPUT_DIMENSION);
		launchButton.setPreferredSize(BUTTON_DIMENSION);
		launchButton.addActionListener(new ActionLaunchProgram());
		
		mainPanel.add(scrollPane, BorderLayout.NORTH);
		mainPanel.add(launchButton, BorderLayout.CENTER);
		mainPanel.add(outputTextField, BorderLayout.SOUTH);
	}

	/**
	 * 
	 */
	private void initProgramArea() {
		scrollPane.setPreferredSize(PROGRAM_DIMENSION);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		programTextArea.setFont(new Font("Consolas", Font.PLAIN, 12));
		programTextArea.setWrapStyleWord(true);
		programTextArea.setLineWrap(true);
	}
	
	class ActionLaunchProgram implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				BrainParser brainParser = new BrainParser(programTextArea.getText());
				String output = brainParser.execute();
				outputTextField.setText(output);
			}catch(IllegalArgumentException exception) {
				JOptionPane.showMessageDialog(MainWindow.this, exception.getMessage(), "Syntax error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
}
