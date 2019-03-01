package jandjag.wordsearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {
	
	final static String HORIZONTAL_WORD = "helloworld";
	final static char[] LINE_WITH_WORD = ("abc" + HORIZONTAL_WORD + "defgh").toCharArray();
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
		
		int[] result = search.findHorizontalColumns(LINE_WITH_WORD, HORIZONTAL_WORD);
		assertArrayEquals(new int[] {3,4,5,6,7,8,9,10,11,12}, result);
	}
	
	@Test
	public void shouldReturnNull_whenWordNotInRow() {
		
		assertNull(search.findHorizontalColumns(LINE_WITHOUT_WORD, "zyx"));
	}
	
	@Test
	public void shouldFindRowInHorizontal_MultipleLines() {
		
		search.setRows(buildRowsWithHorizontalWord());
		assertArrayEquals(new int[][] {{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,10},{1,11},{1,12}}, search.findHorizontal(HORIZONTAL_WORD));
	}
	
	/*
	 * Tests around Directional Searches
	 */
	
	@Test 
	public void shouldFindVerticalWord_WhenThereIsOneColumn() {
		search.setRows(buildRowsWithVerticalWord());
		assertArrayEquals(new int[][] {{2,0}, {3,0}, {4,0}, {5,0}, {6,0}}, search.findVertialRows("howdy"));
		
	}
	
	
	/*
	 * Helper methods for tests
	 */
	
	private char[][] buildRowsWithVerticalWord() {
		char[][] rows = new char[10][];
		rows[0] = new char[] {'a'};
		rows[1] = new char[] {'a'};
		rows[2] = new char[] {'h'};
		rows[3] = new char[] {'o'};
		rows[4] = new char[] {'w'};
		rows[5] = new char[] {'d'};
		rows[6] = new char[] {'y'};
		rows[7] = new char[] {'a'};
		rows[8] = new char[] {'a'};
		rows[9] = new char[] {'a'};
		return rows;
	}
	private char[][] buildRowsWithHorizontalWord() {
		
		char[][] rows = new char[3][];
		rows[0] = LINE_WITHOUT_WORD;
		rows[1] = LINE_WITH_WORD;
		rows[2] = LINE_WITHOUT_WORD;
		return rows;
	}
	
}
