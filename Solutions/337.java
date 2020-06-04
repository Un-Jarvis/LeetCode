/*
 * 直接看代码不容易理解。
 * 每个tree node返回两个int，nums[0]是rob this node获得的最大利益，nums[1]是not rob this node获得的最大利益。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] nums = dfs(root);
        return Math.max(nums[0], nums[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] nums = new int[2];

        // 如果rob当前的node，则他们的child nodes不能被rob
        nums[0] = root.val + left[1] + right[1];
        // 如果不rob当前的node，不需要考虑他们的child nodes是否被rob
        nums[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return nums;
    }
}