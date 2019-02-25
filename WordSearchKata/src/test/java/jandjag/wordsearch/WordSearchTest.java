package jandjag.wordsearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {
	
	final static String WORD = "helloworld";
	final static char[] LINE_WITH_WORD = ("abc" + WORD + "defgh").toCharArray();
	final static char[] LINE_WITHOUT_WORD = "abcdefghijklmnopqrs".toCharArray();
	WordSearch search = null;

	@Before
	public void setup() {
		search = new WordSearch();
	}
	
	/*
	 * Tests around Horizontal Search
	 */
	@Test
	public void shouldFindColumnsInHorizontal_OneLine() {
		int[] result = search.findHorizontalColumns(LINE_WITH_WORD, WORD);
		assertArrayEquals(new int[] {3,4,5,6,7,8,9,10,11,12}, result);
	}
	
	@Test
	public void shouldReturnNull_whenWordNotInRow() {
		assertNull(search.findHorizontalColumns(LINE_WITHOUT_WORD, "zyx"));
	}
	
	@Test
	public void shouldFindRowInHorizontal_MultipleLines() {
		char[][] rows = new char[3][];
		rows[0] = LINE_WITHOUT_WORD;
		rows[1] = LINE_WITH_WORD;
		rows[2] = LINE_WITHOUT_WORD;
		assertEquals(1, search.findHorizontalRow(rows, WORD));
	}
	
}
