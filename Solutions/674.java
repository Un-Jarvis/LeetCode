/* 最优解 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            int tmpLength = 1;
            while(i + 1 < nums.length && nums[i + 1] > nums[i]) {
                tmpLength++;
                i++;
            }
            length = Math.max(length,tmpLength);
        }
        return length;
    }
}

/* 脑子不太清晰解 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int length = 0;
        int start = 0, end = 0;

        while (end < nums.length) {
            if (end <= 0 || end == start) {
                end++;
            } else if (nums[end] <= nums[end - 1]) {
                if (length < end - start) length = end - start;
                start = end;
            } else {
                end++;
            }
        }

        if (length < end - start) length = end - start;

        return length;
    }
}