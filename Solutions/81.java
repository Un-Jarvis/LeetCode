/* 和#33几乎一模一样的题，解法思路基本相同 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int left = 0, mid = 0, right = nums.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }
            
            if (nums[left] < nums[mid]) { // left < mid 说明至少从nums[left]到nums[mid]这一段数组是从小到大排序的
                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) { // left > mid 说明至少从nums[mid]到nums[right]这一段数组是从小到大排序的，等同于 mid < right
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // left = mid 说明有duplicate，不好判断是否rotate以及rotate的位置
                left++;
                right--;
            }
        }
        
        return false;
    }
}



class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, mid = 0, right = nums.length - 1;

        if (nums.length == 0) return false;

        do {
            mid = left + (right - left) / 2;

            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }
            
            // left < right 说明没有rotate
            if (nums[left] < nums[right]) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                left++;
                right--;
            }
        } while (left < right);
        
        return false;
    }
}