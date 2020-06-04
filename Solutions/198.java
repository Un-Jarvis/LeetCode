/*
 * Dynamic Programming - store the results of subproblems, so that we do not have to re-compute them when needed later.
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            int dp[] = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[dp.length - 1];
        }
    }
}


/*
 * Recursion - 非常耗时 
 */
// class Solution {
//     public int rob(int[] nums) {
//         if (nums.length <= 0) {
//             return 0;
//         } else if (nums.length == 1) {
//             return nums[0];
//         } else if (nums.length == 2) {
//             return Math.max(nums[0], nums[1]);
//         } else {
//             int max1 = nums[0] += rob(Arrays.copyOfRange(nums, 2, nums.length));
//             int max2 = nums[1] += rob(Arrays.copyOfRange(nums, 3, nums.length));
//             if (max1 > max2) return max1;
//             else return max2;
//         }
//     }
// }