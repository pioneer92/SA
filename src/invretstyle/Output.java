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
	 * ����alphabetedIndex�б��б���İ���ĸ�������Ϣ��characters�б���ĸ��еĵ�����Ϣ�����ɰ���ĸ�ź�����ı�
	 * @param file �����ɵ��ı���������ļ�
	 * @param characters Inputģ���еõ����ļ����е���
	 * @param alphabetedIndex �����˰���ĸ�������Ϣ
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
