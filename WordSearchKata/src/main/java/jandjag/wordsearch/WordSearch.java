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
			SearchDirection direction = SearchDirection.HORIZONTAL;
			String rowAsString = buildDirectionalStringFromRows(rowNum, 0, direction);
			int wordStartsAt = rowAsString.indexOf(word);

			if (wordStartsAt >= 0) {
				return findCoordinates(rowNum, wordStartsAt, word.length(), direction);
			}

			//Test if it is reversed.
			String reverseWord = reverse(word);
			wordStartsAt = String.valueOf(rows[rowNum]).indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int end = wordStartsAt + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum, end - i};
				}
				return returnValue;
			}
		}
		
		return null;
	}

	private int[][] findCoordinates(int startX, int startY, int wordLength, SearchDirection direction) {
		int[][] returnValue = new int[wordLength][2];
		for (int i = 0; i < wordLength; i++) {
			returnValue[i] = new int[] {startX, startY};
			startX += direction.scopeX;
			startY += direction.scopeY;
		}
		return returnValue;
	}
	
	private String buildDirectionalStringFromRows(int startX, int startY, SearchDirection direction) {
		
		String stringFromRow = "";
		int scopeX = direction.scopeX;
		int scopeY = direction.scopeY;
		int max = rows.length;

		for (int i = 0; i < max && startX < max && startY < max && startX >= 0 && startY >= 0; i++) {
			stringFromRow += rows[startX][startY];
			startX += scopeX;
			startY += scopeY;
		}
		
		return stringFromRow;
	}

	private int[][] findVertical() {
		for (int col = 0; col < rows.length; col++) {
			SearchDirection direction = SearchDirection.VERTICAL;
			String columnValue = buildDirectionalStringFromRows(0, col, direction);
			int wordStartsAt = columnValue.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(wordStartsAt, col, word.length(), direction);
			}
			
			//Try in the reverse
			String reverseWord = reverse(word);
			wordStartsAt = columnValue.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int end = wordStartsAt + reverseWord.length() - 1;
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

	private int[][] findDiagonallyDescending() {
		//Search for Diagonals starting in first column.
		SearchDirection direction = SearchDirection.DIAGONALLY_DESCENDING;
		for (int rowNum = 0; rowNum < rows.length; rowNum++) {
			String diagonal = buildDirectionalStringFromRows(rowNum, 0, direction);
			int wordStartsAt = diagonal.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(rowNum + wordStartsAt, wordStartsAt, word.length(), direction);
			}
			
			//Check if it is reversed.
			String reverseWord = reverse(word);
			wordStartsAt = diagonal.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int end = wordStartsAt + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum + end - i, end - i};
				}
				return returnValue;
			}
		}
		
		//Search the diagonals that start on the top.
		for (int colNum = 1; colNum < rows.length; colNum++) {
			String diagonal = buildDirectionalStringFromRows(0, colNum, direction);
			int wordStartsAt = diagonal.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(colNum - 1 + wordStartsAt, wordStartsAt + 1, word.length(), direction);
			}
			
			//Check if it is reversed.
			String reverseWord = reverse(word);
			wordStartsAt = diagonal.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int end = wordStartsAt + reverseWord.length();
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {end - 1 - i, end - i};
				}
				return returnValue;
			}
		}
		
		return null;
	}
	
	private int[][] findDiagonallyAscending() {
		//Search for Diagonals starting in first column.
		SearchDirection direction = SearchDirection.DIAGONALLY_ASCENDING;
		for (int rowNum = 0; rowNum < rows.length; rowNum++) {
			String diagonal = buildDirectionalStringFromRows(rowNum, 0, direction);
			int wordStartsAt = diagonal.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(rowNum - wordStartsAt, wordStartsAt, word.length(), direction);
			}
			
			//Check for reverse.
			String reverseWord = reverse(word);
			wordStartsAt = diagonal.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int end = wordStartsAt + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rowNum - end + i, end - i};
				}
				return returnValue;
			}
		}
		
		//Search the diagonals that start on the bottom.
		for (int colNum = 1; colNum < rows.length; colNum++) {
			String diagonal = buildDirectionalStringFromRows(rows.length - 1, colNum, direction);
			int wordStartsAt = diagonal.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(rows.length + wordStartsAt, wordStartsAt + 1, word.length(), direction);
			}
			
			//Check for reverse.
			String reverseWord = reverse(word);
			wordStartsAt = diagonal.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int end = wordStartsAt + reverseWord.length() - 1;
				int[][] returnValue = new int[word.length()][2];
				for (int i = 0; i < word.length(); i++) {
					returnValue[i] = new int[] {rows.length - end + i, end + 1 - i};
				}
				return returnValue;
			}
		}
			
		return null;
	}

}
