/**
 * 
 */
package pipestyle;

import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * ��һ�����ݵ�����ʼ����
 * ��ԭʼ������ѭ����λ����ԭʼ�к��µ���λ������������һģ��
 * @author 12know
 * @version 1.0 2009��1��14��
 */
public class CircularShift extends Filter {

	private static final String ignore = "a#$an#$and#$as#$is#$the#$of#$"; //һЩ�����ʻ�
	
	public CircularShift(Pipe input, Pipe output) {
		super(input, output);
	}

	/**
	 * 
	 */
	@Override
	protected void transform() {
		try {
			CharArrayWriter writer= new CharArrayWriter(); //���嵱ǰ��
			int c = -1;
			while((c = input.read()) != -1) {
				if(c == 10) { //�س�����ʾwriter��ȡ����һ������
					String curLine = writer.toString();//�洢������ܵ���ȡ�õĵ�ǰ��
					String[] words = curLine.split(" +|\t+"); //����ǰ�зֽ�ɶ������
					for(int i = 0; i < words.length; i++) {
						if(ignore.indexOf((words[i] + "#$").toLowerCase()) != -1)//ȥ�������ʻ��ͷ����
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
