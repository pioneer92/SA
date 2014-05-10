/**
 * 
 */
package adtstyle;

/**
 * 模块Input调用该模块的各种操作来将读取到的每行的数据保存到实现LineStorage接口的数据结构中去
 * @author 12know
 * @version 1.1 2009年1月13日
 */
public interface Characters {
	
	void setLine(int lineIndex, String[] line);

	void insertLine(int lineIndex, String[] line);
	
	void addLine(String[] line);
	
	String[] getLine(int lineIndex);
	
	String getLineAsString(int lineIndex);
	
	void deleteLine(int lineIndex);
	
	int getLineCount();
	
	void addLine(String line);
}
