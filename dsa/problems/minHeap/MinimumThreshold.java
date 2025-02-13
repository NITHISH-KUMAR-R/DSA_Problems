package dsa.problems.minHeap;

import java.util.PriorityQueue;

public class MinimumThreshold {
    class Solution {
        public int minOperations(int[] nums, int k) {

            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            for(int n : nums){
                minHeap.offer((long)n);
            }

            int count =0;
            while(minHeap.size()>1 && minHeap.peek()<k){
                long x = minHeap.poll();
                long y  = minHeap.poll();
                long res = Math.min(x,y)*2 + Math.max(x,y);
                minHeap.offer(res);
                count++;
            }

            while(!minHeap.isEmpty()){
                if(minHeap.peek()<k){
                    return -1;
                }
                minHeap.poll();
            }
            return count;

        }
    }

}
