package invretstyle;

import java.util.List;

class Alphabetizer {
	/**
	 * ��ģ��CircularShift�еõ��ĵ�����������������������ɵĶԣ���index�������ʵ���ĸ˳������,
	 * Ȼ�󸳸�alphabetedIndex
	 * @param characters Inputģ���еõ����ļ����е���
	 * @param index ���б����ڴ���ɵ�����������������������ɵĶ�
	 * @param alphabetedIndex ��������ĸ˳���ź���ĵ�����������������������ɵĶ�
	 */
	public static void alphabetizer(List<String []> characters, List<Pair> index, List<Pair> alphabetedIndex) {
		alphabetedIndex.addAll(index);
		
		//���������ò��������㷨��������
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
