class Solution {
    public int search(int[] nums, int target) {
        //corner case
        if ( nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1, mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}