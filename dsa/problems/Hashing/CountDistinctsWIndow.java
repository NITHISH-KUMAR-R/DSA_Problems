package dsa.problems.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctsWIndow {

    class Solution {
        ArrayList<Integer> countDistinct(int arr[], int k) {
            // code here

            ArrayList<Integer> ans = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

                if (i >= k) {
                    int left = arr[i - k];
                    map.put(left, map.get(left) - 1);
                    if (map.get(left) == 0) {
                        map.remove(left);
                    }
                }

                if (i >= k - 1) {
                    ans.add(map.size());
                }
            }

            return ans;

        }
    }

}
