/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l1 = new ArrayList<>();
        helper(root, "", l1);
        return l1;
    }

    private void helper(TreeNode root, String path, List<String> l1) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            l1.add(path + root.val);
            return;
        }
        helper(root.left, path + root.val + "->", l1);
        helper(root.right, path + root.val + "->", l1);
    }
}
