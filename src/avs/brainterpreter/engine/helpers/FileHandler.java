package avs.brainterpreter.engine.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import avs.brainterpreter.engine.constants.ValidCharacters;

public class FileHandler {
	File file;

	public FileHandler(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String loadBrainProgram() throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String s;
		while ((s = bufferedReader.readLine()) != null) {
			for (char c : s.toCharArray()) {
				if (ValidCharacters.isValidCharacter(c)) {
					stringBuilder.append(c);
				}
			}
		}
		bufferedReader.close();
		return stringBuilder.toString();
	}

	public void saveProgram(String program) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(program);
		fileWriter.close();
	}
}
