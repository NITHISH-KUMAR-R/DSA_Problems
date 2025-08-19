package dsa.problems.trickProblems;

public class ZeroFilledArrays {
        public long zeroFilledSubarray(int[] nums) {
            long total =0;
            long currentStreak =0;

            for(int  num : nums){
                if(num==0){
                    currentStreak++;
                    total += currentStreak;
                }else{
                    currentStreak =0;
                }
            }

            return total;



        }

}
