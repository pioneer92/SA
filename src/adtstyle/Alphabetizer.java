/**
 * 
 */
package adtstyle;

import java.util.List;

/**
 * 
 * @author 12know
 * @version 2009年1月13日
 */
public interface Alphabetizer {
	/**
	 * 主函数调用该方法，该方法对circularShift中得到的行数据进行按字母顺序排序
	 * @param circularShift 方便alph内部对circularShift的方法进行调用，从而得到原始行数据
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
