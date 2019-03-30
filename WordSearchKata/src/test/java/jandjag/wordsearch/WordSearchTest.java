package jandjag.wordsearch;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {
	
	final static String HORIZONTAL_WORD = "helloworld";
	final static String VERTICAL_WORD = "howdy";
	final static String DIAGONALLY_DESCENDING_WORD = "heythere";
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
		assertArrayEquals(new int[][] {{2,1}, {3,1}, {4,1}, {5,1}, {6,1}}, search.findVertical(VERTICAL_WORD));
	}

	@Test 
	public void shouldReturnnull_WhenVerticalWordNotFound() {
		search.setRows(buildRowsWithVerticalWord());
		assertNull(search.findVertical("zyx"));
	}
	
	/*
	 * Tests around Diagonally Descending Searches
	 */
	@Test
	public void shouldFindForwardDiagonalWord_WhenExistsInLetters() {
		search.setRows(buildRowsWithDiagonallyDescendingWord());
		assertArrayEquals(new int[][] {{1,1}, {2,2}, {3,3}, {4,4}, {5,5}, {6,6}, {7,7}, {8,8}}, search.findDiagonallyDescending(DIAGONALLY_DESCENDING_WORD));
	}

	@Test
	public void shouldReturnNull_WhenDiagonallyDescendingWordNotFound() {
		search.setRows(buildRowsWithDiagonallyDescendingWord());
		assertNull(search.findDiagonallyDescending("zyx"));
	}
	
	
	/*
	 * Helper methods for tests
	 */
	
	private char[][] buildRowsWithDiagonallyDescendingWord() {
		char[][] rows = new char[10][];
		rows[0] = "aaaaaaaaaa".toCharArray();
		rows[1] = ("a" + DIAGONALLY_DESCENDING_WORD.charAt(0) + "aaaaaaaa").toCharArray();
		rows[2] = ("aa" + DIAGONALLY_DESCENDING_WORD.charAt(1) + "aaaaaaa").toCharArray();
		rows[3] = ("aaa" + DIAGONALLY_DESCENDING_WORD.charAt(2) + "aaaaaa").toCharArray();
		rows[4] = ("aaaa" + DIAGONALLY_DESCENDING_WORD.charAt(3) + "aaaaa").toCharArray();
		rows[5] = ("aaaaa" + DIAGONALLY_DESCENDING_WORD.charAt(4) + "aaaa").toCharArray();
		rows[6] = ("aaaaaa" + DIAGONALLY_DESCENDING_WORD.charAt(5) + "aaa").toCharArray();
		rows[7] = ("aaaaaaa" + DIAGONALLY_DESCENDING_WORD.charAt(6) + "aa").toCharArray();
		rows[8] = ("aaaaaaaa" + DIAGONALLY_DESCENDING_WORD.charAt(7) + "a").toCharArray();
		rows[9] = "aaaaaaaaaa".toCharArray();
		return rows;
	}
	
	private char[][] buildRowsWithVerticalWord() {
		char[][] rows = new char[10][];
		rows[0] = "aaaaaaaaaa".toCharArray();
		rows[1] = "aaaaaaaaaa".toCharArray();
		rows[2] = ("a" + VERTICAL_WORD.charAt(0) + "aaaaaaaa").toCharArray();
		rows[3] = ("a" + VERTICAL_WORD.charAt(1) + "aaaaaaaa").toCharArray();
		rows[4] = ("a" + VERTICAL_WORD.charAt(2) + "aaaaaaaa").toCharArray();
		rows[5] = ("a" + VERTICAL_WORD.charAt(3) + "aaaaaaaa").toCharArray();
		rows[6] = ("a" + VERTICAL_WORD.charAt(4) + "aaaaaaaa").toCharArray();
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
