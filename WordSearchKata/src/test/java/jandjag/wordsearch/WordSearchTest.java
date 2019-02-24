package jandjag.wordsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {

	/*
	 * Tests around Horizontal Search
	 */
	@Test
	public void shouldFindWordInHorizontalLine() {
		WordSearch search = new WordSearch();
		String word = "helloworld";
		String lineValue = "abc" + word + "defgh";
		int[] result = search.findHorizontal(lineValue, word);
		assertArrayEquals(new int[] {3,4,5,6,7,8,9,10,11,12}, result);
	}
	
}
