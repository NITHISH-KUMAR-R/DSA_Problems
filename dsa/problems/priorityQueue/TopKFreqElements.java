package dsa.problems.priorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFreqElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int n = nums.length;
            Map<Integer,Integer> map = new HashMap<>();
            List<Integer>[] bucket = new List[n+1];

            for(int num : nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }

            for(int key : map.keySet()){
                int value = map.get(key);
                if(bucket[value]==null){
                    bucket[value] = new ArrayList<>();
                }
                bucket[value].add(key);
            }
            int []res = new int[k];
            int counter =0;


            for(int i =n;i>=0 && counter<k ;i--){
                if(bucket[i]!=null){
                    for(int num: bucket[i]){
                        res[counter++]= num;
                    }
                }
            }

            return res;


        }
    }
}
