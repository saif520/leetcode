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
    public boolean checkTree(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        int childSum=0;
        if(root.left!=null){
            childSum+=root.left.val;
        }
        if(root.right!=null){
            childSum+=root.right.val;
        }
        boolean left=checkTree(root.left);
        boolean right=checkTree(root.right);

        if(left==true&&right==true&&root.val==childSum){
            return true;
        }
        else{
            return false;
        }

    }
}