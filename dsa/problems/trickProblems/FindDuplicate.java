package dsa.problems.trickProblems;

public class FindDuplicate {

    //SLow fast cycle Detection algorithms
    class Solution {
        public int findDuplicate(int[] arr) {
            // code here

            int slow =0;
            int fast  =0;
            do{
                slow = arr[slow];
                fast = arr[arr[fast]];
            }while(slow!=fast);


            slow=0;
            while(slow!=fast){
                slow = arr[slow];
                fast = arr[fast];
            }
            return slow;

        }
    }
}
