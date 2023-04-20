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
    Integer prev;
    int res=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        prev=null;
        inOrder(root);
        return res;
    }
    public void inOrder(TreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        if(prev!=null){
            res=Math.min(res,node.val-prev);
        }
        prev=node.val;
        inOrder(node.right);
    }
}