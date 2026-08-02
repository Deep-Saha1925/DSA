class Solution {

    public String tree2str(TreeNode root) {

        if (root == null)
            return "";

        String ans = String.valueOf(root.val);

        if (root.left != null || root.right != null) {
            ans += "(" + tree2str(root.left) + ")";
        }

        if (root.right != null) {
            ans += "(" + tree2str(root.right) + ")";
        }

        return ans;
    }
}