package jandjag.wordsearch;

public class WordSearch {

	private char[][] rows = null;
	
	public void setRows(char[][] rows) {
		this.rows = rows;
	}

	int[] findHorizontalColumns(char[] lineValue, String word) {
		int begin = new String(lineValue).indexOf(word);
		if (begin >= 0) {
			int[] returnValue = new int[word.length()];
			for (int i = 0; i < word.length(); i++) {
				returnValue[i] = begin + i;
			}
			return returnValue;
		}
		return null;
	}

	int[][] findHorizontal(String word) {
		for (int i = 0; i < rows.length; i++) {
			int[] foundInColumns = findHorizontalColumns(rows[i], word);
			if (foundInColumns != null) {
				int[][] returnValue = new int[foundInColumns.length][2];
				for (int r = 0; r < foundInColumns.length; r++) {
					returnValue[r] = new int[] {i, foundInColumns[r]};
				}
				return returnValue;
			}
		}
		return null;
	}

}
