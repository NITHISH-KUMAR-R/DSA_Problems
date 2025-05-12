package dsa.problems.minHeap;

import java.util.PriorityQueue;

public class KthLargestContSubArray {
        public static int kthLargest(int[] arr, int k) {
            // code here
            int n = arr.length;
            int preFixSum []  =new int[n+1];
            for(int i =0;i<n;i++){
                preFixSum[i+1] = preFixSum[i]+arr[i];
            }

            PriorityQueue<Integer> pq  =  new PriorityQueue<>();

            for(int i =0;i<n;i++){
                for(int j =i;j<n;j++){
                    int sum = preFixSum[j+1]- preFixSum[i];
                    if(pq.size()<k){
                        pq.offer(sum);
                    }else if(sum> pq.peek()){
                        pq.poll();
                        pq.offer(sum);
                    }

                }
            }
            return pq.peek();


        }
    }


