package dsa.problems.Hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarrayXor {

    class Solution {
        public long subarrayXor(int arr[], int k) {
            // code here

            Map<Integer,Integer> map = new HashMap<>(c);
            map.put(0,1);
            int count =0;
            int sum =0;

            for(int i :arr){
                sum ^= i;
                if(map.containsKey(sum^k)){
                    count +=map.get(sum^k);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }

            return count;
        }
    }
}
