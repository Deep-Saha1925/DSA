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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int l, int r){
        if(l > r)   return null;

        int maxIdx = l;

        for(int i=l; i<=r; i++){
            if(nums[i] > nums[maxIdx])
                maxIdx = i;
        }

        TreeNode root = new TreeNode(nums[maxIdx]);

        root.left = helper(nums, l, maxIdx-1);
        root.right = helper(nums, maxIdx+1, r);

        return root;
    }
}