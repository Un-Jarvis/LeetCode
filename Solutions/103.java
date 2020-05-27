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
    // Solution 1: Use two queues
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        queue.add(root);

        int level = 1;

        while (!queue.isEmpty() || !deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            if (level % 2 == 0) {
                int levelSize = deque.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = deque.removeLast();
                    temp.add(node.val);

                    if (node.right != null) queue.add(node.right);
                    if (node.left != null) queue.add(node.left);
                }
            } else {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.removeLast();
                    temp.add(node.val);

                    if (node.left != null) deque.add(node.left);
                    if (node.right != null) deque.add(node.right);
                }
            }

            list.add(temp);

            level++;
        }

        return list;
    }


    // Solution 2: Use one queue
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);

        boolean isRev = false;

        while (!deque.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            int levelSize = deque.size();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = deque.remove();

                if (!isRev) temp.add(node.val);
                else temp.addFirst(node.val);

                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }

            list.add(temp);

            isRev = !isRev;
        }
            
        return list;
    }
}