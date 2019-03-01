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

	public int[][] findVertialRows(String word) {
		int[] firstLetterCoordinates = findFirstLetterCoordinates(word);
		if (firstLetterCoordinates != null) {
			int[][] returnValue = new int[word.length()][2];
			int x = firstLetterCoordinates[0];
			int y = firstLetterCoordinates[1];
			for (int i = 0; i < word.length(); i++) {
				returnValue[i] = new int[] {x, y};
				x++;
			}
			return returnValue;
		}
		return null;
	}

	private int[] findFirstLetterCoordinates(String word) {
		char firstLetter = word.charAt(0);
		for (int row = 0; row < rows.length; row++) {
			for (int col = 0; col < rows[row].length; col++) {
				if (rows[row][col] == firstLetter) {
					return new int[] {row, col};
				}
			}
		}
		return null;
	}

}
