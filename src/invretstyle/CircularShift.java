package invretstyle;

import java.util.List;

class CircularShift {
	private static final String ignore = "a#$an#$and#$as#$is#$the#$of#$"; //һЩ�����ʻ�
	
	/**
	 * ��ÿ���ַ������д�ϣ��õ��������飬�����ʺ������ڵ�����ɶԲ��ŵ�index�б���
	 * @param characters Inputģ���еõ����ļ����е���
	 * @param index ���б����ڴ���ɵ�����������������������ɵĶ�
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
