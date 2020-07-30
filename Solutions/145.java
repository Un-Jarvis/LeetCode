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

/* 
 * Iterative
 * 
 * Use last visited node to avoid visiting right child repeatedly
 * 
 * Time Complexity: O(n)
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.peek();
            if (node.right != null && node.right != last) {  // right has not been explored
                cur = node.right;
            } else {
                node = stack.pop();
                postorder.add(node.val);
                last = node;
            }
        }
        return postorder;
    }
}

/* Iterative */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            if (tmp != null) {
                postorder.add(0, tmp.val);
                stack.push(tmp.left);
                stack.push(tmp.right);
            }
        }

        return postorder;
    }
}

/* Recursive */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();

        if (root == null) return postorder;

        if (root.left != null) postorder = postorderTraversal(root.left);
        if (root.right != null) postorder.addAll(postorderTraversal(root.right));
        postorder.add(root.val);

        return postorder;
    }
}