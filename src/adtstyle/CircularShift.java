/**
 * 
 */
package adtstyle;

import java.util.List;

/**
 * @author 12know
 * @version 1.1 2009年1月13日
 */
public interface CircularShift {
	
	/**
	 * 主函数调用该方法,该方法对characters中的每行的数据进行循环移位，并将移位得到的新行保存到实现LineStorage的数据结构中去
	 * @param characters 方便setup内部对characters的方法进行调用，从而得到原始行数据
	 */
	void setup(Characters characters);
	
	void addLine(String[] line);
	
	String[] getLine(int lineIndex);
	
	String getLineAsString(int lineIndex);
	
	void deleteLine(int lineIndex);
	
	int getLineCount();

	List<String[]> getAllLines();
}
