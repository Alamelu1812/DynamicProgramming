/*
 * Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative 
 * order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of 
 * length n has 2^n different possible subsequences.
 * 
 */

public class LongestCommonSubsequence {
	public int computeSubsequenceLength(String s1,String s2) {
		int length1 = s1.length(), length2 = s2.length();
		int[][] matrix = new int[length1+1][length2+1];
		
		for(int i=0;i<=length1;i++) {
			for(int j=0;j<=length2;j++) {
				
				//If either string length is 0, there is no common sequence
				if(i == 0) {
					matrix[i][j] = 0;
					continue;
				}
				if(j == 0) {
					matrix[i][j] = 0;
					continue;
				}
				
				//If characters match, then 1 is added 
				if(s1.charAt(i-1) == s2.charAt(j-1)) 
					matrix[i][j] = 1 + matrix[i-1][j-1];
				
				//Else consider insertion or deletion of that character
				else 
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
			}
		}
		return matrix[length1][length2];
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence object = new LongestCommonSubsequence();
		
		String s1 = "ag", s2 = "abcdefg";
		System.out.println(object.computeSubsequenceLength(s1, s2));
	}
}
