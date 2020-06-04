/* 和#198同理，虽然感觉很啰嗦 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] dp1 = new int[nums.length - 1];
            dp1[0] = nums[0];
            dp1[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < dp1.length; i++) {
                dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
            }

            int[] dp2 = new int[nums.length - 1];
            dp2[dp2.length - 1] = nums[nums.length - 1];
            dp2[dp2.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
            for (int i = dp2.length - 3; i >= 0; i--) {
                dp2[i] = Math.max(dp2[i + 1], nums[i + 1] + dp2[i + 2]);
            }

            return Math.max(dp1[dp1.length - 1], dp2[0]);
        }
    }
}