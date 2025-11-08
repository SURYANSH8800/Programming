class Solution {
    //brute force
    // public void recoverTree(TreeNode root) {
    //     List<TreeNode> l1 = new ArrayList<>();
    //     List<Integer> vals = new ArrayList<>();
    //     inorder(root, l1, vals);
    //     Collections.sort(vals);
    //     for (int i = 0; i < l1.size(); i++) {
    //         l1.get(i).val = vals.get(i);
    //     }
    // }

    // private void inorder(TreeNode root, List<TreeNode> l1, List<Integer> vals) {
    //     if (root == null) return;

    //     inorder(root.left, l1, vals);
    //     l1.add(root);
    //     vals.add(root.val);
    //     inorder(root.right, l1, vals);
    // }


    // OPTIMAL APPROACH USED 2 POINTER LIKE NODES FOR POINTING THE FAULTY NODE THEN SWAP THEM
    TreeNode a;
    TreeNode b;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev!=null&&prev.val>root.val) {
            if(a==null) a = prev;
            b = root;
        }
        prev = root;
        inorder(root.right);
    }
}
