class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        dfs(root, val, 1, depth);

        return root;
    }

    private void dfs(TreeNode root, int val, int level, int depth) {

        if (root == null)
            return;

        if (level == depth - 1) {

            TreeNode oldLeft = root.left;
            TreeNode oldRight = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = oldLeft;
            root.right.right = oldRight;

            return;
        }

        dfs(root.left, val, level + 1, depth);
        dfs(root.right, val, level + 1, depth);
    }
}