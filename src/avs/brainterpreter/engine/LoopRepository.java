package avs.brainterpreter.engine;

import java.util.HashMap;

import avs.brainterpreter.engine.constants.ValidCharacters;

/**
 * Repository that will contain each loop informations (the position of each bracket of each loop).
 * 
 * @author Aldric Vitali Silvestre <aldric.vitali@outlook.fr>
 */
public class LoopRepository {
	private String program;
	
	private HashMap<Integer, Integer> openingBrackets = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> closingBrackets = new HashMap<Integer, Integer>();
	
	/**
	 * Search and compile all loops in the program
	 * @param program the program to parse
	 * @throws IllegalArgumentException if loops cannot be read properly (missing bracket for example)
	 */
	public LoopRepository(String program) throws IllegalArgumentException{
		this.program = program;
		initLoops();
	}
	
	/**
	 * Associates each '[' character with the right ']'
	 */
	private void initLoops() throws IllegalArgumentException{
		int openingBracketCount = 0;
		for(int index = 0; index < program.length(); index++){
			char c = program.charAt(index);
			if(c == ValidCharacters.LOOP_BEGIN) {
				openingBracketCount++;
			}
			if(c == ValidCharacters.LOOP_END) {
				int openingBracketIndex = searchCorrespondingBracket(index);
				if(openingBracketIndex == -1) {
					throw new IllegalArgumentException("Character " + index + " : cannot find begin loop from the closing bracket");
				}
				// put new (key, value) ==> (index of '[', index of ']')
				openingBrackets.put(openingBracketIndex, index);
				closingBrackets.put(index, openingBracketIndex);
			}
		}
		if(openingBracketCount != openingBrackets.size()) {
			throw new IllegalArgumentException("Not all loops are closed.");
		}
	}
	
	private int searchCorrespondingBracket(int closingBracketIndex) {
		for(int index = closingBracketIndex - 1; index >= 0; index--){
			char c = program.charAt(index);
			//check if character is '[' and if this character is not used in another loop
			if(c == ValidCharacters.LOOP_BEGIN && !openingBrackets.containsKey(index)) {
				return index;
			}
		}
		//n no '[' found
		return -1;
	}
	
	public int getLoopCount() {
		return openingBrackets.size();
	}
	
	public int getOpeningBracketIndex(int closingBracketIndex) {
		return closingBrackets.get(closingBracketIndex);
	}
	
	public int getClosingBracketIndex(int openingBracketIndex) {
		return openingBrackets.get(openingBracketIndex);
	}
}
