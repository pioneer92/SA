/**
 * 
 */
package adtstyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import adtstyle.impl.*;
/**
 * 用抽象数据类型设计KWIC
 * @author 12know
 * @version 1.0 2009年1月11日
 */
public class ADTKwic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File fInput = new File("input.txt");
		File fOutput = new File("output.txt");
		
		Input input = new Input();
		Characters characters = new CharactersImpl();
		input.input(fInput, characters);
		
		CircularShift circularShift = new CircularShiftImpl();
		circularShift.setup(characters);
		
		Alphabetizer alphabetizer = new AlphabetizerImpl();
		alphabetizer.alph(circularShift);
		
		Output output = new Output();
		output.output(fOutput, alphabetizer);
		
		//将结果直接输出
		try {
			FileReader frInput = new FileReader(fInput);
			FileReader frOutput = new FileReader(fOutput);
			BufferedReader brInput = new BufferedReader(frInput);
			BufferedReader brOutput = new BufferedReader(frOutput);
			System.out.println("-----------------------Solution 3: ADT------------------------");
			System.out.println("---------------Input---------------");
			while(brInput.ready()) {
				System.out.println(brInput.readLine());
			}
			System.out.println("--------------Output---------------");
			while(brOutput.ready()) {
				System.out.println(brOutput.readLine());
			}
			brInput.close();
			brOutput.close();
			frInput.close();
			frOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	/*	List<String[]> lines = new ArrayList<String[]>();
		lines.add(new String[]{"1", "2", "3"});
		String[] curLine = lines.get(0);
		String[] newLine = new String[curLine.length + 1];
		for(int i = 0; i < newLine.length - 1; i++) {
			newLine[i] = curLine[i];
		}
		newLine[newLine.length - 1] = "test";
		lines.set(0, newLine);
		
		String[] line = lines.get(0);
		for(String word : line)
			System.out.println(word);
		System.exit(0);*/
	}

}
