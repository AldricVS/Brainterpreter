package avs.brainterpreter.test.unit.tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import avs.brainterpreter.engine.BrainParser;
import avs.brainterpreter.engine.LoopRepository;

public class LoopParserTest {
	
	// 5 loops
	private static final String testString = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++[++[+]]+..+++.>++.<<+++++++[++[+++]+]++.>.+++.------.--------.>+.>.";
	
	// loop without end
	private static final String invalidTestString = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+[++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
	
	//loop without begin
	private static final String invalidTestString2 = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++].>+.+[++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
	
	@Test
	public void testValid() throws ParseException{
		LoopRepository loopRepository = new LoopRepository(testString);
		assertEquals(5, loopRepository.getLoopCount());
	}

	@Test(expected = ParseException.class)
	public void testInvalid() throws ParseException{
		new LoopRepository(invalidTestString);
	}
	
	@Test(expected = ParseException.class)
	public void testInvalid2() throws ParseException{
		new BrainParser(invalidTestString2);
	}
}
