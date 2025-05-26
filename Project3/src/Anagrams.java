//package com.gradescope.anagrams;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Anagrams {
	/*
	 * This class takes a command line with a word first, then a text file for the 
	 * word bank, then a value for the max number of words in one anagram list.
	 * The input word will be used to create a list of anagrams of smaller words 
	 * (contained within the word bank in the text file) so that all the letters of 
	 * the input word are used, but not more than once. 
	 * 
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
        
        String wordList = args[0];
        String word = args[1];
        int maxAnas = Integer.valueOf(args[2]);
        if (maxAnas == 0) maxAnas = -1;  // set to -1 for no limit

        System.out.println("Phrase to scramble: " + word);
        
        HashSet<String> validWords = getWordList(wordList);
        HashSet<String> solutions = new HashSet<String>();
        ArrayList<Character> allChars = getChars(word);
        
        getCombinations(allChars, "", validWords, solutions);
        ArrayList<String> orderedSolution = new ArrayList<String>(solutions);
        Collections.sort(orderedSolution);
        
        System.out.println("\nAll words found in " + word + ":");
        System.out.println(orderedSolution);
        
        ArrayList<String> result = new ArrayList<String>();
        System.out.println("\nAnagrams for " + word + ":");
        ArrayList<ArrayList<String>> allResults = new ArrayList<ArrayList<String>>();
        getAnagrams(word.length(), orderedSolution, word, result, maxAnas, 0, allResults);
        for (int i = 0; i < allResults.size(); i++) System.out.println(allResults.get(i));


    }

	public static ArrayList<Character> getChars(String word) {
		// This method takes a String and returns an ArrayList of the characters in the word in the same order
		ArrayList<Character> chars = new ArrayList<>();
		
		// iterate through each item in the character array of the input word
		for (char c : word.toCharArray()) {
			chars.add(c);
		}
		return chars;
	}
	
	public static HashSet<String> getWordList(String wordFile) throws FileNotFoundException {
		// This method takes the input text file with one word on each line and returns a 
		// HashSet of all the words in the file
		HashSet<String> wordList = new HashSet<String>();
		File myFile = new File(wordFile);
		Scanner fileReader = new Scanner(myFile);
		
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			//add line to hashset
			wordList.add(line);
		}
		
		
		fileReader.close();
		return wordList;
	}
	
	public static void getCombinations(ArrayList<Character> allChars, 
			String currWord, HashSet<String> validWords,
			HashSet<String> solutions) {
		// Recursive
		// Creates all combinations of letters by adding each character in a for loop.
		// Only adds the combination of letters if it matches a word in validWords
		if (validWords.contains(currWord)) {
			solutions.add(currWord);
		}
		for(int i = 0; i < allChars.size(); i++) {;
			
			ArrayList<Character> remainingChars = new ArrayList<>(allChars);
			
			remainingChars.remove(i);
			
			// recursive call to getCombinations with the currWord modified to add the next char
			getCombinations(remainingChars, currWord + allChars.get(i), validWords, solutions);
								
		}
	}
	

	public static void getAnagrams(int length, ArrayList<String> orderedSolution, String word,
			ArrayList<String> result, int maxAnas, int i, ArrayList<ArrayList<String>> allResults) {
		// This method creates the Array of Arrays of all the anagrams of the same length as the original word
		
		// checks to see if the currentLength of the result ArrayList matches the length of the word
		// if it does, then it adds that solution ArrayList to allResults
		int currLength = 0;
		for (String item : result) {
			currLength += item.length();
		}
		
		if (currLength == length) {
			if(!allResults.contains(result)) {
				allResults.add(new ArrayList<>(result));
			}
			return;
		}
		// if currLength is greater than the length of the original word, the branch is a dead end
		if (currLength > length) {
			return;
		}
		
		// loop to iterate through all words in the possible word list to see if it's possible 
		// to add the word to the single anagram's array
		
		for( int j = 0; j < orderedSolution.size(); j++	) {
			String nextWord = orderedSolution.get(j);
			
			if (containsLetters(word, result, nextWord)) {
				result.add(nextWord);
				
				// recursive call to find next word
				getAnagrams(length, orderedSolution, word, result, maxAnas, j, allResults);
				
				// remove current word
				result.remove(result.size()-1);
			}
			
			// if maxAnas limit is reached, stop
			if (maxAnas != -1 && allResults.size() >= maxAnas) {
				return;
			}
			
		}
	
		
		
	}
	
	public static boolean containsLetters(String originalWord, ArrayList<String> currWords, String nextWord)	{
		// this method recursively checks if the new word being check can be made using the 
		// remaining letters in the original word that are not
		// being used in the already added words of the anagram
		ArrayList<Character> resultChars = new ArrayList<Character> ();
		
		ArrayList<Character> originalChars = getChars(originalWord);
		ArrayList<Character> nextWordChars = getChars(nextWord);
		
		// add the characters of the current words to resultChars
		for (String word : currWords) {
			
			ArrayList<Character> currLetters = getChars(word);
			
			for (char c : currLetters) {
				resultChars.add(c);
				
			}
		}
		
		// if a letter is in the original word but not in the resultChars, 
		// add it to the remaining chars list
		
		for (char c : resultChars) {
			originalChars.remove((Character) c);
		}
		for (char c : nextWordChars) {
			if (!originalChars.remove((Character) c)) {
				return false; // if nextWord has a character that can't be removed, return false
			}
		}
		
		return true;
	}
	
}

