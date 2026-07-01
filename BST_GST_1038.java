class Solution {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {

        reverse(root);

        return root;
    }

    private void reverse(TreeNode root) {

        if (root == null)
            return;

        reverse(root.right);

        sum += root.val;
        root.val = sum;

        reverse(root.left);
    }
}