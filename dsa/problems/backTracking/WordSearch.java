package dsa.problems.backTracking;

public class WordSearch {
    class Solution {

        public static boolean dfs(char[][] mat, String word, int i , int j , int k){
            if(k == word.length()){
                return true;
            }
            if(i< 0 || j < 0 || i >= mat.length || j >= mat[0].length ||
                    word.charAt(k)!=mat[i][j]){
                return false;
            }

            char temp = mat[i][j];
            mat[i][j]='#';

            boolean found = dfs(mat, word, i+1, j,k+1) ||
                    dfs(mat, word, i-1, j,k+1) ||
                    dfs(mat, word, i, j+1,k+1) ||
                    dfs(mat, word, i, j-1,k+1);

            mat[i][j] = temp;
            return found;
        }
        static public boolean isWordExist(char[][] mat, String word) {
            // Code here
            int n  = mat.length;
            int m = mat[0].length;

            for(int i =0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(mat[i][j] == word.charAt(0) && dfs(mat,word,i,j,0)){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
