package dsa.problems.Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashSetPrb {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();

            for(int i:nums1){
                set.add(i);
            }

            Set<Integer> set2 = new HashSet<>();
            for(int i:nums2){
                if(set.contains(i)){
                    set2.add(i);
                }
            }
            int[] output = new int[set2.size()];
            int index = 0;
            for (int num : set2) {
                output[index++] = num;
            }
            return output;
        }
    }
}


class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i:a){
            set.add(i);
        }

        for(int i =0;i<b.length;i++){
            if(set.contains(b[i])){
                if(list.contains(b[i])){
                    continue;
                }
                list.add(b[i]);
            }
        }

        return list;

    }
}