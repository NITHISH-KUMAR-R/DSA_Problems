package dsa.problems.stringimp;

import java.util.ArrayList;

public class KmpAlgorithm {
        public int[] lps(String p){
            int i =1;
            int j =0;
            int dp[] = new int[p.length()];

            while(i<p.length()){
                if(p.charAt(i)==p.charAt(j)){

                    dp[i] = j+1;
                    i++;
                    j++;
                }else{
                    if(j!=0){
                        j= dp[j-1];
                    }else{
                        i++;
                    }
                }
            }
            return dp;
        }
        ArrayList<Integer> search(String pat, String txt) {
            // code here
            int dp[] = lps(pat);
            int i =0;
            int j =0;
            ArrayList<Integer> list =  new ArrayList<>();
            while(i<txt.length()){
                if(txt.charAt(i)==pat.charAt(j)){
                    i++;
                    j++;

                    if(j==pat.length()){
                        list.add(i-j);
                        j = dp[j-1];
                    }
                }else{
                    if(j!=0){
                        j= dp[j-1];
                    }else{
                        i++;
                    }
                }
            }
            return list;
            //The LPS array tells us how much we can shift the pattern
            //when a mismatch happens, without re-checking characters we already know match.
        }
    }

