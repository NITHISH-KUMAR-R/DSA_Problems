package dsa.problems.priorityQueue;

import java.util.PriorityQueue;

public class LastStoneWeight {
        public  static int lastStoneWeight(int[] stones) {
            int n = stones.length;
            if(n==1) return 1;

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->Integer.compare(b,a));

            for(int num: stones){
                pq.offer(num);
            }
            while(!pq.isEmpty() && pq.size()>=2){
                int y = pq.poll();
                int x = pq.poll();
                int value = y-x;
                if(value!=0){
                    pq.offer(value);
                }

            }

            return pq.peek();
        }

        public static void main(String[] args){
            int arr[] = { 1,3 };

            System.out.println(lastStoneWeight(arr));
       }
    }

