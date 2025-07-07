package dsa.problems.backTracking;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {

    public static void recursion(int index , int arr[], int target, List<Integer> temp, List<List<Integer>> list ){
        if(index==arr.length){
            if(target==0){
                list.add(new ArrayList<>(temp));
                return;
            }
            return;
        }

        if(arr[index]<=target){
            temp.add(arr[index]);
            recursion(index,arr, target-arr[index],temp, list);
            temp.remove(temp.size()-1);
        }
        recursion(index+1,arr,target, temp,list);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        recursion(0,candidates, target, new ArrayList<>(),list);
        System.out.println(list);
        return list;

    }

    public static void main(String a[]){
       int[] candidates = {2,3,6,7} ; int target = 7;
        combinationSum(candidates,target);

    }
}