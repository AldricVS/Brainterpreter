package avs.brainterpreter.test.manual;

import java.text.ParseException;

import avs.brainterpreter.engine.interpreter.BrainParser;

public class ProgramWithoutLoopsTest {
	public static void main(String[] args) throws ParseException {
		String program = "+++++++++++++++++++++++++++++++++.>++++++++++++++++++++++++++++++++++++++++++++++++-----.>>+++++++++++++++++++++++++++++++++++++++++++++++++.<.";
		BrainParser brainParser = new BrainParser(program);
		String output = brainParser.execute();
		System.out.println(output);
	}
}
