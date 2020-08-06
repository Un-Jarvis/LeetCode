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
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : mirror(root.left, root.right);
    }   

    private boolean mirror(TreeNode left, TreeNode right) {
        // 如果左右两边都没有child，则对称
        if (left == null && right == null) return true;
        // 如果只有一边有child，则不对称
        if (left == null || right == null) return false;
        // 如果左右都有child但值不同，则不对称
        if (left.val != right.val) return false;
        // 如果当前左右对称，判断他们的children对不对称
        return mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}