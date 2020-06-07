class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (nums[left] >= target) {
                return left;
            } else if (nums[left] < target && nums[right] > target) {
                left++;
                right--;
            } else if (nums[right] < target) {
                return right + 1;
            } else if (nums[right] == target) {
                return right;
            }
        }

        return left;
    }
}