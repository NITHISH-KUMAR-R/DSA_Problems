package dsa.problems.Mindproblems;

import java.util.*;

public class TupleWithSameProduct {
    class Solution {
        int combination(int n){
            return (n*(n-1))/2;
        }
        public int tupleSameProduct(int[] nums) {
            int count =0;

            Map<Integer,Integer> map = new HashMap<>();
            for(int i =0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    int key = nums[i]* nums[j];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }

            for(Map.Entry<Integer,Integer> c:map.entrySet()){
                int value = c.getValue();
                //n*(n-1)/2; combination formula
                if(value>1){
                    count+= (value* (value-1))/2*8;
                }
            }
            return count;


        }
    }
}
