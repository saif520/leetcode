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
    // Map to store the index of each value present in the inorder array for faster lookups.
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Build the index map for quick access during recursive calls
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        // Call the recursive method starting with the whole range of inorder and postorder arrays
        return buildTreeRecursive(inorder, postorder, 0, 0, inorder.length);
    }
     // Recursive method to build the binary tree, using inorder and postorder arrays.
    private TreeNode buildTreeRecursive(int[] inorder, int[] postorder, int inorderStart, int postorderStart, int length) {
        // If the current segment is empty, return null because there's no tree to build.
        if (length <= 0) {
            return null;
        }

        // The last node in the postorder segment is the current root.
        int rootValue = postorder[postorderStart + length - 1];
        // Get the index of the root value in the inorder array to split left and right subtrees.
        int inorderRootIndex = inorderIndexMap.get(rootValue);

        // Create the tree node for the value found.
        TreeNode rootNode = new TreeNode(rootValue);

        // Calculate the number of nodes in the left subtree.
        int leftSubtreeLength = inorderRootIndex - inorderStart;

        // Recursively build the left subtree.
        rootNode.left = buildTreeRecursive(inorder, postorder, inorderStart, postorderStart, leftSubtreeLength);

        // Recursively build the right subtree.
        // Note that the right subtree starts after the left subtree in the postorder array.
        rootNode.right = buildTreeRecursive(inorder, postorder, inorderRootIndex + 1, postorderStart + leftSubtreeLength, length - leftSubtreeLength - 1);

        // Return the constructed binary tree node.
        return rootNode;
    }
}