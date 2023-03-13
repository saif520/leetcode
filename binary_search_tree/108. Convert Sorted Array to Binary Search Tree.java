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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        TreeNode root=construct(nums,0,n-1);
        return root;
    }
    static TreeNode construct(int arr[],int l,int r){
        if(l>r)return null;
        int mid=(l+r)/2;
        int val=arr[mid];

        TreeNode me=new TreeNode(val);

        TreeNode leftSubtree=construct(arr,l,mid-1);
        TreeNode rightSubtree=construct(arr,mid+1,r);

        me.left=leftSubtree;
        me.right=rightSubtree;

        return me;
    }
}