package dsa.problems.recursionpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SumK {
    public static void recursion(int index, int arr[], int curr, int sum, List<Integer> temp, List<List<Integer>> list) {
        if (curr == sum) {
            if(!list.contains(temp)) {
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        if (curr > sum) {
            return;
        }
        if (index < arr.length) {
            if(!temp.contains(arr[index])) {
                temp.add(arr[index]);
                recursion(index + 1, arr, curr + arr[index], sum, temp, list);
                temp.remove(temp.size() - 1);
                recursion(index + 1, arr, curr, sum, temp, list);
            }
        }
    }

    public static void main(String a[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8,1,2};
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        recursion(0, arr, 0, 7, new ArrayList<>(), list);
        System.out.println("Ans: " + list);
    }
}
