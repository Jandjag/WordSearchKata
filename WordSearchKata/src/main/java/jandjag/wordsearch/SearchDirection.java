package jandjag.wordsearch;

public enum SearchDirection {

	HORIZONTAL(0, 1),
	VERTICAL(1, 0),
	DIAGONALLY_DESCENDING(1, 1),
	DIAGONALLY_ASCENDING(-1, 1);
	
	int scopeX = 0;
	int scopeY = 0;
		
	private SearchDirection(int scopeX, int scopeY) {
		this.scopeX = scopeX;
		this.scopeY = scopeY;
	}
 }
