/**
 * 
 */
package adtstyle;

import java.util.List;

/**
 * 
 * @author 12know
 * @version 2009��1��13��
 */
public interface Alphabetizer {
	/**
	 * ���������ø÷������÷�����circularShift�еõ��������ݽ��а���ĸ˳������
	 * @param circularShift ����alph�ڲ���circularShift�ķ������е��ã��Ӷ��õ�ԭʼ������
	 */
	void alph(CircularShift circularShift);
	
	void addLine(String[] line);
	
	String[] getLine(int lineIndex);
	
	int getLineCount();
	
	void setLine(int lineIndex, String[] line);
	
	String getLineAsString(int lineIndex);
	
	List<String[]> getAllLines();
	
	void setAllLines(List<String[]> lines);
}
