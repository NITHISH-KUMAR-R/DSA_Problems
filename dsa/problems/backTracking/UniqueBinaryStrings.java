package dsa.problems.backTracking;

import java.util.HashSet;
import java.util.Set;

public class UniqueBinaryStrings {
    class Solution {
        public String generateCom(Set<String> set, String curr,int n ){
            if(curr.length()==n){
                if(!set.contains(curr)){
                    return curr;
                }
                return null;
            }

            String res = generateCom(set, curr+"0", n);
            if(res!=null) return res;

            return generateCom(set,curr+"1",n);
        }
        public String findDifferentBinaryString(String[] nums) {

            int n = nums[0].length();
            Set<String> set = new HashSet<>(c);
            for(String c : nums){
                set.add(c);
            }

            return  generateCom(set,"",n);


        }
    }
}
