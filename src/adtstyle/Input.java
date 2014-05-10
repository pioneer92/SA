/**
 * 
 */
package adtstyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author 12know
 *
 */
public class Input {
	
	private FileReader fr;
	private BufferedReader br;
	
	/**
	 * 每读取一行就用Characters抽象数据类型将该行存放，直到文件读完为止
	 * @param fInput 输入文件
	 * @param characters 存放读到的每行的数据
	 */
	public void input(File fInput, Characters characters) {
		try {
			fr = new FileReader(fInput);
			br = new BufferedReader(fr);
			while(br.ready()) {
				characters.addLine(br.readLine());
			}
			br.close();
			fr.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
