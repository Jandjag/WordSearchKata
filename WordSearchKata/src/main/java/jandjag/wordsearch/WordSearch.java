package jandjag.wordsearch;

public class WordSearch {

	private char[][] letters = null;
	private String word = null;
	
	public void setLetters(char[][] letters) {
		this.letters = letters;
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
	
	private int[][] findCoordinates(int startX, int startY, int wordLength, SearchDirection direction) {
		int[][] returnValue = new int[wordLength][2];
		for (int i = 0; i < wordLength; i++) {
			returnValue[i] = new int[] {startX, startY};
			startX += direction.scopeX;
			startY += direction.scopeY;
		}
		return returnValue;
	}

	private int[][] findReverseCoordinates(int startX, int startY, int wordLength, SearchDirection direction) {
		int[][] returnValue = new int[wordLength][2];
		for (int i = 0; i < wordLength; i++) {
			returnValue[i] = new int[] {startX, startY};
			startX -= direction.scopeX;
			startY -= direction.scopeY;
		}
		return returnValue;
	}
	
	private String buildDirectionalStringFromRows(int startX, int startY, SearchDirection direction) {
		
		String stringFromRow = "";
		int scopeX = direction.scopeX;
		int scopeY = direction.scopeY;
		int max = letters.length;

		for (int i = 0; i < max && startX < max && startY < max && startX >= 0 && startY >= 0; i++) {
			stringFromRow += letters[startX][startY];
			startX += scopeX;
			startY += scopeY;
		}
		
		return stringFromRow;
	}

	private String reverse(String word) {
		return new StringBuilder(word).reverse().toString();
	}
	
	private int[][] findHorizontal() {
		SearchDirection direction = SearchDirection.HORIZONTAL;
		for (int rowNum = 0; rowNum < letters.length; rowNum++) {
			String rowAsString = buildDirectionalStringFromRows(rowNum, 0, direction);
			int wordStartsAt = rowAsString.indexOf(word);

			if (wordStartsAt >= 0) {
				return findCoordinates(rowNum, wordStartsAt, word.length(), direction);
			}

			//Test if it is reversed.
			String reverseWord = reverse(word);
			wordStartsAt = String.valueOf(letters[rowNum]).indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int wordEndsAt = wordStartsAt + reverseWord.length() - 1;
				return findReverseCoordinates(rowNum, wordEndsAt, word.length(), direction);
			}
		}
		
		return null;
	}

	private int[][] findVertical() {
		SearchDirection direction = SearchDirection.VERTICAL;
		for (int col = 0; col < letters.length; col++) {
			String columnValue = buildDirectionalStringFromRows(0, col, direction);
			int wordStartsAt = columnValue.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(wordStartsAt, col, word.length(), direction);
			}
			
			//Try in the reverse
			String reverseWord = reverse(word);
			wordStartsAt = columnValue.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int wordEndsAt = wordStartsAt + reverseWord.length() - 1;
				return findReverseCoordinates(wordEndsAt, col, word.length(), direction);
			}
		}
		return null;
	}

	private int[][] findDiagonallyDescending() {
		SearchDirection direction = SearchDirection.DIAGONALLY_DESCENDING;
		//Search for Diagonals starting in first column.
		for (int rowNum = 0; rowNum < letters.length; rowNum++) {
			String diagonal = buildDirectionalStringFromRows(rowNum, 0, direction);
			int wordStartsAt = diagonal.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(rowNum + wordStartsAt, wordStartsAt, word.length(), direction);
			}
			
			//Check if it is reversed.
			String reverseWord = reverse(word);
			wordStartsAt = diagonal.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int wordEndsAt = wordStartsAt + reverseWord.length() - 1;
				return findReverseCoordinates(rowNum + wordEndsAt, wordEndsAt, word.length(), direction);
			}
		}
		
		//Search the diagonals that start on the top.
		for (int colNum = 1; colNum < letters.length; colNum++) {
			String diagonal = buildDirectionalStringFromRows(0, colNum, direction);
			int wordStartsAt = diagonal.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(colNum - 1 + wordStartsAt, wordStartsAt + 1, word.length(), direction);
			}
			
			//Check if it is reversed.
			String reverseWord = reverse(word);
			wordStartsAt = diagonal.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int wordEndsAt = wordStartsAt + reverseWord.length();
				return findReverseCoordinates(wordEndsAt - 1, wordEndsAt, word.length(), direction);
			}
		}
		
		return null;
	}
	
	private int[][] findDiagonallyAscending() {
		SearchDirection direction = SearchDirection.DIAGONALLY_ASCENDING;
		//Search for Diagonals starting in first column.
		for (int rowNum = 0; rowNum < letters.length; rowNum++) {
			String diagonal = buildDirectionalStringFromRows(rowNum, 0, direction);
			int wordStartsAt = diagonal.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(rowNum - wordStartsAt, wordStartsAt, word.length(), direction);
			}
			
			//Check for reverse.
			String reverseWord = reverse(word);
			wordStartsAt = diagonal.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int wordEndsAt = wordStartsAt + reverseWord.length() - 1;
				return findReverseCoordinates(rowNum - wordEndsAt, wordEndsAt, word.length(), direction);
			}
		}
		
		//Search the diagonals that start on the bottom.
		for (int colNum = 1; colNum < letters.length; colNum++) {
			String diagonal = buildDirectionalStringFromRows(letters.length - 1, colNum, direction);
			int wordStartsAt = diagonal.indexOf(word);
			if (wordStartsAt >= 0) {
				return findCoordinates(letters.length + wordStartsAt, wordStartsAt + 1, word.length(), direction);
			}
			
			//Check for reverse.
			String reverseWord = reverse(word);
			wordStartsAt = diagonal.indexOf(reverseWord);
			if (wordStartsAt >= 0) {
				int wordEndsAt = wordStartsAt + reverseWord.length() - 1;
				return findReverseCoordinates(letters.length - wordEndsAt, wordEndsAt + 1, word.length(), direction);
			}
		}
			
		return null;
	}

}
