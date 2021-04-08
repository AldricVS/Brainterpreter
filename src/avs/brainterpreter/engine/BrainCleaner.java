package avs.brainterpreter.engine;

import avs.brainterpreter.engine.constants.ValidCharacters;

/**
 * Helper class that removes all non important characters (comments, spaces, return lines, ...)
 * 
 * @author Aldric Vitali Silvestre <aldric.vitali@outlook.fr>
 */
public class BrainCleaner {
	private String stringToClean;

	public BrainCleaner(String stringToParse) {
		this.stringToClean = stringToParse;
	}

	public String getStringToParse() {
		return stringToClean;
	}

	public void setStringToParse(String stringToParse) {
		this.stringToClean = stringToParse;
	}
	
	public String cleanString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(char c : stringToClean.toCharArray()) {
			if(isValidCharacter(c)) {
				stringBuilder.append(c);
			}
		}
		return stringBuilder.toString();
	}

	private boolean isValidCharacter(char c) {
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
