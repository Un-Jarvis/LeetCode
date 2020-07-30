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

/* Iterative */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        if (root == null) return preorder;

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (stack.size() > 0) {
            TreeNode tmp = stack.pop();
            preorder.add(tmp.val);
            if (tmp.right != null) stack.add(tmp.right);
            if (tmp.left != null) stack.add(tmp.left);
        }

        return preorder;
    }
}

/* Recursive */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        if (root == null) return preorder;

        preorder.add(root.val);
        if (root.left != null) preorder.addAll(preorderTraversal(root.left));
        if (root.right != null) preorder.addAll(preorderTraversal(root.right));

        return preorder;
    }
}