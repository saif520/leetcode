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
    public void inTraversal(TreeNode node, List<Integer>inOrder){
        if(node==null){
            return;
        }
        inTraversal(node.left,inOrder);
        inOrder.add(node.val);
        inTraversal(node.right,inOrder);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        inTraversal(root,list);
        return list;
    }
}