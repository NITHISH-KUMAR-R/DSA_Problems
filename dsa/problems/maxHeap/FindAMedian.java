package dsa.problems.maxHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindAMedian {
    class Solution {
        public ArrayList<Double> getMedian(int[] arr) {
            ArrayList<Double> medians = new ArrayList<>();
            ArrayList<Double> list = new ArrayList<>();

            // for (int i = 0; i < arr.length; i++) {
            //     list.add(arr[i]);
            //     Collections.sort(list);

            //     if (list.size() % 2 == 0) {

            //         double median = (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
            //         medians.add(median);
            //     } else {

            //         double median = list.get(list.size() / 2);
            //         medians.add(median);
            //     }
            // }
            // return medians;

            //maxHeap = ;
            //minHeap = 5;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // for(int i =0;i<arr.length;i++){
            //     if(maxHeap.size()==minHeap.size()){
            //         minHeap.add(arr[i]);
            //         int max = minHeap.remove();
            //         maxHeap.add(max);
            //         double median = maxHeap.peek();
            //         list.add(median);
            //     }else{
            //         maxHeap.add(arr[i]);
            //         int min = maxHeap.remove();
            //         minHeap.add(min);
            //         double median = (maxHeap.peek()+minHeap.peek());
            //         list.add(median/2);
            //     }
            // }

            // return list;



            for(int num : arr){
                if(maxHeap.isEmpty() || num <=maxHeap.peek()){
                    maxHeap.add(num);
                }else{
                    minHeap.add(num);
                }

                if(maxHeap.size()>minHeap.size()+1){
                    minHeap.add(maxHeap.poll());
                }else if(minHeap.size()>maxHeap.size()){
                    maxHeap.add(minHeap.poll());
                }

                if(maxHeap.size()==minHeap.size()){
                    double res  = (maxHeap.peek() + minHeap.peek())/2.0;
                    list.add(res);
                }else{
                    list.add((double) maxHeap.peek());
                }
            }
            return list;
        }

    }
}
