package avs.brainterpreter.test.app;

import java.text.ParseException;

import avs.brainterpreter.engine.BrainParser;

public class CommandLineApp {
	
	public static void main(String[] args) {
		if(args.length > 0) {
			try {
				BrainParser brainParser = new BrainParser(args[0]);
				String output = brainParser.execute();
				System.out.println(output);
			}catch (ParseException exception) {
				System.err.println(exception.getMessage());
			}
		}else {
			System.err.println("You must give the code of the program to interpret");
		}
	}
	
}
