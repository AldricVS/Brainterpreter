package avs.brainterpreter.test.unit.tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import avs.brainterpreter.engine.interpreter.BrainParser;

public class NoLoopsPrgmTest {

	private static final String program = "+++++++++++++++++++++++++++++++++>+++++++++++++++++++++++++++++++++++++++++"
			+ "+++++++----->>+++++++++++++++++++++++++++++++++++++++++++++++++.<<.<.";
	
	@Test
	public void test(){
		BrainParser brainParser = new BrainParser(program);
		assertEquals("1+!", brainParser.execute());
	}

}
