/**
 * 
 */
package adtstyle;

import java.util.List;

/**
 * 管理行和单词，这里不对行的格式做出要求，是过程接口
 * @author 12know
 * @version 1.1 2009年1月13日
 */
public interface LineStorage {
	/**
	 * 对某行某个单词进行设置
	 * @param word 新单词
	 * @param lineIndex	第几行
	 * @param wordIndex 第几个单词
	 */
	void setWord(int lineIndex, int wordIndex, String word);

	/**
	 * 取得某行的某个单词
	 * @param lineIndex 第几行
	 * @param wordIndex 第几个单词
	 * @return 要取得的单词
	 */
	String getWord(int lineIndex, int wordIndex);

	/**
	 * 插入单词到某行的某个单词之前
	 * @param word 插入的单词
	 * @param lineIndex 第几行
	 * @param wordIndex 在哪个单词前插入
	 */
	void insertWord(int lineIndex, int wordIndex, String word);

	/**
	 * 追加单词到某行
	 * @param word 被追加的单词
	 * @param lineIndex 第几行
	 */
	void addWord(int lineIndex, String word);

	/**
	 * 删除某行的某个单词
	 * @param lineIndex 第几行
	 * @param wordIndex 第几个单词
	 */
	void deleteWord(int lineIndex, int wordIndex);

	/**
	 * 删除某行的最后一个单词
	 * @param lineIndex 第几行
	 */
	void deleteWord(int lineIndex);

	/**
	 * 取得某行的单词数
	 * @param lineIndex 第几行
	 * @return 该行单词数
	 */
	int getWordCount(int lineIndex);
	
	/**
	 * 设置某行
	 * @param line 要替换的行单词数组
	 * @param lineIndex 第几行
	 */
	void setLine(int lineIndex, String[] line);

	/**
	 * 插入行字字符串
	 * @param line 要插入的行单词数组
	 * @param lineIndex 第几行
	 */
	void insertLine(int lineIndex, String[] line);
	
	/**
	 * 追加新行单词数组到文本的末尾
	 * @param line 追加的新行单词数组
	 */
	void addLine(String[] line);
	
	/**
	 * 取得某行的字符串
	 * @param lineIndex 要得到的单词数组行号
	 * @return 第lineIndex行字符串
	 */
	String[] getLine(int lineIndex);
	
	/**
	 * 取得某的单词数组，并返回由单词数组转换成的字符串
	 * @param lineIndex 第几行
	 * @return 由单词数组转换成的字符串
	 */
	String getLineAsString(int lineIndex);
	
	/**
	 * 删除某行
	 * @param lineIndex 第几行
	 */
	void deleteLine(int lineIndex);
	
	/**
	 * 取得文本的总行数
	 * @return 总行数
	 */
	int getLineCount();

	/**
	 * 追加新行字符串到文本末尾
	 * @param line 行字符串
	 */
	void addLine(String line);
	
	/**
	 * 得到文本的所有行
	 * @return　文本中的所有行
	 */
	List<String[]> getAllLines();
	
	/**
	 * 设置所有的行
	 * @param lines　所有行
	 */
	void setAllLines(List<String[]> lines);
}
