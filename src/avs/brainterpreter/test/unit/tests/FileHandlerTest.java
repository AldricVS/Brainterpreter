package avs.brainterpreter.test.unit.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import avs.brainterpreter.engine.helpers.FileHandler;
import avs.brainterpreter.engine.interpreter.BrainParser;

public class FileHandlerTest {
	public static final String PATH = "src/avs/brainterpreter/test/unit/tests/files/";

	public static final String EXPECTED_PROGRAM = "++++++++++[>+>+++>+++++++>++++++++++<<<<-]>>>>+++++++++++++++++."
			+ "-------.-----.+++++++++++.<<++.>>.---------------.++++++++++++++.+.<<.+.";
	
	public static final String EXPECTED_RESULT = "unit test !";

	@Test
	public void loadProgram() throws IOException {
		FileHandler fileHandler = new FileHandler(new File(PATH + "test_input.bf"));
		String program = fileHandler.loadBrainProgram();
		assertEquals(EXPECTED_PROGRAM, program);
		BrainParser brainParser = new BrainParser(program);
		assertEquals(EXPECTED_RESULT, brainParser.execute());
	}

	@Test
	public void saveProgram() throws IOException {
		File file = new File(PATH + "test_output.bf");
		FileHandler fileHandler = new FileHandler(file);
		fileHandler.saveProgram(EXPECTED_PROGRAM);
		FileReader fileReader = new FileReader(file);
		char buffer[] = new char[EXPECTED_PROGRAM.length()];
		fileReader.read(buffer);
		fileReader.close();
		assertEquals(EXPECTED_PROGRAM, String.valueOf(buffer));
		file.delete();
	}
}
