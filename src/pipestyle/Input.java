/**
 * 
 */
package pipestyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 按行读取数据，传递给下一模块
 * @author 12know
 * @version 1.0 2009年1月14日
 */
public class Input extends Filter {

	private FileReader fr;
	
	
	public Input(File fInput, Pipe output) {
		super(null, output);
		try {
			fr = new FileReader(fInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按行从输入文件fr中读取数据，并将数据写到输出管道output中
	 */
	@Override
	protected void transform() {
		BufferedReader br = new BufferedReader(fr);
		try {
			String line;
			while((line = br.readLine()) != null) {
//				System.out.println("input");
//				System.out.println(line);
				output.write(line + '\n'); //加入换行是以便下个模块的处理
			}
			br.close();
			fr.close();
			output.closeWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
