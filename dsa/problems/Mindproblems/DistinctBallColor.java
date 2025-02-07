package dsa.problems.Mindproblems;

import java.util.*;

public class DistinctBallColor {
    class Solution {
        public int[] queryResults(int limit, int[][] queries) {

            List<Integer> list = new ArrayList<>();
            Map<Integer,Integer> colorFreq = new HashMap<>();
            Map<Integer,Integer> ballColor = new HashMap<>();
            for(int i =0;i<queries.length;i++){
                int ball = queries[i][0];
                int color = queries[i][1];

                if(ballColor.containsKey(ball)){
                    int prev = ballColor.get(ball);
                    colorFreq.put(prev,colorFreq.get(prev)-1);
                    if(colorFreq.get(prev)==0){
                        colorFreq.remove(prev);
                    }
                }

                ballColor.put(ball,color);
                colorFreq.put(color,colorFreq.getOrDefault(color,0)+1);
                list.add(colorFreq.size());
            }
            return list.stream().mapToInt(Integer::intValue).toArray();

        }
    }
}
