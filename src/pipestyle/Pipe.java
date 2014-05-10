/**
 * 
 */
package pipestyle;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 一个管道对象将两个读写数据流连接起来，写数据流可以向管道中写入数据，
 * 读数据流则可以在管道中有可用数据的时候读出数据
 * @author 12know
 * @version 1.0 2009年1月14日
 */
public class Pipe {

	private PipedWriter pipedWriter;
	private PipedReader pipedReader;
	/**
	 * 默认构造器，初始化读和写管道，并建立它们之间的连接
	 * @throws IOException 如不能建立连接则抛出IO异常
	 */
	public Pipe() throws IOException {
		pipedReader = new PipedReader();
		pipedWriter = new PipedWriter();
		pipedReader.connect(pipedWriter);
	}
	
	/**
	 * 从管道中读一个字符
	 * @return 读取到的一个字符
	 * @throws IOException 如不能从管道中读则抛出异常
	 */
	public int read() throws IOException {
		return pipedReader.read();
	}
	
	/**
	 * 向管道写一个字符
	 * @param c 要写入的字符
	 * @throws IOException 如不能向管道写则抛出异常
	 */
	public void write(int c) throws IOException {
		pipedWriter.write(c);
	}
//	
//	/**
//	 * 读取一行数据
//	 * @return 读取到的一行数据
//	 * @throws IOException 如果不能读取到数据则抛出异常
//	 * 该方法只能读到管道中的第一行数据，不知道为什么？*****************
//	 */
//	public String readLine() throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(pipedReader);
//		return bufferedReader.readLine();
//	}
//	
	/**
	 * 写入字符串的某一部分
	 * @param s 要写入的字符串
	 * @param off 开始读取字符处的偏移量
	 * @param len 要写入的总字符数
	 * @throws IOException 如不能写入数据则抛出异常
	 */
	public void write(String s, int off, int len) throws IOException {
		pipedWriter.write(s.toCharArray(), off, len);
	}
	
	/**
	 * 写入整个字符串
	 * @param s 要写入的字符串
	 * @throws IOException 如不能写入数据则抛出异常
	 */
	public void write(String s) throws IOException {
		pipedWriter.write(s.toCharArray());
	}
	
	/**
	 * 将读管道关闭，调用该方法后，不能再从管道中读数据
	 * @throws IOException 如不能关闭则抛出异常
	 */
	public void closeReader() throws IOException {
		pipedReader.close();
	}
	/**
	 * 将写管道关闭，调用该方法后，不能向管道中写数据
	 * @throws IOException 如不能关闭则抛出异常
	 */
	public void closeWriter() throws IOException {
		pipedWriter.flush();
		pipedWriter.close();
	}
	
}
