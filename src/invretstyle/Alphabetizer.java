package invretstyle;

import java.util.List;

class Alphabetizer {
	/**
	 * 对模块CircularShift中得到的单词索引和其所在行索引组成的对，即index，按单词的字母顺序排序,
	 * 然后赋给alphabetedIndex
	 * @param characters Input模块中得到的文件所有单词
	 * @param index 该列表用于存放由单词索引和其所在行索引组成的对
	 * @param alphabetedIndex 按单词字母顺序排好序的单词索引和其所在行索引组成的对
	 */
	public static void alphabetizer(List<String []> characters, List<Pair> index, List<Pair> alphabetedIndex) {
		alphabetedIndex.addAll(index);
		
		//下面是利用插入排序算法进行排序
		for(int i = 1; i < alphabetedIndex.size(); i++) {
			Pair temp = alphabetedIndex.get(i);
			int wordIndex1 = temp.getWordIndex();
			int lineIndex1 = temp.getLineIndex();
			String str1 = characters.get(lineIndex1)[wordIndex1];
			int j;
			for(j = i - 1; j >= 0; j--) {

				int wordIndex2 = alphabetedIndex.get(j).getWordIndex();
				int lineIndex2 = alphabetedIndex.get(j).getLineIndex();
				
				String str2 = characters.get(lineIndex2)[wordIndex2];
				if(str1.compareToIgnoreCase(str2) < 0) {
					alphabetedIndex.set(j + 1, alphabetedIndex.get(j));
				} else break;
			}
			alphabetedIndex.set(j + 1, temp);
		}
	}
}
