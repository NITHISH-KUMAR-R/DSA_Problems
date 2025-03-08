package dsa.problems.slidingWindow;

public class MinimumReColorBlock {
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int min =Integer.MAX_VALUE;
            int bCount =0;
            for(int i =0;i<k;i++){
                if(blocks.charAt(i)=='W'){
                    bCount++;
                }
            }
            min = bCount;

            for(int i =k;i<blocks.length();i++){
                if(blocks.charAt(i-k)=='W'){
                    bCount--;
                }
                if(blocks.charAt(i)=='W'){
                    bCount++;
                }

                min = Math.min(bCount,min);
            }

            return min;
        }
    }
}

//2379. Minimum Recolors to Get K Consecutive Black Blocksc