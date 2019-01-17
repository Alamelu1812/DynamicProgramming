
public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        boolean[][] matrix = new boolean[n][n];
        
        //All single little characters are palindromes
        for(int i=0;i<n;i++){
            matrix[i][i] = true;
        }
        
        int palindromeStart = 0;
        int maxLength = 1;
        
        //Consider all possible two character substrings
        for(int i=0;i<n-1;i++){
            if(charArray[i] == charArray[i+1]) {
                matrix[i][i+1] = true;
                if(maxLength < 2) {
                	palindromeStart = i;
                	maxLength = 2;
                }
            }
            else
                matrix[i][i+1] = false;
        }
        
        
        
        //All substrings of length 3 or greater are considered
        for(int length=3;length<=n;length++){
            for(int start = 0;start<n-length+1;start++){
                int end = start+length -1;
                if(matrix[start+1][end-1]==true && charArray[start] == charArray[end]) {
                    matrix[start][end] = true;
                    if(maxLength < length) {
                    	palindromeStart = start;
                    	maxLength = length;
                    }
                }
                else
                    matrix[start][end] = false;
            }
        }
        return s.substring(palindromeStart, palindromeStart+maxLength);
    }
	
	public static void main(String[] args) {
		LongestPalindromicSubstring object = new LongestPalindromicSubstring();
		
		//TestCase
		String s = "aaa";
		System.out.println(object.longestPalindrome(s));
	}


}
