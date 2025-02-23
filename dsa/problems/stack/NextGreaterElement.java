package dsa.problems.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
    class Solution {
        // Function to find the next greater element for each element of the array.
        public ArrayList<Integer> nextLargerElement(int[] arr) {
            // code here

            // ArrayList<Integer> list = new ArrayList<>();

            // for(int i =0;i<arr.length;i++){
            //   for(int j=i+1;j<arr.length;j++){
            //       if(arr[i]<arr[j]){
            //           list.add(arr[j]);
            //           break;
            //       }else if(j==arr.length-1){
            //           list.add(-1);
            //           break;
            //       }
            //   }
            // }

            // list.add(-1);

            // return list;


            ArrayList<Integer> list = new ArrayList<>();
            Stackc<Integer> st = new Stack<>();

            for(int i = arr.length-1;i>=0;i--){
                while(!st.isEmpty() && st.peek()<=arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(st.peek());
                }

                st.push(arr[i]);
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = list.size()-1;i>=0;i--){
                ans.add(list.get(i));
            }
            return ans;
        }
    }
}
