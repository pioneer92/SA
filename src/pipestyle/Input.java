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
 * ���ж�ȡ���ݣ����ݸ���һģ��
 * @author 12know
 * @version 1.0 2009��1��14��
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
	 * ���д������ļ�fr�ж�ȡ���ݣ���������д������ܵ�output��
	 */
	@Override
	protected void transform() {
		BufferedReader br = new BufferedReader(fr);
		try {
			String line;
			while((line = br.readLine()) != null) {
//				System.out.println("input");
//				System.out.println(line);
				output.write(line + '\n'); //���뻻�����Ա��¸�ģ��Ĵ���
			}
			br.close();
			fr.close();
			output.closeWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
