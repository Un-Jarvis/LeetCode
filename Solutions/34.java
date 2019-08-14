class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        
        int left = searchLeft(nums, leftIndex, rightIndex, target);
        int right = searchRight(nums, leftIndex, rightIndex, target);
        
        return new int[]{left, right};
    }
    
    public int searchLeft(int[] nums, int leftIndex, int rightIndex, int target) {
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (rightIndex - leftIndex <= 1) {
            if (nums[leftIndex] == target) {
                return leftIndex;
            } else if (nums[rightIndex] == target) {
                return rightIndex;
            } else {
                return -1;
            }
        } else {
            if (nums[leftIndex] == target) {
                return leftIndex;
            } else if (nums[leftIndex] > target) {
                return -1;
            } else {
                if (nums[midIndex] >= target) {
                    return searchLeft(nums, leftIndex, midIndex, target);
                } else {
                    return searchLeft(nums, midIndex, rightIndex, target);
                }
            }
        }
    }
    
    public int searchRight(int[] nums, int leftIndex, int rightIndex, int target) {
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (rightIndex - leftIndex <= 1) {
            if (nums[rightIndex] == target) {
                return rightIndex;
            } else if (nums[leftIndex] == target) {
                return leftIndex;
            } else {
                return -1;
            }
        } else {
            if (nums[rightIndex] == target) {
                return rightIndex;
            } else if (nums[rightIndex] < target) {
                return -1;
            } else {
                if (nums[midIndex] <= target) {
                    return searchRight(nums, midIndex, rightIndex, target);
                } else {
                    return searchRight(nums, leftIndex, midIndex, target);
                }
            }
        }
    }
}