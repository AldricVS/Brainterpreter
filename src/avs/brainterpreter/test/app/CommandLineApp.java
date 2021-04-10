package avs.brainterpreter.test.app;

import java.io.IOException;

import com.formdev.flatlaf.FlatDarkLaf;

import avs.brainterpreter.cli.CommandLineHandler;
import avs.brainterpreter.gui.MainWindow;

public class CommandLineApp {

	public static void main(String[] args) {
		if (args.length < 2) {
			FlatDarkLaf.install();
			new MainWindow();
		} else {
			try {
				CommandLineHandler commandLineHandler = new CommandLineHandler(args);
				commandLineHandler.executeCommand();
			} catch (IOException exception) {
				System.err.println(exception.getMessage());
			} catch (IllegalArgumentException exception) {
				System.err.println(exception.getMessage());
			}
		}
	}

}
