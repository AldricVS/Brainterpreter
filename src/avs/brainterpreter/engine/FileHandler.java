package avs.brainterpreter.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import avs.brainterpreter.engine.constants.ValidCharacters;

public class FileHandler {
	
	String program;
	File file;
	
	public FileHandler(File file) {
		this.file = file;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void loadBrainProgram(String filename){
		File file = new File(filename);
		StringBuilder stringBuilder = new StringBuilder();
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
			String s;
			while((s = bufferedReader.readLine()) != null) {
				for(char c : s.toCharArray()) {
					if(ValidCharacters.isValidCharacter(c)) {
						stringBuilder.append(c);
					}
				}
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		program = stringBuilder.toString();
	}
}
