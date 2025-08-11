package dsa.problems.stringimp.kmp;

import java.util.HashSet;
import java.util.Set;

public class DistinctEcho {
        public int []  lps(String p){
            int dp[] = new int[p.length()];
            int i =1;
            int j =0;

            while(i<p.length()){
                if(p.charAt(i)==p.charAt(j)){

                    dp[i] = j+1;
                    i++;
                    j++;
                }else{
                    if(j!=0){
                        j = dp[j-1];
                    }else{
                        i++;
                    }
                }
            }
            return dp;
        }

        public boolean kmp(String s){
            int m = s.length();
            String p = s.substring(0,m/2);
            String txt = s.substring(m/2);
            int dp[] = lps(p);

            int i =0;int j =0;
            while(i<txt.length()){
                if(p.charAt(j)==txt.charAt(i)){
                    i++;
                    j++;
                    if(j==p.length()) return true;
                }else{
                    if(j!=0){
                        j = dp[j-1];
                    }else{
                        i++;
                    }
                }
            }
            return false;

        }
        public int distinctEchoSubstrings(String text) {
            Set<String> set = new HashSet<>();
            int n = text.length();
            for(int i =0;i<n;i++){
                for(int len =2;i+len<=n;len+=2){
                    String sub = text.substring(i, i + len);
                    if(kmp(sub)){
                        set.add(sub);
                    }

                }
            }
            return set.size();

        }
    }

