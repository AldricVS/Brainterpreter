package avs.brainterpreter.engine.interpreter;

/**
 * All the 30 000 bytes that brainfuck can handle will be stored in this class.
 * This class will help to manage memory and have the pointer at the right place 
 * 
 * @author Aldric Vitali Silvestre <aldric.vitali@outlook.fr>
 */
public class MemoryHandler {
	private static final int MAX_INDEX = 30_000;

	private byte memory[] = new byte[MAX_INDEX];
	
	private int pointer = 0;

	public MemoryHandler() {
	}

	public int getPointer() {
		return pointer;
	}
	
	public byte getCurrentMemoryValue() {
		return memory[pointer];
	}

	public void incrementPointer() {
		if(pointer < MAX_INDEX) {
			pointer++;
		}
	}
	
	public void decrementPointer() {
		if(pointer > 0) {
			pointer--;
		}
	}
	
	public void incrementValue() {
		memory[pointer]++;
	}
	
	public void decrementValue() {
		memory[pointer]--;
	}
}
