package dsa.problems.sorting;

import java.util.Arrays;

public class MergeSort {

    public static  void merge(int arr[], int n){
        if(n<2) return;
        int mid = n/2;
        int leftArr [] = new int[mid];
        int rightArr[] = new int[n-mid];

        for(int i =0;i<mid;i++){
            leftArr[i] = arr[i];
        }
        for(int i =mid ;i<n;i++){
            rightArr[i-mid] = arr[i];
        }

        merge(leftArr,mid);
        merge(rightArr,n-mid);
        mergeFull(arr,leftArr,rightArr,mid,n-mid);
    }

    private static void mergeFull(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {

        int i=0;int j =0; int k =0;
        while(i<left && j<right){
            if(leftArr[i]<=rightArr[j]){
                arr[k++] = leftArr[i++];
            }else{
                arr[k++] = rightArr[j++];
            }
        }

        while(i<left){
            arr[k++]= leftArr[i++];
        }
        while(j<right){
            arr[k++] = rightArr[j++];
        }

    }

    public static  void main(String a[]){
        int arr[] = {1,5,6,7,9,8,4,11,10,45,33};
        int n = arr.length;
        merge(arr,n);
        System.out.println(Arrays.toString(arr));

    }
}
