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
	 * 从文件file中一行一行地读入，将读出的每行单词放到列表characters中
	 * @param file 输入文件
	 * @param characters 保存读取到的每行单词的列表
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
