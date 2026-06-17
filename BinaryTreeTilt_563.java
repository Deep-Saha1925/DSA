/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 * }
 */

class Solution {

    int totalTilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return totalTilt;
    }

    private int dfs(TreeNode root) {

        if (root == null)
            return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        totalTilt += Math.abs(leftSum - rightSum);

        return root.val + leftSum + rightSum;
    }
}