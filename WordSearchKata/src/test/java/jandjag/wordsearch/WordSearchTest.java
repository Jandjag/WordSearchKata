package jandjag.wordsearch;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

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
	public void shouldReturnNull_whenHorizontalWordNotFound() {
		
		search.setRows(buildRowsWithHorizontalWord());
		assertNull(search.findHorizontal("zyx"));
	}
	
	@Test
	public void shouldFindHorizontalWord_WhenExistsInRows() {
		
		search.setRows(buildRowsWithHorizontalWord());
		assertArrayEquals(new int[][] {{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,10},{1,11},{1,12}}, search.findHorizontal(HORIZONTAL_WORD));
	}
	
	/*
	 * Tests around Vertical Searches
	 */
	
	@Test 
	public void shouldFindVerticalWord_WhenExistsInColumn() {
		search.setRows(buildRowsWithVerticalWord());
		assertArrayEquals(new int[][] {{2,1}, {3,1}, {4,1}, {5,1}, {6,1}}, search.findVertical("howdy"));
	}

	@Test 
	public void shouldReturnnull_WhenVerticalWordNotFound() {
		search.setRows(buildRowsWithVerticalWord());
		assertNull(search.findVertical("zyx"));
	}
	
	/*
	 * Helper methods for tests
	 */
	
	private char[][] buildRowsWithVerticalWord() {
		char[][] rows = new char[10][];
		rows[0] = "aaaaaaaaaa".toCharArray();
		rows[1] = "aaaaaaaaaa".toCharArray();
		rows[2] = "ahaaaaaaaa".toCharArray();
		rows[3] = "aoaaaaaaaa".toCharArray();
		rows[4] = "awaaaaaaaa".toCharArray();
		rows[5] = "adaaaaaaaa".toCharArray();
		rows[6] = "ayaaaaaaaa".toCharArray();
		rows[7] = "aaaaaaaaaa".toCharArray();
		rows[8] = "aaaaaaaaaa".toCharArray();
		rows[9] = "aaaaaaaaaa".toCharArray();
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
