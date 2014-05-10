/**
 * 
 */
package adtstyle;

import java.util.List;

/**
 * @author 12know
 * @version 1.1 2009��1��13��
 */
public interface CircularShift {
	
	/**
	 * ���������ø÷���,�÷�����characters�е�ÿ�е����ݽ���ѭ����λ��������λ�õ������б��浽ʵ��LineStorage�����ݽṹ��ȥ
	 * @param characters ����setup�ڲ���characters�ķ������е��ã��Ӷ��õ�ԭʼ������
	 */
	void setup(Characters characters);
	
	void addLine(String[] line);
	
	String[] getLine(int lineIndex);
	
	String getLineAsString(int lineIndex);
	
	void deleteLine(int lineIndex);
	
	int getLineCount();

	List<String[]> getAllLines();
}
