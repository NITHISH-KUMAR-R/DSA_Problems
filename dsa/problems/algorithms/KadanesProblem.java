package dsa.problems.algorithms;

public class KadanesProblem {
    public static void main(String[] args) {
        int arr[] = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(kadane(arr));
    }
    public static  int kadane(int arr[]){
        int max = arr[0];
        int curr = arr[0];

        for(int i =1;i<arr.length;i++){
            curr = Math.max(arr[i], arr[i]+curr);
            max = Math.max(curr, max);
        }
        return max;
    }
}
