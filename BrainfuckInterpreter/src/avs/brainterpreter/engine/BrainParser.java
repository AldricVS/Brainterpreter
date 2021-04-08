package avs.brainterpreter.engine;

import java.text.ParseException;

import avs.brainterpreter.engine.constants.ValidCharacters;

/**
 * The main class that will execute the program and display the result
 * 
 * @author Aldric Vitali Silvestre <aldric.vitali@outlook.fr>
 */
public class BrainParser {
	private String program;

	private MemoryHandler memoryHandler = new MemoryHandler();
	private LoopRepository loopRepository;

	/**
	 * Init class and search for loops in the program string to index them
	 * 
	 * @param program the full program in one string
	 * @throws ParseException
	 */
	public BrainParser(String program) throws ParseException {
		BrainCleaner brainCleaner = new BrainCleaner(program);
		this.program = brainCleaner.cleanString();
		loopRepository = new LoopRepository(this.program);
	}

	public String execute() {
		StringBuilder stringBuilder = new StringBuilder();
		byte currentMemoryValue;
		for (int index = 0; index < program.length(); index++) {
			char currentOperation = program.charAt(index);
			switch (currentOperation) {
			case ValidCharacters.VALUE_OUTPUT:
				currentMemoryValue = memoryHandler.getCurrentMemoryValue();
				stringBuilder.append((char) currentMemoryValue);
				break;
			case ValidCharacters.VALUE_INCREMENT:
				memoryHandler.incrementValue();
				break;
			case ValidCharacters.VALUE_DECREMENT:
				memoryHandler.decrementValue();
				break;
			case ValidCharacters.POINTER_INCREMENT:
				memoryHandler.incrementPointer();
				break;
			case ValidCharacters.POINTER_DECREMENT:
				memoryHandler.decrementPointer();
				break;
			case ValidCharacters.LOOP_BEGIN:
				// if memory block under pointer is equals to 0, then go to end of loop
				currentMemoryValue = memoryHandler.getCurrentMemoryValue();
				if(currentMemoryValue == 0) {
					index = loopRepository.getClosingBracketIndex(index);
				}
				break;
			case ValidCharacters.LOOP_END:
				// if memory block under pointer is different to 0, return to begin of loop
				currentMemoryValue = memoryHandler.getCurrentMemoryValue();
				if(currentMemoryValue != 0) {
					index = loopRepository.getOpeningBracketIndex(index);
				}
				break;
			}
		}

		return stringBuilder.toString();
	}
}
