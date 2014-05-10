/**
 * 
 */
package adtstyle.impl;

import java.util.ArrayList;
import java.util.List;

import adtstyle.LineStorage;

/**
 * @author 12know
 *
 */
public class LineStorageImpl implements LineStorage{
//	private static final String ignore = ""/*"a#$an#$and#$as#$is#$the#$of#$"*/; //“ª–©‘Î“Ù¥ ª„
	
	private List<String[]> lines = new ArrayList<String[]>();
	
	public void addLine(String[] line) {
		lines.add(line);
	}

	public void addWord(int lineIndex, String word) {
		String[] curLine = lines.get(lineIndex);
		String[] newLine = new String[curLine.length + 1];
		for(int i = 0; i < newLine.length - 1; i++) {
			newLine[i] = curLine[i];
		}
		newLine[newLine.length - 1] = word;
		lines.set(lineIndex, newLine);
	}

	public void deleteLine(int lineIndex) {
		lines.remove(lineIndex);
	}

	public void deleteWord(int lineIndex, int wordIndex) {
		String[] curLine = lines.get(lineIndex);
		String[] newLine = new String[curLine.length - 1];
		for(int i = 0; i < wordIndex; i++) {
				newLine[i] = curLine[i];
		}
		for(int j = wordIndex; j < newLine.length; j++) {
			newLine[j] = curLine[j + 1];
		}
		lines.set(lineIndex, newLine);
	}

	public void deleteWord(int lineIndex) {
		deleteWord(lineIndex, lines.get(lineIndex).length - 1);
	}

	public String[] getLine(int lineIndex) {
		return lines.get(lineIndex);
	}

	public String getLineAsString(int lineIndex) {
		String[] curLine = lines.get(lineIndex);
		String newLine = "";
		for(int i = 0; i < curLine.length; i++) {
			newLine += curLine[i];
			if(i != curLine.length - 1)
				newLine += " ";
		}
		return newLine;
	}

	public int getLineCount() {
		return lines.size();
	}

	public String getWord(int lineIndex, int wordIndex) {
		
		return lines.get(lineIndex)[wordIndex];
	}

	public int getWordCount(int lineIndex) {
		return lines.get(lineIndex).length;
	}

	public void insertLine(int lineIndex, String[] line) {
		lines.add(lineIndex, line);
	}

	public void insertWord(int lineIndex, int wordIndex, String word) {
		String[] curLine = lines.get(lineIndex);
		String[] newLine = new String[curLine.length + 1];
		for(int i = 0; i < wordIndex; i++) {
				newLine[i] = curLine[i];
		}
		newLine[wordIndex] = word;
		for(int j = wordIndex + 1; j < newLine.length; j++) {
			newLine[j] = curLine[j - 1];
		}
		lines.set(lineIndex, newLine);
	}

	public void setLine(int lineIndex, String[] line) {
		lines.set(lineIndex, line);
	}

	public void setWord(int lineIndex, int wordIndex, String word) {
		String[] curLine = lines.get(lineIndex);
		curLine[wordIndex] = word;
		lines.set(lineIndex, curLine);
	}

	public void addLine(String line) {
		String[] words = line.split(" +|\t+");
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < words.length; i++)
//			if(ignore.indexOf((words[i] + "#$").toLowerCase()) == -1)
				list.add(words[i]);
		addLine(list.toArray(new String[0]));
	}

	public List<String[]> getAllLines() {
		return lines;
	}

	public void setAllLines(List<String[]> lines) {
		this.lines.clear();
		this.lines = lines;
	}

}
