package jandjag.wordsearch;

public class WordSearch {

	private char[][] rows = null;
	private String word = null;
	
	public void setRows(char[][] rows) {
		this.rows = rows;
	}
	
	public void setWord(String word) {
		this.word = word;
	}

	public int[][] find() {
		int[][] searchResult = null;
		
		searchResult = findHorizontal();
		if (searchResult != null) {
			return searchResult;
		}
		
		searchResult = findVertical();
		if (searchResult != null) {
			return searchResult;
		}

		searchResult = findDiagonallyDescending();
		if (searchResult != null) {
			return searchResult;
		}

		searchResult = findDiagonallyAscending();
		if (searchResult != null) {
			return searchResult;
		}
		
		return null;
	}
	
	private int[][] findHorizontal() {
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
		
		//Test if it is reversed.
		String reverseWord = reverse(word);
		for (int rowNum = 0; rowNum < rows.length; rowNum++) {
			int begin = String.valueOf(rows[rowNum]).indexOf(reverseWord);
			if (begin >= 0) {
				int end = begin + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum, end - i};
				}
				return returnValue;
			}
		}		
		
		return null;
	}
	
	private int[][] findVertical() {
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
			
			//Try in the reverse
			String reverseWord = reverse(word);
			beginRow = columnValue.indexOf(reverseWord);
			if (beginRow >= 0) {
				int end = beginRow + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {end - i, col};
				}
				return returnValue;
			}
		}
		return null;
	}

	private String reverse(String word) {
		return new StringBuilder(word).reverse().toString();
	}

	private String buildVerticalString(int column) {
		char[] columnChars = new char[rows.length];
		for (int i = 0; i < rows.length; i++) {
			columnChars[i] = rows[i][column];
		}
		return String.valueOf(columnChars);
	}

	private int[][] findDiagonallyDescending() {
		//Search for Diagonals starting in first column.
		for (int rowNum = 0; rowNum < rows.length; rowNum++) {
			String diagonal = buildDiagonalDescendingString(rowNum, 0);
			int beginCol = diagonal.indexOf(word);
			if (beginCol >= 0) {
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum + beginCol + i, beginCol + i};
				}
				return returnValue;
			}
			
			//Check if it is reversed.
			String reverseWord = reverse(word);
			beginCol = diagonal.indexOf(reverseWord);
			if (beginCol >= 0) {
				int end = beginCol + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum + end - i, end - i};
				}
				return returnValue;
			}
		}
		
		//Search the diagonals that start on the top.
		for (int colNum = 1; colNum < rows.length; colNum++) {
			String diagonal = buildDiagonalDescendingString(0, colNum);
			int beginRow = diagonal.indexOf(word);
			if (beginRow >= 0) {
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {colNum - 1 + beginRow + i, beginRow + 1 + i};
				}
				return returnValue;
			}
			
			//Check if it is reversed.
			String reverseWord = reverse(word);
			beginRow = diagonal.indexOf(reverseWord);
			if (beginRow >= 0) {
				int end = beginRow + reverseWord.length();
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {end - 1 - i, end - i};
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
	private String buildDiagonalDescendingString(int startX, int startY) {
		String diagonalString = "";
		int max = rows.length;
		
		for (int x = 0; x < max && startX < max && startY < max; x++) {
			diagonalString += rows[startX][startY];
			startX++;
			startY++;
		}
		
		return diagonalString;
	}

	private int[][] findDiagonallyAscending() {
		//Search for Diagonals starting in first column.
		for (int rowNum = 0; rowNum < rows.length; rowNum++) {
			String diagonal = buildDiagonalAscendingString(rowNum, 0);
			int beginCol = diagonal.indexOf(word);
			if (beginCol >= 0) {
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum - beginCol - i, beginCol + i};
				}
				return returnValue;
			}
			
			//Check for reverse.
			String reverseWord = reverse(word);
			beginCol = diagonal.indexOf(reverseWord);
			if (beginCol >= 0) {
				int end = beginCol + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum - end + i, end - i};
				}
				return returnValue;
			}
		}
		
		//Search the diagonals that start on the bottom.
		for (int colNum = 1; colNum < rows.length; colNum++) {
			String diagonal = buildDiagonalAscendingString(rows.length - 1, colNum);
			int beginRow = diagonal.indexOf(word);
			if (beginRow >= 0) {
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rows.length + beginRow - i, beginRow + 1 + i};
				}
				return returnValue;
			}
			
			//Check for reverse.
			String reverseWord = reverse(word);
			beginRow = diagonal.indexOf(reverseWord);
			if (beginRow >= 0) {
				int end = beginRow + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rows.length - end + i, end + 1 - i};
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
	 * @return String of the characters in a diagonally ascending line from the rows set in the class.
	 */
	private String buildDiagonalAscendingString(int startX, int startY) {
		String diagonalString = "";
		int max = rows.length;
		
		for (int x = 0; x < max && startX >= 0 && startX < max && startY < max; x++) {
			diagonalString += rows[startX][startY];
			startX--;
			startY++;
		}
		
		return diagonalString;
	}

}
