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
    public boolean isValidBST(TreeNode root) {
        List<Integer> l1 = helper(root);
        for(int i = 0;i<l1.size()-1;i++){
            if(l1.get(i) >= l1.get(i+1)) return false;
        }
        return true;
    }
    public List<Integer> helper(TreeNode root){
        List<Integer> l1 = new ArrayList<>();
        h(root,l1);
        return l1;
    }
    public void h(TreeNode root,List<Integer> l1){
        if(root == null) return;
        h(root.left,l1);
        l1.add(root.val);
        h(root.right,l1);
    }
}