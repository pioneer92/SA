/**
 * 
 */
package adtstyle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 12know
 *
 */
public class Output {
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	/**
	 * output方法迭代调用alphabetizer里面的方法得到按字母顺序排好序的行数据，并输出
	 * @param fOutput 输出文件
	 * @param alphabetizer 方便output方法调用alphabetizer里面的方法
	 */
	public void output(File fOutput, Alphabetizer alphabetizer) {
		try {
			fw = new FileWriter(fOutput);
			bw = new BufferedWriter(fw);
			
			for(int i = 0; i < alphabetizer.getLineCount(); i++) {
				String line = alphabetizer.getLineAsString(i);
				bw.write(line);
				bw.write("\r\n");
			}
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
