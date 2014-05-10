/**
 * 
 */
package pipestyle;

import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * 第一行数据到来后开始运作
 * 把原始数据行循环移位，将原始行和新的移位后的行输出给下一模块
 * @author 12know
 * @version 1.0 2009年1月14日
 */
public class CircularShift extends Filter {

	private static final String ignore = "a#$an#$and#$as#$is#$the#$of#$"; //一些噪音词汇
	
	public CircularShift(Pipe input, Pipe output) {
		super(input, output);
	}

	/**
	 * 
	 */
	@Override
	protected void transform() {
		try {
			CharArrayWriter writer= new CharArrayWriter(); //缓冲当前行
			int c = -1;
			while((c = input.read()) != -1) {
				if(c == 10) { //回车，表示writer中取得了一行数据
					String curLine = writer.toString();//存储从输入管道中取得的当前行
					String[] words = curLine.split(" +|\t+"); //将当前行分解成多个单词
					for(int i = 0; i < words.length; i++) {
						if(ignore.indexOf((words[i] + "#$").toLowerCase()) != -1)//去掉噪音词汇打头的行
							continue;
						String shift = "";
						for(int j = i; j < (words.length + i); j++) {
							shift += words[j % words.length];
							if (j < (words.length + i - 1))
								shift += " ";
						}
						shift += "\r\n";
						output.write(shift);
						writer.reset();
					}
				} else 
					writer.write(c);
			}
			input.closeReader();
			output.closeWriter();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
