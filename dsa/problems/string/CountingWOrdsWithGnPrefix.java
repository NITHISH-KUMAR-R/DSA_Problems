package dsa.problems.string;

public class CountingWOrdsWithGnPrefix {
   // 2185. Counting Words With a Given Prefix
   class Solution {
       public int prefixCount(String[] words, String pref) {
           int count =0;

           for(String s : words){
               if(s.startsWith(pref)){
                   count++;
               }
           }
           return count;
       }
   }
}
