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
    public void inTraverse(TreeNode root,ArrayList<Integer>inorder){
        if(root==null) return;
        inTraverse(root.left,inorder);
        inorder.add(root.val);
        inTraverse(root.right,inorder);
    }
    public TreeNode constructBalancedBST(ArrayList<Integer>in,int low,int high){
        if(low>high) return null;
        int mid=low+(high-low)/2;
        TreeNode curr=new TreeNode(in.get(mid));
        curr.left=constructBalancedBST(in,low,mid-1);
        curr.right=constructBalancedBST(in,mid+1,high);
        return curr;
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return null;
        ArrayList<Integer>inorder=new ArrayList<>();
        inTraverse(root,inorder);
        return constructBalancedBST(inorder,0,inorder.size()-1);
    }
}