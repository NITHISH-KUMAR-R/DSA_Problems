package dsa.problems.binarySearch;

public class SearchinAlmostSortedArray {
        public int findTarget(int arr[], int target) {
            int i = 0;
            int j = arr.length - 1;

            while (i <= j) {
                int mid = i + (j - i) / 2;

                // Check mid
                if (arr[mid] == target) return mid;

                // Check mid - 1
                if (mid - 1 >= i && arr[mid - 1] == target) return mid - 1;

                // Check mid + 1
                if (mid + 1 <= j && arr[mid + 1] == target) return mid + 1;

                // Move the search window
                if (target < arr[mid]) {
                    j = mid - 2;
                } else {
                    i = mid + 2;
                }
            }

            return -1;
        }
    }

