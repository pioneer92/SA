package invretstyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


class Input {
	private static FileReader fr;
	private static BufferedReader br;
	
	/**
	 * ���ļ�file��һ��һ�еض��룬��������ÿ�е��ʷŵ��б�characters��
	 * @param file �����ļ�
	 * @param characters �����ȡ����ÿ�е��ʵ��б�
	 */
	public static void input(File file, List<String []> characters) {
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while(br.ready()) {
				characters.add(br.readLine().split(" +|\t+"));
			}
			br.close();
			fr.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
