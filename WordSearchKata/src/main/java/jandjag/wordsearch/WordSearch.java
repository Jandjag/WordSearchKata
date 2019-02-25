package jandjag.wordsearch;

public class WordSearch {

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

	int findHorizontalRow(char[][] rows, String word) {
		for (int i = 0; i < rows.length; i++) {
			if (findHorizontalColumns(rows[i], word) != null) {
				return i;
			}
		}
		return 0;
	}

}
