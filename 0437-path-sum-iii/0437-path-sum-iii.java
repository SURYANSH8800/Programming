
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return helper(root,(long)targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }

    private int helper(TreeNode root, long sum) {
        if (root == null) return 0;

        int res = 0;
        if (root.val == sum) res++;

        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);

        return res;
    }
}