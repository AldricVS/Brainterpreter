package avs.brainterpreter.engine.constants;

public class ValidCharacters {
	public static final char POINTER_INCREMENT = '>';
	public static final char POINTER_DECREMENT = '<';
	public static final char VALUE_INCREMENT = '+';
	public static final char VALUE_DECREMENT = '-';
	public static final char VALUE_OUTPUT = '.';
	public static final char VALUE_INPUT = ',';
	public static final char LOOP_BEGIN = '[';
	public static final char LOOP_END = ']';
	
	public static boolean isValidCharacter(char c) {
		return c == ValidCharacters.LOOP_BEGIN
				|| c == ValidCharacters.LOOP_END
				|| c == ValidCharacters.POINTER_DECREMENT
				|| c == ValidCharacters.POINTER_INCREMENT
				|| c == ValidCharacters.VALUE_DECREMENT
				|| c == ValidCharacters.VALUE_INCREMENT
				|| c == ValidCharacters.VALUE_INPUT
				|| c == ValidCharacters.VALUE_OUTPUT;
	}
}
