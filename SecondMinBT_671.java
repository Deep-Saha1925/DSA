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
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;

        dfs(root, min);

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private void dfs(TreeNode root, int min){
        if(root == null) return;

        if(root.val > min)
            ans = Math.min(ans, root.val);

            
    }
}