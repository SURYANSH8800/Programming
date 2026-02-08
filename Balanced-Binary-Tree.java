1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean isBalanced(TreeNode root) {
18        return height(root) != -1;
19    }
20    private int height(TreeNode root){
21        if(root==null) return 0;
22        int lh = height(root.left);
23        if(lh == -1) return -1;
24        int rh = height(root.right);
25        if(rh == -1) return -1;
26        int diff = lh - rh;
27        if(Math.abs(diff) > 1) return -1;
28        return Math.max(lh,rh)+1;
29    }
30}