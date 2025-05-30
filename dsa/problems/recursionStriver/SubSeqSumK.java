package dsa.problems.recursionStriver;

import java.util.ArrayList;
import java.util.List;

public class SubSeqSumK {

    public static int  recursion(int arr[], int i, List<List<Integer>>list,
                                 List<Integer> curr, int sum , int currSum){
        if(i==arr.length){
            if(currSum==sum){
                list.add(new ArrayList<>(curr));
                return 1;
            }
            return 0;
        }
        curr.add(arr[i]);
        int l = recursion(arr,i+1,list,curr, sum,currSum+arr[i]);
        curr.remove(curr.size()-1);
        int r = recursion(arr,i+1,list,curr,sum,currSum);

        return l+r;


    }
    public static  void main (String a[]){
        int arr[] = {3,1,2};
        List<List<Integer>> list  = new ArrayList<>();
        recursion(arr,0,list,new ArrayList<>(),3,0);

        System.out.println(list);

        System.out.println(recursion(arr,0,list,new ArrayList<>(),3,0));
    }
}
