/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated 
 * sequence of one or more dictionary words.
 * 
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 */

import java.util.*;
public class WordBreak {
	
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
		boolean[] dpArray = new boolean[s.length()+1];
		
		//Null Strung is always part of the word dictionary
		dpArray[0] = true;
		
		//For every substring possible, consider multiple ways os splitting, consider whether the dp value
		//pertaining to first half of split is true and that second half of split is present in dictionary
		for(int substringLength = 1;substringLength<=s.length();substringLength++) {
			for(int splitAt = 0;splitAt<substringLength;splitAt++) {
				if(dpArray[splitAt] && wordDict.contains(s.substring(splitAt, substringLength))) {
					dpArray[substringLength] = true;
					break;
				}
			}
		}
		
		return dpArray[s.length()];
    }
    
    public static void main(String[] args) {
		WordBreak object = new WordBreak();
		List<String> wordDict = new ArrayList<String>();
		
		//TestCase
		wordDict.add("apple");
		wordDict.add("pen");
		System.out.println(object.wordBreak("applepenapple", wordDict));
	}

}
