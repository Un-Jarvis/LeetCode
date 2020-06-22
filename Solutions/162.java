/*
 * Binary Search Tree
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        int result = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

/*
 * 简单粗暴的解法，虽然快但是比用binary search tree占空间
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    if (nums[i] > nums[i + 1]) return i;
                }

                if (i > 0 && i < nums.length - 1) {
                    if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
                }

                if (i == nums.length - 1) {
                    if (nums[i] > nums[i - 1]) return i;
                }
            }
        }
        return 0;
    }
}