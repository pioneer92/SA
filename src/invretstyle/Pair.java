package invretstyle;

class Pair {
	private int lineIndex; //单词所在行的索引
	private int wordIndex; //单词当前行的索引，即单词在当前行的第几个
	
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