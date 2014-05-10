package invretstyle;

import java.util.List;

class CircularShift {
	private static final String ignore = "a#$an#$and#$as#$is#$the#$of#$"; //一些噪音词汇
	
	/**
	 * 对每行字符串进行打断，得到单词数组，将单词和其所在的行组成对并放到index列表中
	 * @param characters Input模块中得到的文件所有单词
	 * @param index 该列表用于存放由单词索引和其所在行索引组成的对
	 */
	public static void circularShift(List<String []> characters, List<Pair> index) {
		for(int i = 0; i < characters.size(); i++) {
			String []line = characters.get(i);
			for(int j = 0; j < line.length; j++) {
				if(/*lines[j] != "" && */ignore.indexOf((line[j] + "#$").toLowerCase()) == -1) {
					Pair pair = new Pair(i, j);
					index.add(pair);
			//		System.out.println(pair.getWord());
				}
			}
		}
	}
}
