package dsa.problems.binarySearch;

//81. Search in Rotated Sorted Array II - Leetcode
public class SearchInRotatedSorted81 {
        public boolean search(int[] nums, int target) {
            int left =0;
            int right =nums.length-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                if(nums[mid] == target){
                    return true;
                }

                if(nums[left] == nums[mid] && nums[mid]==nums[right]){
                    left++;
                    right--;
                    continue;
                }

                if(nums[left]<=nums[mid]){
                    if(nums[left]<=target && target<=nums[mid]){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }else{
                    if(nums[mid]<=target && target<=nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }
            return false;
        }

}
