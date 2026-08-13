class Solution {

    public List<TreeNode> allPossibleFBT(int n) {

        List<TreeNode> result = new ArrayList<>();

        // Full binary tree cannot have even nodes
        if (n % 2 == 0)
            return result;

        // One node
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        // Try every possible left subtree size
        for (int leftNodes = 1; leftNodes < n; leftNodes += 2) {

            int rightNodes = n - 1 - leftNodes;

            List<TreeNode> leftTrees =
                    allPossibleFBT(leftNodes);

            List<TreeNode> rightTrees =
                    allPossibleFBT(rightNodes);

            // Combine every left tree with every right tree
            for (TreeNode left : leftTrees) {

                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(0);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }
}