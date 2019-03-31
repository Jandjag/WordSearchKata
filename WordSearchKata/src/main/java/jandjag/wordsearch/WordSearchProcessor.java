package jandjag.wordsearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordSearchProcessor {
	
	public static void main(String[] args) {

		List<String> fileContents = readInFile(args);
		
		System.out.println(processWordSearch(fileContents));
		
	}

	private static List<String> readInFile(String[] args) {
		List<String> fileContents = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]));){
			String line; 
			while ((line  = br.readLine()) != null) {
				fileContents.add(line);
			}
		} catch (FileNotFoundException fne) {
			System.out.println("Your file was not found.  Please check the path.");
		} catch (IOException ioe) {
			System.out.println("Unable to read the contents of your file.  Please try a different file.");
		}
		return fileContents;
	}

	static String processWordSearch(List<String> fileContents) {
		List<String> words = new ArrayList<String>();
		int letterGridSize = fileContents.size() - 1;
		char[][] letters = new char[letterGridSize][letterGridSize];
		int count = 0;
		
		for (String line : fileContents) {
			
			String[] wordArray = line.split(",");
			
			if (count == 0) { //First line is the words
				for (String word : wordArray) {
					words.add(word);
				}
			} else { //line is comma separated chars.
				char[] letterArray = new char[letterGridSize];
				for (int i = 0; i < letterGridSize; i++) {
					letterArray[i] = wordArray[i].charAt(0);
				}
				letters[count - 1] = letterArray;
			}
			count++;
		}
		
		String wordsFound = "";
		for (String word : words) {
			WordSearch search = new WordSearch();
			search.setLetters(letters);
			search.setWord(word);
			wordsFound += search.find() + "\n";
		}
		
		return wordsFound;
	}

}
