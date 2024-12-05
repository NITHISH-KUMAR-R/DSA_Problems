package dsa.problems.algorithms;

public class DutchNationalFlag {
    public void sort012(int[] arr) {
        // code here

        //Arrays.sort(arr);

        int mid = 0, low = 0, high = arr.length - 1;
        // int temp =0;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;

            }

        }
    }
}
