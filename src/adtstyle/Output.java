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
	 * output������������alphabetizer����ķ����õ�����ĸ˳���ź���������ݣ������
	 * @param fOutput ����ļ�
	 * @param alphabetizer ����output��������alphabetizer����ķ���
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
