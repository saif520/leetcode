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
    public int min(TreeNode root){
		TreeNode temp = root;
		while(temp.left != null) temp = temp.left;
		return temp.val;
	}
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
		if(key < root.val){  // find the val to be deleted
			root.left = deleteNode(root.left,key);
			return root;
		}else if(key > root.val){
			root.right = deleteNode(root.right,key);
			return root;
		}else{// i have found the node, this node should be deleted
			if(root.left== null && root.right == null){//leaf node
				return null;
			}else if(root.left == null && root.right!=null){//i have only left child
				return root.right;
			}else if(root.left != null && root.right == null){//i have only right child
				return root.left;
			}else{//having both children
				//minimum val from my right subtree
				int minFromRight = min(root.right);
				root.val = minFromRight;
				root.right = deleteNode(root.right,minFromRight);
				return root;
			}
		}
		
    }
}