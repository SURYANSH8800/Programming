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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> l1 = new ArrayList<>();
        inorder(root,l1);
        return twosum(l1,k);
    }
    private void inorder(TreeNode root,List<Integer> l1){
        if(root==null) return;
        inorder(root.left,l1);
        l1.add(root.val);
        inorder(root.right,l1);
    }
    private boolean twosum(List<Integer> l1,int k){
        int l = 0;
        int r = l1.size()-1;
        while(l<r){
            int sum = l1.get(l)+l1.get(r);
            if(sum == k) return true;
            if(sum < k) l++;
            else r--;
        }
        return false;
    }
}