package avs.brainterpreter.engine.interpreter;

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
			if(ValidCharacters.isValidCharacter(c)) {
				stringBuilder.append(c);
			}
		}
		return stringBuilder.toString();
	}
}
