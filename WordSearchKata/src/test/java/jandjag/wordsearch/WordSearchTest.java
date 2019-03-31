package jandjag.wordsearch;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {
	
	final static String HORIZONTAL_WORD = "helloworld";
	final static String VERTICAL_WORD = "howdy";
	final static String DIAGONALLY_DESCENDING_WORD = "heythere";
	final static String DIAGONALLY_ASCENDING_WORD = "niceday";
	final static char[] LINE_WITH_WORD = ("abc" + HORIZONTAL_WORD + "def").toCharArray();
	final static char[] LINE_WITHOUT_WORD = "abcdefghijklmnopq".toCharArray();
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
		
		search.setLetters(buildRowsWithHorizontalWord(true));
		search.setWord("zyx");
		assertNull(search.find());
	}
	
	@Test
	public void shouldFindHorizontalWord_WhenExistsInRows() {
		
		search.setLetters(buildRowsWithHorizontalWord(true));
		search.setWord(HORIZONTAL_WORD);
		assertArrayEquals(new int[][] {{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,10},{1,11},{1,12}}, search.find());
	}
	
	@Test
	public void shouldFindHorizontalWord_WhenExistsAndIsInReverse() {
		
		search.setLetters(buildRowsWithHorizontalWord(false));
		search.setWord(HORIZONTAL_WORD);
		assertArrayEquals(new int[][] {{1,12},{1,11},{1,10},{1,9},{1,8},{1,7},{1,6},{1,5},{1,4},{1,3}}, search.find());
	}
	
	/*
	 * Tests around Vertical Searches
	 */
	
	@Test 
	public void shouldFindVerticalWord_WhenExistsInColumn() {
		search.setLetters(buildRowsWithVerticalWord(true));
		search.setWord(VERTICAL_WORD);
		assertArrayEquals(new int[][] {{2,1}, {3,1}, {4,1}, {5,1}, {6,1}}, search.find());
	}
	
	@Test 
	public void shouldFindVerticalWord_WhenExistsInColumnInReverse() {
		search.setLetters(buildRowsWithVerticalWord(false));
		search.setWord(VERTICAL_WORD);
		assertArrayEquals(new int[][] {{6,1}, {5,1}, {4,1}, {3,1}, {2,1}}, search.find());
	}

	@Test 
	public void shouldReturnnull_WhenVerticalWordNotFound() {
		search.setLetters(buildRowsWithVerticalWord(true));
		search.setWord("zyx");
		assertNull(search.find());
	}
	
	/*
	 * Tests around Diagonally Descending Searches
	 */
	@Test
	public void shouldFindDiagonalDescendingWord_WhenExistsInDiagonalStartingOnLeft() {
		search.setLetters(buildRowsWithDiagonallyDescendingWord(true, true));
		search.setWord(DIAGONALLY_DESCENDING_WORD);
		assertArrayEquals(new int[][] {{1,1}, {2,2}, {3,3}, {4,4}, {5,5}, {6,6}, {7,7}, {8,8}}, search.find());
	}

	@Test
	public void shouldFindDiagonalDescendingWord_WhenExistsInDiagonalStartingOnLeftAndInReverse() {
		search.setLetters(buildRowsWithDiagonallyDescendingWord(true, false));
		search.setWord(DIAGONALLY_DESCENDING_WORD);
		assertArrayEquals(new int[][] {{8,8}, {7,7}, {6,6}, {5,5}, {4,4}, {3,3}, {2,2}, {1,1}}, search.find());
	}

	@Test
	public void shouldFindDiagonalDescendingWord_WhenExistsInDiagonalStartingOnTop() {
		search.setLetters(buildRowsWithDiagonallyDescendingWord(false, true));
		search.setWord(DIAGONALLY_DESCENDING_WORD);
		assertArrayEquals(new int[][] {{0,1}, {1,2}, {2,3}, {3,4}, {4,5}, {5,6}, {6,7}, {7,8}}, search.find());
	}

	@Test
	public void shouldFindDiagonalDescendingWord_WhenExistsInDiagonalStartingOnTopAndInReverse() {
		search.setLetters(buildRowsWithDiagonallyDescendingWord(false, false));
		search.setWord(DIAGONALLY_DESCENDING_WORD);
		assertArrayEquals(new int[][] {{7,8}, {6,7}, {5,6}, {4,5}, {3,4}, {2,3}, {1,2}, {0,1}}, search.find());
	}

	@Test
	public void shouldReturnNull_WhenDiagonallyDescendingWordNotFound() {
		search.setLetters(buildRowsWithDiagonallyDescendingWord(true, true));
		search.setWord("zyx");
		assertNull(search.find());
	}
	
	/*
	 * Tests around Diagonally Descending Searches
	 */
	@Test
	public void shouldFindDiagonalAscendingWord_WhenExistsInDiagonalStartingOnLeft() {
		search.setLetters(buildRowsWithDiagonallyAscending(true, true));
		search.setWord(DIAGONALLY_ASCENDING_WORD);
		assertArrayEquals(new int[][] {{8,1}, {7,2}, {6,3}, {5,4}, {4,5}, {3,6}, {2,7}}, search.find());
	}

	@Test
	public void shouldFindDiagonalAscendingWord_WhenExistsInDiagonalStartingOnLeftAndInReverse() {
		search.setLetters(buildRowsWithDiagonallyAscending(true, false));
		search.setWord(DIAGONALLY_ASCENDING_WORD);
		assertArrayEquals(new int[][] {{2,7}, {3,6}, {4,5}, {5,4}, {6,3}, {7,2}, {8,1}}, search.find());
	}

	@Test
	public void shouldFindDiagonalAscendingWord_WhenExistsInDiagonalStartingOnBottom() {
		search.setLetters(buildRowsWithDiagonallyAscending(false, true));
		search.setWord(DIAGONALLY_ASCENDING_WORD);
		assertArrayEquals(new int[][] {{10,1}, {9,2}, {8,3}, {7,4}, {6,5}, {5,6}, {4,7}}, search.find());
	}

	@Test
	public void shouldFindDiagonalAscendingWord_WhenExistsInDiagonalStartingOnBottomAndInReverse() {
		search.setLetters(buildRowsWithDiagonallyAscending(false, false));
		search.setWord(DIAGONALLY_ASCENDING_WORD);
		assertArrayEquals(new int[][] {{4,7}, {5,6}, {6,5}, {7,4}, {8,3}, {9,2}, {10,1}}, search.find());
	}
	
	@Test
	public void shouldReturnNull_WhenDiagonallyAscendingWordNotFound() {
		search.setLetters(buildRowsWithDiagonallyAscending(true, true));
		search.setWord("zyx");
		assertNull(search.find());
	}
	
	
	/*
	 * Helper methods for tests
	 */
	
	private char[][] buildRowsWithDiagonallyAscending(boolean startSearchOnLeft, boolean isNormalDirection) {
		char[][] rows = new char[10][10];
		int startCount = startSearchOnLeft ? 0 : 1;
		rows[startSearchOnLeft ? 9 : 0] = "aaaaaaaaaa".toCharArray();
		rows[0 + startCount] = "aaaaaaaaaa".toCharArray();
		rows[1 + startCount] = "aaaaaaaaaa".toCharArray();
		rows[2 + startCount] = ("aaaaaaa" + DIAGONALLY_ASCENDING_WORD.charAt(isNormalDirection ? 6 : 0) + "aa").toCharArray();
		rows[3 + startCount] = ("aaaaaa" + DIAGONALLY_ASCENDING_WORD.charAt(isNormalDirection ? 5 : 1) + "aaa").toCharArray();
		rows[4 + startCount] = ("aaaaa" + DIAGONALLY_ASCENDING_WORD.charAt(isNormalDirection ? 4 : 2) + "aaaa").toCharArray();
		rows[5 + startCount] = ("aaaa" + DIAGONALLY_ASCENDING_WORD.charAt(3) + "aaaaa").toCharArray();
		rows[6 + startCount] = ("aaa" + DIAGONALLY_ASCENDING_WORD.charAt(isNormalDirection ? 2 : 4) + "aaaaaa").toCharArray();
		rows[7 + startCount] = ("aa" + DIAGONALLY_ASCENDING_WORD.charAt(isNormalDirection ? 1 : 5) + "aaaaaaa").toCharArray();
		rows[8 + startCount] = ("a" + DIAGONALLY_ASCENDING_WORD.charAt(isNormalDirection ? 0 : 6) + "aaaaaaaa").toCharArray();
		return rows;
	}

	private char[][] buildRowsWithDiagonallyDescendingWord(boolean startOnLeft, boolean isNormalDirection) {
		char[][] rows = new char[10][10];
		int startCount = startOnLeft ? 1 : 0;
		rows[startOnLeft ? 0 : 9] = "aaaaaaaaaa".toCharArray();
		rows[0 + startCount] = ("a" + DIAGONALLY_DESCENDING_WORD.charAt(isNormalDirection ? 0 : 7) + "aaaaaaaa").toCharArray();
		rows[1 + startCount] = ("aa" + DIAGONALLY_DESCENDING_WORD.charAt(isNormalDirection ? 1 : 6) + "aaaaaaa").toCharArray();
		rows[2 + startCount] = ("aaa" + DIAGONALLY_DESCENDING_WORD.charAt(isNormalDirection ? 2 : 5) + "aaaaaa").toCharArray();
		rows[3 + startCount] = ("aaaa" + DIAGONALLY_DESCENDING_WORD.charAt(isNormalDirection ? 3 : 4) + "aaaaa").toCharArray();
		rows[4 + startCount] = ("aaaaa" + DIAGONALLY_DESCENDING_WORD.charAt(isNormalDirection ? 4 : 3) + "aaaa").toCharArray();
		rows[5 + startCount] = ("aaaaaa" + DIAGONALLY_DESCENDING_WORD.charAt(isNormalDirection ? 5 : 2) + "aaa").toCharArray();
		rows[6 + startCount] = ("aaaaaaa" + DIAGONALLY_DESCENDING_WORD.charAt(isNormalDirection ? 6 : 1) + "aa").toCharArray();
		rows[7 + startCount] = ("aaaaaaaa" + DIAGONALLY_DESCENDING_WORD.charAt(isNormalDirection ? 7 : 0) + "a").toCharArray();
		rows[8 + startCount] = "aaaaaaaaaa".toCharArray();
		return rows;
	}
	
	private char[][] buildRowsWithVerticalWord(boolean isNormalDirection) {
		char[][] rows = new char[10][10];
		rows[0] = "aaaaaaaaaa".toCharArray();
		rows[1] = "aaaaaaaaaa".toCharArray();
		rows[2] = ("a" + VERTICAL_WORD.charAt(isNormalDirection ? 0 : 4) + "aaaaaaaa").toCharArray();
		rows[3] = ("a" + VERTICAL_WORD.charAt(isNormalDirection ? 1 : 3) + "aaaaaaaa").toCharArray();
		rows[4] = ("a" + VERTICAL_WORD.charAt(2) + "aaaaaaaa").toCharArray();
		rows[5] = ("a" + VERTICAL_WORD.charAt(isNormalDirection ? 3 : 1) + "aaaaaaaa").toCharArray();
		rows[6] = ("a" + VERTICAL_WORD.charAt(isNormalDirection ? 4 : 0) + "aaaaaaaa").toCharArray();
		rows[7] = "aaaaaaaaaa".toCharArray();
		rows[8] = "aaaaaaaaaa".toCharArray();
		rows[9] = "aaaaaaaaaa".toCharArray();
		return rows;
	}
	private char[][] buildRowsWithHorizontalWord(boolean isNormalDirection) {
		
		char[][] rows = new char[16][16];
		rows[0] = LINE_WITHOUT_WORD;
		rows[1] = isNormalDirection ? LINE_WITH_WORD : new StringBuilder(String.valueOf(LINE_WITH_WORD)).reverse().toString().toCharArray();
		rows[2] = LINE_WITHOUT_WORD;
		rows[3] = LINE_WITHOUT_WORD;
		rows[4] = LINE_WITHOUT_WORD;
		rows[5] = LINE_WITHOUT_WORD;
		rows[6] = LINE_WITHOUT_WORD;
		rows[7] = LINE_WITHOUT_WORD;
		rows[8] = LINE_WITHOUT_WORD;
		rows[9] = LINE_WITHOUT_WORD;
		rows[10] = LINE_WITHOUT_WORD;
		rows[11] = LINE_WITHOUT_WORD;
		rows[12] = LINE_WITHOUT_WORD;
		rows[13] = LINE_WITHOUT_WORD;
		rows[14] = LINE_WITHOUT_WORD;
		rows[15] = LINE_WITHOUT_WORD;
		return rows;
	}
	
}
