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
        
    }
}