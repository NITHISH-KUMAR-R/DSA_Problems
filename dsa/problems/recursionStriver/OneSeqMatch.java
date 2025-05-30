package dsa.problems.recursionStriver;

import java.util.ArrayList;
import java.util.List;

public class OneSeqMatch {

    public static boolean recursion(int arr[], int i, List<List<Integer>> list,
                                    List<Integer> curr, int sum, int currSum) {
        if (i == arr.length) {
            if (currSum == sum) {
                list.add(new ArrayList<>(curr));
                return true;
            }
            return false;
        }
        curr.add(arr[i]);
        if( recursion(arr, i + 1, list, curr, sum, currSum + arr[i])==true) return true;
        curr.remove(curr.size() - 1);
        if(recursion(arr, i + 1, list, curr, sum, currSum)==true) return true;

        return false;
    }

    public static void main(String a[]) {
        int arr[] = {3, 1, 2};
        List<List<Integer>> list = new ArrayList<>();
        recursion(arr, 0, list, new ArrayList<>(), 3, 0);

        System.out.println(list);
    }
}


