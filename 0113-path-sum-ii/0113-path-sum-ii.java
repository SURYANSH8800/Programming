class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> bl = new ArrayList<>();
        List<Integer> sl = new ArrayList<>();
        helper(root, targetSum, sl, bl);
        return bl;
    }

    private void helper(TreeNode root, int ts, List<Integer> sl, List<List<Integer>> bl) {
        if (root == null) return;

        sl.add(root.val);

        if (root.left == null && root.right == null && root.val == ts) {
            bl.add(new ArrayList<>(sl)); 
        }
        helper(root.left, ts - root.val, sl, bl);
        helper(root.right, ts - root.val, sl, bl);
        sl.remove(sl.size() - 1);
    }
}
