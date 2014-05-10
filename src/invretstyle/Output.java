package invretstyle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Output {
	private static FileWriter fw;
	private static BufferedWriter bw;
	
	/**
	 * 根据alphabetedIndex列表中保存的按字母排序的信息和characters中保存的各行的单词信息，生成按字母排好序的文本
	 * @param file 将生成的文本输出到该文件
	 * @param characters Input模块中得到的文件所有单词
	 * @param alphabetedIndex 保存了按字母排序的信息
	 */
	public static void output(List<String []> characters, List<Pair> alphabetedIndex, File file) {
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			for(int i = 0; i < alphabetedIndex.size(); i++) {
				Pair pair = alphabetedIndex.get(i);
				int lineIndex = pair.getLineIndex();
				int wordIndex = pair.getWordIndex();
				String []line = characters.get(lineIndex);
				int j;
				String line1 = "";
				for (j = wordIndex; j < line.length; j++)
					if (line[j].compareTo("") != 0)
						line1 += line[j] + " ";
				for (j = 0; j < wordIndex; j++)
					if (line[j].compareTo("") != 0)
						line1 += line[j] + " ";
				line1 = line1.trim();
				bw.write(line1);
				bw.write("\r\n");
			}
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
