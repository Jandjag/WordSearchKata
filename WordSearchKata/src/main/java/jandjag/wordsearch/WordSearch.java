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

	int[][] findDiagonallyDescending(String word) {
		//Search for Diagonals starting in first column.
		for (int rowNum = 0; rowNum < rows.length; rowNum++) {
			String diagonal = buildDiagonallyDescendingString(rowNum, 0);
			int beginCol = diagonal.indexOf(word);
			if (beginCol >= 0) {
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum + beginCol + i, beginCol + i};
				}
				return returnValue;
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param startX The index of the row to start the search.
	 * @param startY The index of the column to start the search.
	 * @return String of the characters in a diagonally descending line from the rows set in the class.
	 */
	String buildDiagonallyDescendingString(int startX, int startY) {
		char[] diagonalString = new char[rows.length];
		int max = rows.length;
		
		for (int x = 0; x < max && startX < max && startY < max; x++) {
			diagonalString[x] = rows[startX][startY];
			startX++;
			startY++;
		}
		
		return String.valueOf(diagonalString);
	}

}
