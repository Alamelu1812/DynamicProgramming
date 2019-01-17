
public class LongestPalindromicSubsequence {
	
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		char[] charArray = s.toCharArray();
		int[][] matrix = new int[n][n];
		
		//All single little characters are palindromes
		for(int i=0;i<n;i++) {
			matrix[i][i] = 1;
		}
		
		//If characters at 2 positions are equal at the extreme ends, increment seq length by 2 and consider 
		//the string after removing end characters
		//
		//If characters are not equal, consider the max subsequence obtained by removing first character 
		//or last character
		
		for(int length=2;length<=n;length++) {
			for(int start=0;start<n-length+1;start++) {
				int end = start+length-1;
				if(charArray[start] == charArray[end] && end==start+1) {
					matrix[start][end] = 2;
				}
				else if(charArray[start] == charArray[end]) {
					matrix[start][end] = matrix[start+1][end-1] + 2;
				}
				else if(charArray[start] != charArray[end])
					matrix[start][end] = Math.max(matrix[start+1][end],matrix[start][end-1]);
			}
		}
		
		return matrix[0][n-1];   
    }
	
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence object = new LongestPalindromicSubsequence();
		
		//TestCase
		String s = "bbbab";
		System.out.println(object.longestPalindromeSubseq(s));
	}

}
