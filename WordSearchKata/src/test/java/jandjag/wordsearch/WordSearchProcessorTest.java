package jandjag.wordsearch;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordSearchProcessorTest {
	
	@Test
	public void processWordSearch_StarTrekExample() {
		assertEquals(getStarTrekOutput(), WordSearchProcessor.processWordSearch(buildStarTrekContents()));
	}
	
	@Test
	public void processWordSearch_QuiltingExample() {
		assertEquals(getQuiltingOutput(), WordSearchProcessor.processWordSearch(buildQuiltingContents()));
	}

	@Test
	public void processWordSearch_QuiltingExample2() {
		assertEquals(getQuiltingOutput2(), WordSearchProcessor.processWordSearch(buildQuiltingContents2()));
	}
	
	private List<String> buildQuiltingContents() {
		List<String> fileContents = new ArrayList<String>();
		
		fileContents.add("BATIK,BINDING,CUTTING,FABRIC,PATTERN,PIECING,QUILTING");
		fileContents.add("N,D,L,P,G,U,F,G,G,O,Y,Q,G,P,V");
		fileContents.add("N,P,G,D,T,N,N,F,I,E,D,F,P,F,U");
		fileContents.add("W,S,U,S,N,I,I,P,A,P,X,G,Z,G,B");
		fileContents.add("W,Z,Q,O,T,L,K,D,G,B,G,M,T,S,C");
		fileContents.add("G,N,I,T,L,I,U,Q,N,B,R,B,S,F,I");
		fileContents.add("L,J,U,N,A,T,P,Q,I,I,Q,I,M,U,A");
		fileContents.add("X,C,O,D,Q,L,G,M,C,L,B,N,C,R,J");
		fileContents.add("M,J,H,G,B,M,T,X,E,D,E,Z,L,D,R");
		fileContents.add("L,E,S,D,X,U,E,Y,I,Z,C,V,P,M,O");
		fileContents.add("R,J,O,O,J,N,J,J,P,M,V,X,X,W,Y");
		fileContents.add("P,A,T,T,E,R,N,B,Z,K,J,P,S,L,X");
		fileContents.add("M,Y,E,L,U,G,W,A,T,V,U,U,U,V,V");
		fileContents.add("Y,V,E,E,Q,T,W,T,E,T,G,Y,P,T,R");
		fileContents.add("O,C,L,C,A,U,L,I,H,G,Y,O,H,K,H");
		fileContents.add("Q,E,R,B,P,U,Q,K,V,O,H,K,F,N,F");
		
		return fileContents;
	}
	
	private String getQuiltingOutput() {
		return "BATIK: (7,10),(7,11),(7,12),(7,13),(7,14)\n" + 
				"BINDING: (10,6),(9,5),(8,4),(7,3),(6,2),(5,1),(4,0)\n" + 
				"CUTTING: (1,6),(2,5),(3,4),(4,3),(5,2),(6,1),(7,0)\n" + 
				"FABRIC: (7,1),(8,2),(9,3),(10,4),(11,5),(12,6)\n" + 
				"PATTERN: (0,10),(1,10),(2,10),(3,10),(4,10),(5,10),(6,10)\n" + 
				"PIECING: (8,9),(8,8),(8,7),(8,6),(8,5),(8,4),(8,3)\n" + 
				"QUILTING: (7,4),(6,4),(5,4),(4,4),(3,4),(2,4),(1,4),(0,4)\n";
	}

	private List<String> buildQuiltingContents2() {
		List<String> fileContents = new ArrayList<String>();
		
		fileContents.add("BATIK,BINDING,CUTTING,FABRIC,PATTERN,PIECING,QUILTING");
		fileContents.add("B,S,L,N,D,S,D,Q,V,O");
		fileContents.add("G,V,V,R,C,C,U,O,D,G");
		fileContents.add("G,N,I,D,N,I,B,J,W,D");
		fileContents.add("R,F,I,V,L,D,J,B,B,X");
		fileContents.add("D,P,A,T,T,E,R,N,B,T");
		fileContents.add("Z,H,I,B,T,W,I,K,A,Y");
		fileContents.add("J,N,T,Q,R,U,C,T,T,G");
		fileContents.add("G,G,X,G,N,I,C,E,I,P");
		fileContents.add("L,G,M,Y,I,L,C,H,K,G");
		fileContents.add("L,M,I,B,P,L,N,M,L,X");
		
		return fileContents;
	}

	private String getQuiltingOutput2() {
		return "BATIK: (8,4),(8,5),(8,6),(8,7),(8,8)\n" + 
				"BINDING: (6,2),(5,2),(4,2),(3,2),(2,2),(1,2),(0,2)\n" + 
				"CUTTING: (6,7),(5,6),(4,5),(3,4),(2,3),(1,2),(0,1)\n" + 
				"FABRIC: (1,3),(2,4),(3,5),(4,6),(5,7),(6,8)\n" + 
				"PATTERN: (1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(7,4)\n" + 
				"PIECING: (9,7),(8,7),(7,7),(6,7),(5,7),(4,7),(3,7)\n" + 
				"QUILTING: (7,0),(6,1),(5,2),(4,3),(3,4),(2,5),(1,6),(0,7)\n";
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
