package invretstyle;

class Pair {
	private int lineIndex; //���������е�����
	private int wordIndex; //���ʵ�ǰ�е��������������ڵ�ǰ�еĵڼ���
	
	public Pair(int line, int word) {
		this.lineIndex = line;
		this.wordIndex = word;
	}

	public int getLineIndex() {
		return lineIndex;
	}

	public int getWordIndex() {
		return wordIndex;
	}
}