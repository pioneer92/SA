/**
 * 
 */
package pipestyle;

/**
 * ������������ܵ�������ܵ����������
 * ������������ܵ�������ת����Ҫ������ݣ�����ת���õ�����д������ܵ���
 * ����ܵ�������ܵ�����Եģ�����ĳ���׶�����ܵ��������ݣ�����һ�׶Σ�
 * ����ܵ����ṩ���ݣ���Ϊ����ܵ�������ܵ�ͬ��ÿ���������������߳�
 * �ռ�������
 * @author 12know
 * @version 1.0 2009��1��14��
 */
public abstract class Filter implements Runnable {

	protected Pipe input;
	protected Pipe output;
	private boolean is_started = false;
	
	/**
	 * Ĭ�Ϲ�����
	 * @param input ����ܵ�
	 * @param output ����ܵ�
	 */
	public Filter(Pipe input, Pipe output) {
		this.input = input;
		this.output = output;
	}
	
	/**
	 * ����֮�����߳̿�ʼִ��
	 */
	public void start() {
		if(!is_started) { //��ֹ��ε���
			is_started = true;
			Thread thread = new Thread(this);
			thread.start();
		}
	}
	
	/**
	 * �̵߳�run����
	 */
	public void run() {
		transform();
	}
	
	/**
	 * �÷���������ܵ�������ת����Ҫ������ݣ�����ת���õ�����д������ܵ�
	 * ����ʵ�ָó��󷽷�
	 */
	abstract protected void transform();
}
