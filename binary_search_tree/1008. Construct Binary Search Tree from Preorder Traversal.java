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
    public static int idx;
    public static TreeNode construct(int[] pre,int left,int right){
        if(idx==pre.length) return null;
        if(pre[idx]<left||pre[idx]>right) return null;

        int val=pre[idx];
        TreeNode me=new TreeNode(val);
        idx++;

        TreeNode leftSubtree = construct(pre,left,val-1);
        TreeNode rightSubtree = construct(pre,val+1,right);
        me.left=leftSubtree;
        me.right=rightSubtree;
        return me;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        idx=0;
        TreeNode root=construct(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }
}