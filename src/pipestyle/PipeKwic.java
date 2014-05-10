/**
 * 
 */
package pipestyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 用管道/过滤器风格设计KWIC
 * @author 12know
 * @version 1.0 2009年1月14日
 */
public class PipeKwic {

	public static boolean is_completed = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File fInput = new File(System.getProperty("user.dir") + "\\input.txt");
			File fOutput = new File("output.txt");
//			System.out.println(System.getProperty("user.dir"));
			Pipe in_cs = new Pipe();
			Pipe cs_al = new Pipe();
			Pipe al_ou = new Pipe();
			
			Input input = new Input(fInput, in_cs);
	//		input.transform();
			CircularShift shift = new CircularShift(in_cs, cs_al);
	//		shift.transform();
			Alphabetizer alpha = new Alphabetizer(cs_al, al_ou);
//			alpha.transform();
			Output output = new Output(al_ou, fOutput);
//			output.transform();
			input.start(); // run it !
			shift.start();
			alpha.start();
			output.start();
			
			// 将结果直接输出
			FileReader frInput = new FileReader(fInput);
			FileReader frOutput = new FileReader(fOutput);
			BufferedReader brInput = new BufferedReader(frInput);
			BufferedReader brOutput = new BufferedReader(frOutput);
			System.out.println("-----------------------Solution 1: Pipe/Filter------------------------");
			System.out.println("---------------Input---------------");
			while(brInput.ready()) {
				System.out.println(brInput.readLine());
			}
			System.out.println("--------------Output---------------");
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			while(brOutput.ready()) {
				System.out.println(brOutput.readLine());
			}
			brInput.close();
			brOutput.close();
			frInput.close();
			frOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
