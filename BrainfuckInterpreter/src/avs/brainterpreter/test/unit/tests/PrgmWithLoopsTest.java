package avs.brainterpreter.test.unit.tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import avs.brainterpreter.engine.BrainParser;

public class PrgmWithLoopsTest {

	private static final String program = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
	
	@Test
	public void test() throws ParseException {
		BrainParser brainParser = new BrainParser(program);
		String output = brainParser.execute();
		assertEquals("Hello World!\n", output);
	}

}
