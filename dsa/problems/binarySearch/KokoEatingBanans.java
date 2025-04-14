package dsa.problems.binarySearch;

public class KokoEatingBanans {
    class Solution {
        public static boolean canEatInTime(int [] piles,int givenSpeed, int givenHour){
            int hour =0;
            for(int pile:piles){
                //hour += (pile+givenSpeed-1)/givenSpeed // Equivalent to ceiling(pile / givenSpeed)
                hour += (int)Math.ceil((double)pile/givenSpeed);
            }
            return hour<=givenHour;
        }
        public int minEatingSpeed(int[] piles, int h) {
            int leftSpeed = 1;
            int rightSpeed =0;

            for(int pile:piles){
                rightSpeed = Math.max(pile,rightSpeed);
            }

            while(leftSpeed<rightSpeed){
                int mid = leftSpeed+ (rightSpeed-leftSpeed)/2;

                if(canEatInTime(piles,mid,h)){
                    rightSpeed = mid;
                }else{
                    leftSpeed = mid+1;
                }
            }
            return leftSpeed;

        }
    }
}
