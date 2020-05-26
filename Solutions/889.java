/** 
 * Tree Traversal Notes:
 *            1
 *         /     \
 *      2           3
 *    /   \       /
 *   4     5     6
 *
 * Depth First Traversals:
 *   (a) Inorder 中序遍历 (Left, Root, Right) : 4 2 5 1 6 3
 *   (b) Preorder 前序遍历 (Root, Left, Right) : 1 2 4 5 3 6
 *   (c) Postorder 后序遍历 (Left, Right, Root) : 4 5 2 6 3 1
 *
 * Breadth First or Level Order Traversal : 1 2 3 4 5 6
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        } else if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        
        // Find position to construct the right subtree
        int pos = 0;
        for (int i = 0; i < pre.length; i++) {
            if (post[i] == pre[1]) {
                pos = i + 1;
            }
        }

        TreeNode root = new TreeNode(pre[0]);
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, pos + 1), Arrays.copyOfRange(post, 0, pos));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, pos + 1, pre.length), Arrays.copyOfRange(post, pos, pre.length - 1));
        
        return root;
    }
}

/**
 * Head node of a tree occurs first in pre-order representation and occurs last in pos-order representation.
 * That is, the tree has n nodes where n = post.indexOf(pre[0]) + 1.
 * 
 * In the same way, pre[1] is the root node of the left subtree. 
 * Thus the left tree has n nodes where n = post.indexOf(pre[1]) + 1.
 * 
 * Time Complexity: O(n^2) where n is the number of nodes.
 */