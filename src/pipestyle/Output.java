/**
 * 
 */
package pipestyle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 12know
 *
 */
public class Output extends Filter {
	
	private FileWriter fw;
	
	/**
	 * @param input 输入管道
	 * @param output 输出文件
	 */
	public Output(Pipe input, File fOutput) {
		super(input, null);
		try {
			fw = new FileWriter(fOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	protected void transform() {
		BufferedWriter bw = new BufferedWriter(fw);
		
		try {
			int c = -1;
			while((c = input.read()) != -1) {
				bw.write(c);
			}
			input.closeReader();
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
