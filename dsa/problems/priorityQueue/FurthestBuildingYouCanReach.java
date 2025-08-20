package dsa.problems.priorityQueue;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int n = heights.length;
            int bricksUsed =0;
            for(int i = 1;i<n;i++){
                int difference = heights[i] - heights[i-1];

                if(difference>0){
                    pq.offer(difference);
                    if(pq.size()>ladders){
                        bricksUsed += pq.remove();
                    }
                    if(bricksUsed>bricks){
                        return i-1;
                    }
                }


            }

            return n-1;


        }
    }

