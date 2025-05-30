package dsa.problems.recursionStriver;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSequences {

    public static void recursion(int arr[],int i, List<List<Integer>>list, List<Integer> curr){
        if(i==arr.length){
            list.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[i]);
        recursion(arr,i+1,list,curr);
        curr.remove(curr.size()-1);
        recursion(arr,i+1,list,curr);


    }
    public static  void main (String a[]){
        int arr[] = {3,2,1};
        List<List<Integer>> list  = new ArrayList<>();
        recursion(arr,0,list,new ArrayList<>());

        System.out.println(list);
    }
}
