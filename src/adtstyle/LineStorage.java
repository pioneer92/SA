/**
 * 
 */
package adtstyle;

import java.util.List;

/**
 * �����к͵��ʣ����ﲻ���еĸ�ʽ����Ҫ���ǹ��̽ӿ�
 * @author 12know
 * @version 1.1 2009��1��13��
 */
public interface LineStorage {
	/**
	 * ��ĳ��ĳ�����ʽ�������
	 * @param word �µ���
	 * @param lineIndex	�ڼ���
	 * @param wordIndex �ڼ�������
	 */
	void setWord(int lineIndex, int wordIndex, String word);

	/**
	 * ȡ��ĳ�е�ĳ������
	 * @param lineIndex �ڼ���
	 * @param wordIndex �ڼ�������
	 * @return Ҫȡ�õĵ���
	 */
	String getWord(int lineIndex, int wordIndex);

	/**
	 * ���뵥�ʵ�ĳ�е�ĳ������֮ǰ
	 * @param word ����ĵ���
	 * @param lineIndex �ڼ���
	 * @param wordIndex ���ĸ�����ǰ����
	 */
	void insertWord(int lineIndex, int wordIndex, String word);

	/**
	 * ׷�ӵ��ʵ�ĳ��
	 * @param word ��׷�ӵĵ���
	 * @param lineIndex �ڼ���
	 */
	void addWord(int lineIndex, String word);

	/**
	 * ɾ��ĳ�е�ĳ������
	 * @param lineIndex �ڼ���
	 * @param wordIndex �ڼ�������
	 */
	void deleteWord(int lineIndex, int wordIndex);

	/**
	 * ɾ��ĳ�е����һ������
	 * @param lineIndex �ڼ���
	 */
	void deleteWord(int lineIndex);

	/**
	 * ȡ��ĳ�еĵ�����
	 * @param lineIndex �ڼ���
	 * @return ���е�����
	 */
	int getWordCount(int lineIndex);
	
	/**
	 * ����ĳ��
	 * @param line Ҫ�滻���е�������
	 * @param lineIndex �ڼ���
	 */
	void setLine(int lineIndex, String[] line);

	/**
	 * ���������ַ���
	 * @param line Ҫ������е�������
	 * @param lineIndex �ڼ���
	 */
	void insertLine(int lineIndex, String[] line);
	
	/**
	 * ׷�����е������鵽�ı���ĩβ
	 * @param line ׷�ӵ����е�������
	 */
	void addLine(String[] line);
	
	/**
	 * ȡ��ĳ�е��ַ���
	 * @param lineIndex Ҫ�õ��ĵ��������к�
	 * @return ��lineIndex���ַ���
	 */
	String[] getLine(int lineIndex);
	
	/**
	 * ȡ��ĳ�ĵ������飬�������ɵ�������ת���ɵ��ַ���
	 * @param lineIndex �ڼ���
	 * @return �ɵ�������ת���ɵ��ַ���
	 */
	String getLineAsString(int lineIndex);
	
	/**
	 * ɾ��ĳ��
	 * @param lineIndex �ڼ���
	 */
	void deleteLine(int lineIndex);
	
	/**
	 * ȡ���ı���������
	 * @return ������
	 */
	int getLineCount();

	/**
	 * ׷�������ַ������ı�ĩβ
	 * @param line ���ַ���
	 */
	void addLine(String line);
	
	/**
	 * �õ��ı���������
	 * @return���ı��е�������
	 */
	List<String[]> getAllLines();
	
	/**
	 * �������е���
	 * @param lines��������
	 */
	void setAllLines(List<String[]> lines);
}
