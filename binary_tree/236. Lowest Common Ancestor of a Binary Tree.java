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
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode n1, TreeNode n2) {
        if(node==null){
            return null;
        }
        if(node==n1){
            return node;
        }
        if(node==n2){
            return node;
        }
        TreeNode foundAnyoneInLeft=lowestCommonAncestor(node.left,n1,n2);
        TreeNode foundAnyoneInRight=lowestCommonAncestor(node.right,n1,n2);

        if(foundAnyoneInLeft!=null&&foundAnyoneInRight!=null){
            return node;
        }
        if(foundAnyoneInLeft!=null){
            return foundAnyoneInLeft;
        }
        if(foundAnyoneInRight!=null){
            return foundAnyoneInRight;
        }
        return null;
    }
}