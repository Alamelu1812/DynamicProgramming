
public class EditDistance {
	
	public int minDistanceRecursive(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        
        //If either string is empty, the length taken to convert one to another is the length of non-empty string
        if(length1 == 0)
        	return length2;
        if(length2 == 0)
        	return length1;
        
        //If last character is equal recurse only for strings with last character removed
        if(word1.charAt(length1-1) == word2.charAt(length2-1))
        	return minDistanceRecursive(word1.substring(0, length1-1),word2.substring(0, length2-1));
        
        //Else find the minimum of insert, replace, delete and add 1 to it
        return 1 + Math.min(minDistanceRecursive(word1.substring(0, length1-1),word2.substring(0, length2-1)),
        		Math.min(minDistanceRecursive(word1.substring(0, length1),word2.substring(0, length2-1)), 
        				minDistanceRecursive(word1.substring(0, length1-1),word2.substring(0, length2))));
    }
	
	//The version is case sensitive
	public int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        int[][] matrix = new int[length1+1][length2+1];
        for(int i=0;i<=length1;i++){
            for(int j=0;j<=length2;j++){
            	
            	//If one string is empty, the number of steps to convert an empty string to string of size i is i
                if(i == 0){
                    matrix[i][j] = j;
                    continue;
                }
                
              //If one string is empty, the number of steps to convert an empty string to string of size j is j
                if(j == 0){
                    matrix[i][j] = i;
                    continue;
                }
                
                //If the last characters match, just consider the edit distance after removing last character from both the strings
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1];
                //If last character don't match, consider the minimum of Insert, Delete and Replace and add one to it
                else{
                    matrix[i][j] = Math.min(matrix[i][j-1],Math.min(matrix[i-1][j-1],matrix[i-1][j])) + 1;
                }
            }
        }
        
        return matrix[length1][length2];
    }
	
	public static void main(String[] args) {
		EditDistance object = new EditDistance();
		
		//TestCase
		String s1 = "Alamelu", s2 = "Alamu";
		System.out.println(object.minDistanceRecursive(s1, s2));
	}

}
