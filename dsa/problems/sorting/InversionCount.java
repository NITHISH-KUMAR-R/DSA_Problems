package dsa.problems.sorting;

public class InversionCount {
    // User function Template for Java

        public static int inversionCountValue =0;
        public static void  mergeFull(int arr[], int leftArr[], int rightArr[], int left, int right){
            int i =0;int j =0; int k=0;
            while(i<left && j<right){
                if(leftArr[i]<=rightArr[j]){
                    arr[k++] = leftArr[i++];
                }else{
                    inversionCountValue += (left-i);
                    arr[k++] = rightArr[j++];
                }

            }

            while(i<left){
                arr[k++] = leftArr[i++];
            }
            while(j<right){
                arr[k++]= rightArr[j++];
            }

        }
        public static void mergeSort(int arr[], int n){
            if(n<2) return;
            int mid = n/2;
            int leftArr [] = new int[mid];
            int rightArr [] = new int[n-mid];
            for(int i =0;i<mid;i++){
                leftArr[i] = arr[i];
            }
            for(int i =mid ;i<n;i++){
                rightArr[i-mid] = arr[i];
            }

            mergeSort(leftArr,mid);
            mergeSort(rightArr,n-mid);
            mergeFull(arr,leftArr,rightArr,mid,n-mid);
        }
        // Function to count inversions in the array.
        static int inversionCount(int arr[]) {
            // Your Code Here
            inversionCountValue = 0; //reset for each test case
            int n = arr.length;
            mergeSort(arr,n);
            return inversionCountValue;
        }
    }
