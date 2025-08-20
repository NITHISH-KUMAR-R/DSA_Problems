package dsa.problems.binarySearch;

import java.util.ArrayList;

public class FarthestSmallesRight {
     public ArrayList<Integer> farMin(int[] arr) {
            int n = arr.length;
            int[] suffixMin = new int[n];

            suffixMin[n-1] = arr[n-1];
            for (int i = n-2; i >= 0; i--) {
                suffixMin[i] = Math.min(arr[i], suffixMin[i+1]);
            }

            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int lo = i+1, hi = n-1, ans = -1;
                while (lo <= hi) {
                    int mid = lo + (hi-lo)/2;
                    if (suffixMin[mid] < arr[i]) {
                        ans = mid;   // candidate, try farther
                        lo = mid+1;
                    } else {
                        hi = mid-1; // need smaller
                    }
                }
                result.add(ans);
            }

            return result;
        }
    }

