package avs.brainterpreter.cli;

import java.io.File;
import java.io.IOException;

import avs.brainterpreter.engine.helpers.FileHandler;
import avs.brainterpreter.engine.interpreter.BrainParser;

public class CommandLineHandler {
	private String args[];
	
	public CommandLineHandler(String args[]) throws IllegalArgumentException{
		if(args.length < 2) {
			throw new IllegalArgumentException("At least 2 commands must be given");
		}
		this.args = args;
	}
	
	public void executeCommand() throws IOException {
		String firstCommand = args[0];
		if("-P".equals(firstCommand)) {
			executeProgram(args[1]);
		}else if("-F".equals(firstCommand)) {
			FileHandler fileHandler = new FileHandler(new File(args[1]));
			String program = fileHandler.loadBrainProgram();
			executeProgram(program);
		}else {
			throw new IllegalArgumentException("Only commands -P (providing a full program) and -F (providing a text file) can be given");
		}
	}
	
	private void executeProgram(String program) {
		BrainParser brainParser = new BrainParser(program);
		System.out.println(brainParser.execute());
	}
}
