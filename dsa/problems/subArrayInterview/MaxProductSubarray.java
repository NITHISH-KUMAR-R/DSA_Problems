package dsa.problems.subArrayInterview;

class MaxProductSubarray {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        // // code here
        // int maxProd = arr[0];
        //  int  minProd = arr[0];
        //  int result = arr[0];
        //  for(int i =1;i<arr.length;i++){
        //      if (arr[i] < 0) {
        //         int temp = maxProd;
        //         maxProd = minProd;
        //         minProd = temp;
        //     }

        //     // Update maxProd and minProd
        //     maxProd = Math.max(arr[i], maxProd * arr[i]);
        //     minProd = Math.min(arr[i], minProd * arr[i]);

        //     // Update the result with the maximum product so far
        //     result = Math.max(result, maxProd);

        //  }
        //  return result;
        int n = arr.length;
        int res = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            l = (l == 0 ? 1 : l) * arr[i];
            r = (r == 0 ? 1 : r) * arr[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}