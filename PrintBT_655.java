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

        fill(root, ans, 0, 0, cols - 1);

        return ans;
    }

    private void fill(TreeNode root,
                      List<List<String>> ans,
                      int row,
                      int left,
                      int right) {

        if (root == null)
            return;

        int mid = (left + right) / 2;

        ans.get(row).set(mid, String.valueOf(root.val));

        fill(root.left, ans, row + 1, left, mid - 1);
        fill(root.right, ans, row + 1, mid + 1, right);
    }

    private int height(TreeNode root) {

        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left),
                            height(root.right));
    }
}