package jandjag.wordsearch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordSearchProcessorTest {
	
	@Test
	public void processWordSearch_StarTrekExample() {
		List<String> fileContents = buildStarTrekContents();
		assertEquals(getStarTrekOutput(), WordSearchProcessor.processWordSearch(fileContents));
	}

	private List<String> buildStarTrekContents() {
		List<String> fileContents = new ArrayList<String>();
		
		fileContents.add("BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA");
		fileContents.add("U,M,K,H,U,L,K,I,N,V,J,O,C,W,E");
		fileContents.add("L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G");
		fileContents.add("H,S,U,P,J,P,R,J,D,H,S,B,X,T,G");
		fileContents.add("B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E");
		fileContents.add("A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D");
		fileContents.add("S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F");
		fileContents.add("B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z");
		fileContents.add("O,K,R,I,K,A,M,M,R,M,F,B,A,P,P");
		fileContents.add("N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S");
		fileContents.add("E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K");
		fileContents.add("S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D");
		fileContents.add("T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K");
		fileContents.add("O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H");
		fileContents.add("W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S");
		fileContents.add("K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B");
		
		return fileContents;
	}
	
	private String getStarTrekOutput() {
		return "BONES: (0,6),(0,7),(0,8),(0,9),(0,10)\n" + 
				"KHAN: (5,9),(5,8),(5,7),(5,6)\n" + 
				"KIRK: (4,7),(3,7),(2,7),(1,7)\n" + 
				"SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)\n" + 
				"SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)\n" + 
				"SULU: (3,3),(2,2),(1,1),(0,0)\n" + 
				"UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)\n";
	}

}
