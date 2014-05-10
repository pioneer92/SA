/**
 * 
 */
package invretstyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用调用/返回风格设计KWIC
 * @author 12know
 * @version 2.0 2009年1月11日
 */
public class InvRetKwic {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {
		File fInput = new File("input.txt");
		File fOutput = new File("output.txt");
		List<String []> characters = new ArrayList<String []>();
		List<Pair> index = new ArrayList<Pair>();
		List<Pair> alphabetedIndex = new ArrayList<Pair>();
        Input.input(fInput, characters);
		CircularShift.circularShift(characters, index);
		Alphabetizer.alphabetizer(characters, index, alphabetedIndex);
		Output.output(characters, alphabetedIndex, fOutput);			
		
		//将结果直接输出
		try {
			FileReader frInput = new FileReader(fInput);
			FileReader frOutput = new FileReader(fOutput);
			BufferedReader brInput = new BufferedReader(frInput);
			BufferedReader brOutput = new BufferedReader(frOutput);
			System.out.println("-----------------------Solution 2: Call/Return------------------------");
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
		
		
	}

}
