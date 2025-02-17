package dsa.problems.backTracking;

public class NumTilesPossibilities {
    class Solution {

        public int wayCount(int freq[]){
            int count  =0;
            for(int i =0;i<26;i++){
                if(freq[i]>0){
                    freq[i]--;
                    count += 1+ wayCount(freq);
                    freq[i]++;
                }
            }
            return count;
        }
        public int numTilePossibilities(String tiles) {
            int [] arr = new int[26];
            for(char c : tiles.toCharArray()){
                arr[c-'A']++;
            }
            return wayCount(arr);
        }
    }
}
