/**
 * 
 */
package pipestyle;

/**
 * 过滤器有输入管道和输出管道两个组件。
 * 过滤器将输入管道的数据转换成要求的数据，并将转换好的数据写到输出管道。
 * 输入管道和输出管道是相对的，即在某个阶段输出管道接收数据，在下一阶段，
 * 输出管道便提供数据，成为输入管道，输入管道同理。每个过滤器在它的线程
 * 空间中运行
 * @author 12know
 * @version 1.0 2009年1月14日
 */
public abstract class Filter implements Runnable {

	protected Pipe input;
	protected Pipe output;
	private boolean is_started = false;
	
	/**
	 * 默认构造器
	 * @param input 输入管道
	 * @param output 输出管道
	 */
	public Filter(Pipe input, Pipe output) {
		this.input = input;
		this.output = output;
	}
	
	/**
	 * 调用之后则线程开始执行
	 */
	public void start() {
		if(!is_started) { //防止多次调用
			is_started = true;
			Thread thread = new Thread(this);
			thread.start();
		}
	}
	
	/**
	 * 线程的run方法
	 */
	public void run() {
		transform();
	}
	
	/**
	 * 该方法将输入管道的数据转换成要求的数据，并将转换好的数据写到输出管道
	 * 子类实现该抽象方法
	 */
	abstract protected void transform();
}
