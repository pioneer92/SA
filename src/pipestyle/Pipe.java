/**
 * 
 */
package pipestyle;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * һ���ܵ�����������д����������������д������������ܵ���д�����ݣ�
 * ��������������ڹܵ����п������ݵ�ʱ���������
 * @author 12know
 * @version 1.0 2009��1��14��
 */
public class Pipe {

	private PipedWriter pipedWriter;
	private PipedReader pipedReader;
	/**
	 * Ĭ�Ϲ���������ʼ������д�ܵ�������������֮�������
	 * @throws IOException �粻�ܽ����������׳�IO�쳣
	 */
	public Pipe() throws IOException {
		pipedReader = new PipedReader();
		pipedWriter = new PipedWriter();
		pipedReader.connect(pipedWriter);
	}
	
	/**
	 * �ӹܵ��ж�һ���ַ�
	 * @return ��ȡ����һ���ַ�
	 * @throws IOException �粻�ܴӹܵ��ж����׳��쳣
	 */
	public int read() throws IOException {
		return pipedReader.read();
	}
	
	/**
	 * ��ܵ�дһ���ַ�
	 * @param c Ҫд����ַ�
	 * @throws IOException �粻����ܵ�д���׳��쳣
	 */
	public void write(int c) throws IOException {
		pipedWriter.write(c);
	}
//	
//	/**
//	 * ��ȡһ������
//	 * @return ��ȡ����һ������
//	 * @throws IOException ������ܶ�ȡ���������׳��쳣
//	 * �÷���ֻ�ܶ����ܵ��еĵ�һ�����ݣ���֪��Ϊʲô��*****************
//	 */
//	public String readLine() throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(pipedReader);
//		return bufferedReader.readLine();
//	}
//	
	/**
	 * д���ַ�����ĳһ����
	 * @param s Ҫд����ַ���
	 * @param off ��ʼ��ȡ�ַ�����ƫ����
	 * @param len Ҫд������ַ���
	 * @throws IOException �粻��д���������׳��쳣
	 */
	public void write(String s, int off, int len) throws IOException {
		pipedWriter.write(s.toCharArray(), off, len);
	}
	
	/**
	 * д�������ַ���
	 * @param s Ҫд����ַ���
	 * @throws IOException �粻��д���������׳��쳣
	 */
	public void write(String s) throws IOException {
		pipedWriter.write(s.toCharArray());
	}
	
	/**
	 * �����ܵ��رգ����ø÷����󣬲����ٴӹܵ��ж�����
	 * @throws IOException �粻�ܹر����׳��쳣
	 */
	public void closeReader() throws IOException {
		pipedReader.close();
	}
	/**
	 * ��д�ܵ��رգ����ø÷����󣬲�����ܵ���д����
	 * @throws IOException �粻�ܹر����׳��쳣
	 */
	public void closeWriter() throws IOException {
		pipedWriter.flush();
		pipedWriter.close();
	}
	
}
