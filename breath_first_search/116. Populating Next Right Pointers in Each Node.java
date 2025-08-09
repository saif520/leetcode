/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         // Handle the base case when the tree is empty.
        if (root == null) {
            return root;
        }

        // Queue to hold the nodes to be processed.
        Deque<Node> queue = new ArrayDeque<>();
        // Start with the root node.
        queue.offer(root);

        // Traverse the binary tree level by level.
        while (!queue.isEmpty()) {
            // Previous node on the current level.
            Node previousNode = null;

            // Process all nodes in the current level.
            for (int i = queue.size(); i > 0; --i) {
                // Get the next node from the queue.
                Node currentNode = queue.poll();

                // Link the previous node (if any) to the current one.
                if (previousNode != null) {
                    previousNode.next = currentNode;
                }
                // Current node becomes the previous node for the next iteration.
                previousNode = currentNode;

                // Add the children of current node to the queue for next level processing.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        // Return the root of the modified tree.
        return root;
    }
}