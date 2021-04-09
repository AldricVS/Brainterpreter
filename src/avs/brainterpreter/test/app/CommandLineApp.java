package avs.brainterpreter.test.app;

import avs.brainterpreter.engine.BrainParser;

public class CommandLineApp {

	public static void main(String[] args) {
		if (args.length > 0) {
			BrainParser brainParser = new BrainParser(args[0]);
			String output = brainParser.execute();
			System.out.println(output);
		} else {
			System.err.println("You must give the code of the program to interpret");
		}
	}

}
