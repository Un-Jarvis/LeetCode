/* 
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        else if (preorder.length == 1) return new TreeNode(preorder[0]);

        // Find position to construct subtrees
        int pos = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                pos = i;
            }
        }

        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(preorder, pos + 1, preorder.length), Arrays.copyOfRange(inorder, pos + 1, preorder.length));
        
        return root;
    }
}

/*
 * Head node of a tree occurs first in pre-order representation and occurs in the middle of in-order representation.
 * 
 * The values at the left of the root value in inorder representation are the values in left subtree.
 * Thus, the left subtree has n nodes where n = inorder.indexOf(preorder[0]).
 * 
 * Time Complexity: O(n^2) where n is the number of nodes.
 */