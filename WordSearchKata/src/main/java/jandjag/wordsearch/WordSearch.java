package jandjag.wordsearch;

public class WordSearch {

	private char[][] rows = null;
	
	public void setRows(char[][] rows) {
		this.rows = rows;
	}

	int[][] findHorizontal(String word) {
		for (int rowNum = 0; rowNum < rows.length; rowNum++) {
			int begin = String.valueOf(rows[rowNum]).indexOf(word);
			if (begin >= 0) {
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum, begin + i};
				}
				return returnValue;
			}
		}
		return null;
	}
	
	int[][] findVertical(String word) {
		for (int col = 0; col < rows.length; col++) {
			String columnValue = buildVerticalString(col);
			int beginRow = columnValue.indexOf(word);
			if (beginRow >= 0) {
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {beginRow + i, col};
				}
				return returnValue;
			}
		}
		return null;
	}

	String buildVerticalString(int column) {
		char[] columnChars = new char[rows.length];
		for (int i = 0; i < rows.length; i++) {
			columnChars[i] = rows[i][column];
		}
		return String.valueOf(columnChars);
		
	}

}
