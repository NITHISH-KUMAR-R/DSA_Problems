package dsa.problems.binarySearch;

public class CapacityToShip {
        public boolean canWeShipWithMidCapacity(int weights[], int maxCapacity, int days){
            int currentWeight = 0;
            int dayCount  =1;

            for(int weight : weights){
                if(currentWeight + weight > maxCapacity){
                    dayCount++;
                    //new Day started so start load from 0;
                    currentWeight =0;
                }
                currentWeight +=weight;
            }

            return dayCount<=days;
        }
        public int shipWithinDays(int[] weights, int days) {

            int low = 0;
            int high = 0;
            for(int num : weights){
                low = Math.max(low,num);
                high +=num;
            }

            while(low<high){
                int mid = low + (high-low)/2;
                if(canWeShipWithMidCapacity(weights,mid,days)){
                    high = mid;
                }else{
                    low = mid+1;
                }

            }

            return high;
        }
    }

