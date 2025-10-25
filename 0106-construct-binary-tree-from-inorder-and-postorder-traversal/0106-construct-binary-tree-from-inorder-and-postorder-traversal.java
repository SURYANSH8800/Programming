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
    public TreeNode buildTree(int[] in, int[] post) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        TreeNode root = h(in,0,in.length-1,post,0,post.length-1,map);
        return root;
    }
    private TreeNode h(int[] in, int ist, int ied, int[] post, int pst, int ped, HashMap<Integer,Integer> map){
        if (pst > ped || ist > ied) return null;
        TreeNode root = new TreeNode(post[ped]);
        int iroot = map.get(root.val);
        int numl = iroot-ist;
        root.left = h(in,ist,iroot-1,post,pst,pst+numl-1,map);
        root.right = h(in,iroot+1,ied,post,pst+numl,ped-1,map);
        return root;
    }

}