class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        // Store postorder indices
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(
            preorder, 0, preorder.length - 1,
            postorder, 0, postorder.length - 1
        );
    }

    private TreeNode build(
            int[] preorder, int preStart, int preEnd,
            int[] postorder, int postStart, int postEnd) {

        if (preStart > preEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        // Only one node
        if (preStart == preEnd)
            return root;

        // Next preorder element is left subtree root
        int leftRoot = preorder[preStart + 1];

        // Find it in postorder
        int index = map.get(leftRoot);

        // Size of left subtree
        int leftSize = index - postStart + 1;

        // Build left subtree
        root.left = build(
            preorder,
            preStart + 1,
            preStart + leftSize,

            postorder,
            postStart,
            index
        );

        // Build right subtree
        root.right = build(
            preorder,
            preStart + leftSize + 1,
            preEnd,

            postorder,
            index + 1,
            postEnd - 1
        );

        return root;
    }
}