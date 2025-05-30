package dsa.problems.trickProblems;

import java.util.Arrays;

public class NextPermutation {
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

    public static int[] nextPermutation(int[] nums) {
        //First Find the first descreaing number from end;
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <nums[i + 1]) {
                index = i;
                break;
            }
        }

        if(index==-1){
            reverse(nums,0,n-1);
            return nums;
        }
        //sawap with next greater  element after the index
        for(int i = n-1;i>=index;i--){
            if(nums[i]>nums[index]){
                swap(nums,index,i);
                break;
            }
        }

        reverse(nums,index+1,n-1);
        return nums;

    }

    public static void main(String a[]){
        int arr[]={1,1,5,4,1};

        System.out.println(Arrays.toString(nextPermutation(arr)));

    }
}
