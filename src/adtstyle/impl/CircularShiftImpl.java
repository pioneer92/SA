/**
 * 
 */
package adtstyle.impl;

import java.util.List;

import adtstyle.Characters;
import adtstyle.CircularShift;
import adtstyle.LineStorage;

/**
 * @author 12know
 *
 */
public class CircularShiftImpl implements CircularShift {
	private LineStorage lineStorage = new LineStorageImpl();
	private static final String ignore = "a#$an#$and#$as#$is#$the#$of#$"; //一些噪音词汇
	
	public CircularShiftImpl() {}
	
	public CircularShiftImpl(LineStorage lineStorage) {
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
	
	

	public void setup(Characters characters) {
		int size = characters.getLineCount(); //原始文本行数
		for(int i = 0; i < size; i++) {
			String[] line = characters.getLine(i);
			for(int j = 0; j < line.length; j++) {
				if(ignore.indexOf((line[j] + "#$").toLowerCase()) != -1)//去掉噪音词汇打头的行
					continue;
				String[] newLine = new String[line.length];
				int k = 0;
				for(k = j; k < line.length; k++) {
					newLine[k - j] = line[k];
				}
				
				for(k = 0; k < j; k++) {
					newLine[k + line.length - j] = line[k];
				}
				
				addLine(newLine);
			}
		}
	}

	public int getLineCount() {
		return lineStorage.getLineCount();
	}

	public List<String[]> getAllLines() {
		return lineStorage.getAllLines();
	}

}
