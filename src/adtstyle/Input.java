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
	 * ÿ��ȡһ�о���Characters�����������ͽ����д�ţ�ֱ���ļ�����Ϊֹ
	 * @param fInput �����ļ�
	 * @param characters ��Ŷ�����ÿ�е�����
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
