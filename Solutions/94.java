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

/* Interative */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();       
            inorder.add(cur.val);
            cur = cur.right;
        }
        
        return inorder;
    }
}

/* Interative */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        if (root == null) return inorder;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                inorder.add(cur.val);
                root = cur.right;
            }
        }

        return inorder;
    }
}

/* Recursive */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        if (root == null) return inorder;

        if (root.left != null) inorder = inorderTraversal(root.left);
        inorder.add(root.val);
        if (root.right != null) inorder.addAll(inorderTraversal(root.right));

        return inorder;
    }
}