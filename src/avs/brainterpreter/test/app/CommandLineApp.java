package avs.brainterpreter.test.app;

import java.io.IOException;

import avs.brainterpreter.cli.CommandLineHandler;

public class CommandLineApp {

	public static void main(String[] args) {
		try {
			CommandLineHandler commandLineHandler = new CommandLineHandler(args);
			commandLineHandler.executeCommand();
		}catch (IOException exception) {
			System.err.println(exception.getMessage());
		}catch (IllegalArgumentException exception) {
			System.err.println(exception.getMessage());
		}
	}

}
