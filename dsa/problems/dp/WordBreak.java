package dsa.problems.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, String[] dictionary) {


        Set<String> set = new HashSet<>();
    int maxLength =0;
        for(String word :dictionary){
            set.add(word);
            maxLength= Math.max(maxLength,word.length());
        }
        int n = s.length();

        boolean dp[] = new boolean[n+1];
        dp[0] = true; // empty string always true

        for(int i =1;i<=n;i++){
            for(int j = i-1; j>= Math.max(0, i-maxLength);j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]= true;
                    break;

                }
            }
        }
        return dp[n];


    }
    public static void main(String[] args) {
        String s = "ilike";
        String dictionary[] = {"i", "like", "gfg"};
        System.out.println(wordBreak(s,dictionary));
    }
}
