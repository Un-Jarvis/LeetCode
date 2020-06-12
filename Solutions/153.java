/* 两个解法思路一样没啥区别 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == nums[left]) {
                if (nums[left] < nums[right]) return nums[left];
                else return nums[right];
            }

            if (nums[mid] > nums[left] && nums[mid] < nums[right]) {
                return nums[left];
            } else if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
            }            
        }

        return nums[left];
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        
        if (nums.length == 1) return nums[0];

        // If left < right, nums array is not rotated and left is min
        if (nums[left] < nums[right]) return nums[left];

        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] < nums[left]) {
                right = mid;
            } else if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                if (nums[left] < nums[right]) return nums[left];
                else return nums[right];
            }
            
        }

        return 0;
    }
}