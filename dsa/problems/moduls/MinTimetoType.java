package dsa.problems.moduls;

public class MinTimetoType {
    class Solution {
        public int minTimeToType(String word) {

            int totalTime =0;
            char currPointer ='a';

            for(char s : word.toCharArray()){
                int clockwise = (s-currPointer+26)%26;
                int antiClockwise =(currPointer-s+26)%26;

                totalTime += Math.min(clockwise,antiClockwise)+1;
                currPointer =s;
            }

            return totalTime;


        }
    }
}
