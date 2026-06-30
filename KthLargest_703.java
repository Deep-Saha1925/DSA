class Solution {

    int count = 0;
    int ans = 0;

    public int kthLargest(TreeNode root, int k) {
        reverseInorder(root, k);
        return ans;
    }

    private void reverseInorder(TreeNode root, int k) {

        if (root == null)
            return;

        reverseInorder(root.right, k);

        count++;
        if (count == k) {
            ans = root.val;
            return;
        }

        reverseInorder(root.left, k);
    }
}