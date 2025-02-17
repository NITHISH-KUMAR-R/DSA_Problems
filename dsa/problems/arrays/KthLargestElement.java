package dsa.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    class Solution {
        public ArrayList<Integer> kLargest(int[] arr, int k) {
            // Your code here


            //     ArrayList<Integer> list = new ArrayList<>();
            //  Arrays.sort(arr);
            //  int count =0;
            //  for(int i = arr.length-1; i>=0;i--){
            //      if(count < k){
            //          list.add(arr[i]);
            //          count++;
            //      }else{
            //      break;}

            //  }
            //  return list;


            PriorityQueue<Integer> q = new PriorityQueue<>();

            for(int num : arr){
                q.offer(num);
                if(q.size()>k){
                    q.poll();
                }
            }

            ArrayList<Integer> list = new ArrayList<>(q);
            list.sort(Collections.reverseOrder());
            return list;



        }
    }
}
