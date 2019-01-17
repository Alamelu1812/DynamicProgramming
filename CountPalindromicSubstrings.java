
public class CountPalindromicSubstrings {
	public int countSubstrings(String s) {
        int n = s.length();
        int palindromicSubstringsCount = 0;
        char[] charArray = s.toCharArray();
        boolean[][] matrix = new boolean[n][n];
        
        //All single little characters are palindromes
        for(int i=0;i<n;i++){
            matrix[i][i] = true;
        }
        
        //Consider all possible two character substrings
        for(int i=0;i<n-1;i++){
            if(charArray[i] == charArray[i+1])
                matrix[i][i+1] = true;
            else
                matrix[i][i+1] = false;
        }
        
        
        //All substrings of length 3 or greater are considered
        for(int length=3;length<=n;length++){
            for(int start = 0;start<n-length+1;start++){
                int end = start+length -1;
                if(matrix[start+1][end-1]==true && charArray[start] == charArray[end])
                    matrix[start][end] = true;
                else
                    matrix[start][end] = false;
            }
        }
        
        //Count of true gives the number of palindromic substring
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == true)
                    palindromicSubstringsCount++;
            }
        }
        return palindromicSubstringsCount;
    }
	
	public static void main(String[] args) {
		CountPalindromicSubstrings object = new CountPalindromicSubstrings();
		
		//TestCase
		String s = "aaa";
		System.out.println(object.countSubstrings(s));
	}

}
