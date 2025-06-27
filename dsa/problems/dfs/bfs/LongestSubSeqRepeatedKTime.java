package dsa.problems.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubSeqRepeatedKTime {
    class Solution {
        public boolean isKTimeRepeated(String temp, String src,int k){

            int i =0;
            int count =0;
            for(char c : src.toCharArray()){
                if(c ==temp.charAt(i)){
                    i++;
                    if(i==temp.length()){
                        i=0;
                        count++;
                        if(count==k) return true;
                    }
                }
            }
            return false;
        }
        public String longestSubsequenceRepeatedK(String s, int k) {
            Queue<String> q = new LinkedList<>();
            q.add("");
            String ans ="";

            while(!q.isEmpty()){
                String str = q.poll();
                for(char c = 'a' ; c<='z';c++){
                    String temp = str+c;
                    if(isKTimeRepeated(temp,s,k)){
                        ans = temp;
                        q.add(temp);
                    }
                }
            }
            return ans;
        }
    }
}
