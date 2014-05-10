/**
 * 
 */
package adtstyle.impl;

import adtstyle.Characters;
import adtstyle.LineStorage;

/**
 * @author 12know
 *
 */
public class CharactersImpl implements Characters {
	
	private LineStorage lineStorage = new LineStorageImpl();
	
	public CharactersImpl() {}
	
	public CharactersImpl(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}
	
	public LineStorage getLineStorage() {
		return lineStorage;
	}

	public void setLineStorage(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}

	
	public void addLine(String[] line) {
		lineStorage.addLine(line);
	}

	
	public void deleteLine(int lineIndex) {
		lineStorage.deleteLine(lineIndex);
	}

	public String[] getLine(int lineIndex) {
		return lineStorage.getLine(lineIndex);
	}

	public String getLineAsString(int lineIndex) {
		return lineStorage.getLineAsString(lineIndex);
	}

	
	public int getLineCount() {
		return lineStorage.getLineCount();
	}

	
	public void insertLine(int lineIndex, String[] line) {
		lineStorage.insertLine(lineIndex, line);
	}

	
	public void setLine(int lineIndex, String[] line) {
		lineStorage.setLine(lineIndex, line);
	}

	public void addLine(String line) {
		lineStorage.addLine(line);
	}

}
