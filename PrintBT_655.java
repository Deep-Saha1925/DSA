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
    public List<List<String>> printTree(TreeNode root) {
         int h = height(root);

        int rows = h + 1;
        int cols = (1 << (h + 1)) - 1;

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            List<String> row = new ArrayList<>();

            for (int j = 0; j < cols; j++)
                row.add("");

            ans.add(row);
        }
    }
}