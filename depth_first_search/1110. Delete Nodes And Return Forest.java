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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
         List<TreeNode> ans = new ArrayList<>();
        // Set<Integer> toDeleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        dfs(root, set, true, ans);
        return ans;
    }
    private TreeNode dfs(TreeNode root, Set<Integer> set, boolean isRoot,List<TreeNode> ans) {
        if (root == null){
            return null;
        }
        final boolean deleted = set.contains(root.val);
        if(isRoot && !deleted){
            ans.add(root);
        }
        // If root is deleted, both children have the possibility to be a new root
        root.left = dfs(root.left, set, deleted, ans);
        root.right = dfs(root.right, set, deleted, ans);

        return deleted ? null : root;
  }
}