/**
 * 
 */
package adtstyle.impl;

import java.util.Comparator;
import java.util.List;

import adtstyle.Alphabetizer;
import adtstyle.CircularShift;
import adtstyle.LineStorage;

/**
 * @author 12know
 *
 */
public class AlphabetizerImpl implements Alphabetizer {
	private LineStorage lineStorage = new LineStorageImpl();
	
	public AlphabetizerImpl() {}
	
	public AlphabetizerImpl(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}
	
	public LineStorage getLineStorage() {
		return lineStorage;
	}

	public void setLineStorage(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}

	public void addLine(String[] line) {
		lineStorage.addLine(line);
	}

	public void alph(CircularShift circularShift) {
//		int size = circularShift.getLineCount();
//		for(int i = 0; i < size; i++)
//			addLine(circularShift.getLine(i));
		
		//插入排序
//		for(int i = 1; i < size; i++) {
//			String[] temp = getLine(i);
//			int j;
//			for(j = i - 1; j >= 0; j--) {
//				if(temp[0].compareToIgnoreCase(getLine(j)[0]) < 0)
//					setLine(j + 1, getLine(j));
//				else break;
//			}
//			setLine(j + 1, temp);
//		}
		
		//快速排序
		List<String[]> lines = circularShift.getAllLines();
		qSort(lines, 0, lines.size() - 1, new Comparator<String[]>() {

			public int compare(String[] o1, String[] o2) {
				if(o1[0].compareToIgnoreCase(o2[0]) == 0)
					return 0;
				else if(o1[0].compareToIgnoreCase(o2[0]) > 0)
					return 1;
				else
					return -1;
			}
			
		});
		
//		for(String[] line : lines)
//			System.out.println(line[0]);
		setAllLines(lines);
		
//		lines = getAllLines();
//		for(String[] line : lines)
//			System.out.println(line[0]);
	}

	public String[] getLine(int lineIndex) {
		return lineStorage.getLine(lineIndex);
	}

	public int getLineCount() {
		return lineStorage.getLineCount();
	}

	public void setLine(int lineIndex, String[] line) {
		lineStorage.setLine(lineIndex, line);
	}
	
	public String getLineAsString(int lineIndex) {
		return lineStorage.getLineAsString(lineIndex);
	}
	
	public List<String[]> getAllLines() {
		return lineStorage.getAllLines();
	}
	
	public void setAllLines(List<String[]> lines) {
		lineStorage.setAllLines(lines);
	}
	
	//下面是快速排序算法
	public static <T> void qSort(List<T> a, int p, int r, Comparator<? super T> c)
	{
		if(p < r)
		{
			int q = partition(a, p, r, c);
			qSort(a, p, q - 1, c);
			qSort(a, q + 1, r, c);
		}
	}
	
	private static <T> int partition(List<T> a, int p, int r, Comparator<? super T> c) {
		int i = p;
		int j = r + 1;
		while (true) {
			
			while (c.compare(a.get(++i), a.get(p)) <= 0)
				if (i == r)
					break;
			while (c.compare(a.get(p), a.get(--j)) <= 0)
				if (j == p)
					break;
			if (i >= j)
				break;
				swap(a, i, j);
		}
		swap(a, j, p);
		return j;
	} 

	private static <T> void swap(List<T> a, int i, int j)
	{
		T temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}
	
}
