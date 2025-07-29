package dsa.problems.trickProblems;

import java.util.Arrays;

public class NextGreaterElement {
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
    public static  void reverse(int arr[], int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public static int [] nextPermutation(int arr[]){
        int n = arr.length;
        int index =-1;
        for(int i =n-2;i>=0;i--){
            if ((arr[i]<arr[i+1])){
                index =i;
                break;
            }
        }
        if(index==-1){
            return arr;
        }
        for(int i= n-1;i>=index;i--){
            if(arr[i]>arr[index]){
                swap(arr,index,i);
                break;
            }
        }
        reverse(arr,index+1,n-1);
        return arr;

    }
    public static  int nextGreaterElementWithSameDigits(int n) {

        String numStr = String.valueOf(n);
        int[] arr = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            arr[i] = numStr.charAt(i) - '0'; // Convert char digit to int
        }
        int[] original = arr.clone();
        int nums[]= nextPermutation(arr);
        if(Arrays.equals(nums,original)) return -1;
        int result =0;
        for(int num: nums){
            result = result*10+num;
        }
        return result;

    }
    public static void main(String a[]){
        System.out.println(nextGreaterElementWithSameDigits(12443322));
    }
}
