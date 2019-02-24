package jandjag.wordsearch;

public class WordSearch {

	int[] findHorizontal(String lineValue, String word) {
		int[] returnValue = new int[word.length()];
		 int begin = lineValue.indexOf(word);
		 for (int i = 0; i < word.length(); i++) {
			 returnValue[i] = begin + i;
		 }
		 return returnValue;
	}

}
