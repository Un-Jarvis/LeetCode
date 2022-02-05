/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/* Recursive */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> preorder = new LinkedList<>();
        
        if (root == null) return preorder;
        
        preorder.add(root.val);
        for (int i = 0; root.children != null && i < root.children.size(); i++) {
            preorder.addAll(preorder(root.children.get(i)));
        }
        
        return preorder;
    }
}

/* Iterative */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> preorder = new LinkedList<>();
        
        if (root == null) return preorder;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            Node cur = stack.pop();
            int size = 0;
            if (cur.children != null) size = cur.children.size();
            
            preorder.add(cur.val);
            for (int i = 0; i < size; i++) {
                stack.push(cur.children.get(size - i - 1));
            }
        }
        
        return preorder;
    }
}