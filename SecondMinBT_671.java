class Solution {

    long ans = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {

        int min = root.val;

        dfs(root, min);

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private void dfs(TreeNode node, int min) {

        if (node == null)
            return;

        if (node.val > min) {
            ans = Math.min(ans, node.val);
        }

        dfs(node.left, min);
        dfs(node.right, min);
    }
}