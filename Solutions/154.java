class Solution {
    public int findMin(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (mid == left) {
                if (nums[left] < nums[right]) return nums[left];
                else return nums[right];
            }

            if (nums[mid] >= nums[left] && nums[mid] < nums[right]) {
                return nums[left];
            } else if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[mid] > nums[left] && nums[mid] >= nums[right]) {
                return nums[left];
            } else if (nums[mid] < nums[left] && nums[mid] <= nums[right]) {
                right = mid;
            } else if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
        }
        
        return nums[left];
    }
}